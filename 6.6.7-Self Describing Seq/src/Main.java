import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] magical = calculateGoulumbSeq(673468); // Can't be just 700000 - Have to account for 0's
		for (int i = sc.nextInt(); i > 0; i = sc.nextInt())
			System.out.println(Bin(i, magical) + 1);
		sc.close();
	}
	
	private static int[] calculateGoulumbSeq(int until){
		int[] g = new int[until];
		//Just Enough to Guestimate Golombs Seq
		g[0] = 1;
		g[1] = 2;
		g[2] = 4;
		out: //"Continue" Point. Messy But Works
		for(int i = 1; true; i++) 
			for(int j = g[i]; j < g[i + 1]; j++) {
				if(g[g[i] - 1] > 2000000000)//Be Wary of Max Int
					break out;
				g[j] = g[j - 1] + i + 1;
			}
		return g;
	}
	
	/**
	 * Based On: http://stackoverflow.com/a/30245398
	 * I Like Recursive Functions....
	 * @param value - What We Looking For
	 * @param a - Array O Values
	 * @param lo - "Low" End of Binary Tree
	 * @param hi - "High" end
	 * @param lv - Last Value
	 * @return - A Hopefully Correct Number
	 */
	@Deprecated //JAVA NEEDS A BIGGER STACK SIZE
	public static int binarySearch(int value, int[] a, int lo, int hi, int lv){
		if (lo == -1 || hi == -1){
			lo = 0;
	        hi = a.length - 1;
	        lv = 0;
		}
		
		if (lo <= hi) {
            int mid = (lo + hi) / 2;
            lv = a[mid];
            if (value < lv) {
                hi = mid - 1;
            } else if (value > lv) {
                lo = mid + 1;
            } else {
                return lv;
            }
            return binarySearch(value, a, lo, hi, lv);
        }
        return hi;
	}
	
	public static int Bin(int value, int[] a) {
        int lo = 0,hi = a.length - 1, lastValue = 0;
        while (lo <= hi)
            if (value < (lastValue = a[(lo + hi) / 2]))
                hi = ((lo + hi)/2) - 1;
            else if (value > lastValue)
                lo = ((lo + hi)/2) + 1;
            else
                return ((lo + hi)/2);
        return hi; 
    }
}
