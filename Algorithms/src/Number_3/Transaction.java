package Number_3;

import java.util.Date;

public class Transaction {
       private final String who;
       private final Date when;
       private final double amount;
       
       public Transaction(String who, Date when,double amount) {
		      this.who=who;
		      this.amount=amount;
		      this.when=when;
	}
       
       @Override
    public int hashCode() {
    	int hash=17;
    	hash=31*hash+who.hashCode();
    	hash=31*hash+when.hashCode();
    	hash=31*hash+((Double)amount).hashCode();
    	return hash;
    }
       
}
