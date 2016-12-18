import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int n = sc.nextInt(); n != 0; n = sc.nextInt()){
			 int l = sc.nextInt();
			 ArrayList<ArrayList<Integer>> map = new ArrayList<>(); //2D ArrayList, because arrays are painful
			 for (int i = 0; i < n; i++)
				 map.add(new ArrayList<Integer>());
			 //"Color" Regions
			 for (int i = 0; i < l; i++){
				 int f = sc.nextInt(), t = sc.nextInt();
				 map.get(f).add(t);//"Connect" in Both Directions ('NonDirected')
				 map.get(t).add(f);
			 }
			 System.out.println((canColor(map,new int[n],0) ? "BICOLORABLE." : "NOT BICOLORABLE."));
		}
		sc.close();
	}
	/**
	 * Using Black Magic, Determine whether or not 2D ArrayList Map is "Traversable" (IE: Bicolorable)
	 * I Don't think you can get much more inefficient...
	 * @param map Them There Maps
	 * @param rc Array 'O Colors (Tracks through recursions)
	 * @param ci Color Indexer
	 * @return Black Magic (@BiColorable)
	 */
	public static boolean canColor(ArrayList<ArrayList<Integer>> map, int [] rc, int ci){
		boolean canColor = true;
		for (int i = 0; i < map.get(ci).size(); i++){//Navigate initial layer of ArrayList<>
			int c = rc[map.get(ci).get(i)]; //c = currColor, ci = currColorIndex, rc = color array?
			if (c == rc[ci] && c != 0)
				return false;
			else if (c == 0){ 
				rc[map.get(ci).get(i)] = (rc[ci] == 1 ? 2 : 1);//alternate color
				canColor = canColor && canColor(map, rc, map.get(ci).get(i));
			}
		}
		return canColor;
	}
}
