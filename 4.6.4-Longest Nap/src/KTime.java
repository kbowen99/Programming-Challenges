import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class KTime implements Comparator, Comparable {
	int hour;
	int min;
	
	/**
	 * Initialize a new K-Time Object
	 * @param sHour Hour of Time
	 * @param sMin Minute of Time
	 */
	public KTime(int sHour, int sMin){
		this.hour = sHour;
		this.min = sMin;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public String toString(){
		return this.hour + ":" + (this.min > 10 ? this.min : "0" + this.min);
	}

	@Override
	public int compareTo(Object arg0) {
		return this.compare(this, arg0);
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		return ((((KTime)arg0).getHour() * 60) + ((KTime)arg0).getMin()) - ((((KTime)arg1).getHour() * 60) + ((KTime)arg1).getMin());
	}
	
	public boolean equals(KTime other){
		if (this.hour != other.getHour())
			return false;
		if (this.min != other.getMin())
			return false;
		return true;
	}
}
