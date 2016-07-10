package Number_3;

import java.util.Date;

public class Transaction {
	private final String who;
	private final Date when;
	private final double amount;
	private int hash2;//用于保存一个对象计算过的hashCode

	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.amount = amount;
		this.when = when;
	}

	@Override
	public int hashCode() {
		if (hash2 != 0) {
			return hash2;
		}
		int hash = 17;
		hash = 31 * hash + who.hashCode();
		hash = 31 * hash + when.hashCode();
		hash = 31 * hash + ((Double) amount).hashCode();
		hash2=hash;
		return hash;
	}

	public static void main(String[] args) {
		Transaction t = new Transaction("A", new Date(), 1.0);
		System.out.println(t.hashCode());
		System.out.println(t.hashCode());
		Transaction t2=new Transaction("B", new Date(), 2.0);
		System.out.println(t2.hashCode());
	}

}
