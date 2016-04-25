package Number_2;

/**
 * P155 定义一个可用于比较的数据类型
 * 
 * @author he
 *
 */
public class Date implements Comparable<Date> {
	private final int day;
	private final int month;
	private final int year;

	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}

	public int day() {
		return day;
	}

	public int month() {
		return month;
	}

	public int year() {
		return year;
	}

	public int compareTo(Date that) {
		if (this.year>that.year)    return +1;
		if (this.year<that.year)    return -1;
		if (this.month>that.month)  return +1;	
		if (this.month<that.month)  return -1;	
		if (this.year>that.year)    return +1;
		if (this.year<that.year)    return -1;
		return 0;
	}
	
	@Override
	public String toString() {
	
		return month+"/"+day+"/"+year;
	}

}
