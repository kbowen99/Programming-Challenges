import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Fragment implements Comparator<Fragment>, Comparable {
	String contents;
	public Fragment(String frag){
		this.contents = frag;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public int compare(Fragment arg0, Fragment arg1) {
		return arg0.getContents().length() - arg1.getContents().length();
	}
	@Override
	public int compareTo(Object o) {
		return compare(this, (Fragment)o);
	}
}
