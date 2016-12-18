public class Triple implements Comparable<Triple> {
	int from;
	int to;
	double weight;

	public Triple(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	public double getWeight(){
		return this.weight;
	}
	public int getTo(){
		return this.to;
	}
	public int getFrom(){
		return this.from;
	}
	
	@Override
	public int compareTo(Triple other) {
		return (new Double(this.weight)).compareTo(new Double(other.getWeight()));
	}
}
