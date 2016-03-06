package E01;

public class CharIndex {

	public static void main(String[] args) {
		int hundredsDigit,tensDigit,unitsDigit;//hundredsDigit表示数字的百位，tensDigit表示数字的十位，unitsDigit表示数字的个位
		System.out.println("寻找Armstrong数：");
		for (int i = 100; i <= 999; i++) {
			//No.1
			//开始写代码，例如153可以满足1^3 + 5^3 + 3^3 = 153，这样的数称为Armstrong数，输出所有三位数中的Armstrong数
			hundredsDigit =i/100; 
			tensDigit = (i-hundredsDigit*100)/10;
			unitsDigit =i-hundredsDigit*100-tensDigit*10;
			if (hundredsDigit*hundredsDigit*hundredsDigit + unitsDigit*unitsDigit*unitsDigit +tensDigit*tensDigit*tensDigit ==i)
				System.out.print(i + " ");
			//end_code
		}
		System.out.println();
	}
}
