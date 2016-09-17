package Number_5;

import java.math.BigInteger;
import java.util.Random;

/**
 * P508 算法5.8 Rabin-Karp指纹字符串查找算法 
 * 使用蒙特卡洛算法的运行时间是线性级别的且出错的概率小（非常小），
 * 拉斯维加斯算法能够保证正确性且性能极其接近线性级别
 *
 * args[0]:AACAA 
 * args[1]:AABRAACADABRAACAADABRA
 * 
 * @author he
 *
 */
public class RabinKarp {
	private String pat;// 用于拉斯维加斯算法的check
	private long patHash;// 模式字符串的散列值
	private int M;// 模式字符串的长度
	private long Q;// 一个很大的素数
	private int R = 256;// 8为ASCII表的元素数量
	private long RM;// R^(M-1)%Q

	public RabinKarp(String pat) {
		this.pat = pat;
		this.M = pat.length();
		Q = longRandomPrime();
		RM = 1;
		// 计算R^(M-1)%Q
		for (int i = 1; i <= M - 1; i++)
			RM = (R * RM) % Q;
		patHash = hash(pat, M);
	}

	public int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt, M);// 获取文本前M个字符串的hash值
		if (txtHash == patHash && check(0)) // 一开始就命中
			return 0;
		// 文本字符开始右移并进行匹配
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;

			/**
			 * 上面两行等价于下面这一行代码，见书中图5.3.17 i>=5的部分
			 */
			// txtHash=((txtHash+txt.charAt(i-M)*(Q-RM))*R+txt.charAt(i))%Q;

			if (patHash == txtHash)
				if (check(i - M + 1))
					return i - M + 1;// 找到匹配

		}
		return N;// 未找到匹配

	}

	// 可蒙特算法
	public boolean check(int i) {
		return true;
	}

	// 拉斯维加斯算法
	public boolean check(String txt, int i) {
		for (int j = 0; j < M; j++) {
			if (txt.charAt(j + i) != pat.charAt(j))
				return false;
		}

		return true;
	}

	// 计算字符串的散列值
	private long hash(String key, int M) {
		long h = 0;
		for (int i = 0; i < M; i++)
			h = (R * h + key.charAt(i)) % Q;
		return h;
	}

	// 返回31位的随机素数
	private long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();// 转换为long类型
	}

	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		RabinKarp kmp = new RabinKarp(pat);
		System.out.println("text:   " + txt);
		int offset = kmp.search(txt);
		System.out.print("pattern:");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pat);
	}

}
