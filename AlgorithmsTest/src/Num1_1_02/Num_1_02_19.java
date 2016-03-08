package Num1_1_02;

/**
 * 字符串解析 
 * 由于eclipse中命令行参数要用空格区分 所以transaction中的空白字符换为*
 * 
 * @author he
 *
 */

class Data {
	int month;
	int day;
	int year;

	public Data(String data) {
		String filed[] = data.split("/");
		month = Integer.parseInt(filed[0]);
		day = Integer.parseInt(filed[1]);
		year = Integer.parseInt(filed[2]);

	}

	@Override
	public String toString() {

		return "month:" + month + " day:" + day + " year:" + year;
	}

}

class Transaction {
	String turing;
	String data;
	String price;

	public Transaction(String tur) {
		String filed[] = tur.split("\\*");
		turing = filed[0];
		data = filed[1];
		price = filed[2];

	}

	@Override
	public String toString() {

		return "name:" + turing + " data:" + data + " price:" + price;
	}

}

public class Num_1_02_19 {

	public static void main(String[] args) {
		System.out.println(new Data(args[0]));
		System.out.println(new Transaction(args[1]));
	}
}
