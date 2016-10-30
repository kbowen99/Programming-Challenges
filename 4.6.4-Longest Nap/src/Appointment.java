import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Appointment implements Comparator, Comparable{
	KTime startTime;
	KTime endTime;
	String title;
	
	/**
	 * Create New Appointment using KTime Objects
	 * @param start Starting Time
	 * @param end Ending Time
	 * @param Title Appointment Title
	 */
	public Appointment(KTime start, KTime end, String Title){
		this.startTime = start;
		this.endTime = end;
		this.title = Title;
	}
	
	/**
	 * Generate a new appointment without using KTime Objects
	 * @param startHour
	 * @param startMin
	 * @param endHour
	 * @param endMin
	 * @param Title
	 */
	public Appointment(int startHour, int startMin, int endHour, int endMin, String Title){
		this.startTime = new KTime(startHour, startMin);
		this.endTime = new KTime(endHour, endMin);
		this.title = Title;
	}

	@Override
	public int compareTo(Object o) {
		return this.compare(this, o);
	}

	@Override
	public int compare(Object o1, Object o2) {
		return ((Appointment)o1).getStartTime().compareTo(((Appointment)o2).getStartTime());
	}

	public KTime getStartTime() {
		return startTime;
	}

	public void setStartTime(KTime startTime) {
		this.startTime = startTime;
	}

	public KTime getEndTime() {
		return endTime;
	}

	public void setEndTime(KTime endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString(){
		return this.startTime.toString() + " To " + this.endTime.toString() + " - " + this.title;
	}
	
	public KTime getDuration(){
		return new KTime(getDurationInMin() / 60, getDurationInMin() % 60);
	}
	
	public int getDurationInMin(){
		int startingInMin = (this.getStartTime().getHour() * 60) + this.getStartTime().getMin();
		int endingInMin = (this.getEndTime().getHour() * 60) + this.getEndTime().getMin();
		return endingInMin - startingInMin;
	}
}
