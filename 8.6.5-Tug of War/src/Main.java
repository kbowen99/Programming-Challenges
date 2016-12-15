import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numGames = sc.nextInt();
		for (int useLess = 0; useLess < numGames; useLess++){
			int cases = sc.nextInt();
			int [] weight = new int[100]; // <= 100 people at picnic (From problem Statement)
			boolean[] minWeight  = new boolean[(450 * 100 + 50) / 2]; //Weight = 1-450; 0-100 people; Each Team can only hold ~1/2 the people
			int[] minPeople = new int[(450 * 100 + 50) / 2];
			int[] maxPeople = new int[(450 * 100 + 50) / 2];
			int allTheWeight = 0;
			//Get all the peoples
			for (int i = 0; i < cases; i++)
				allTheWeight += weight[i] = sc.nextInt();
			//Prepare the arrays (set Base Value)
			for (int i = 0; i < minWeight.length; i++){
				minWeight[i] = (i == 0 ? true : false);
				minPeople[i] = (i == 0 ? 0 : Integer.MAX_VALUE);
				maxPeople[i] = 0;
			}
			//Black Magic (Check EVERY POSSIBLE WAY to Distribute Mass)
			for (int i = 0; i < cases; i++)
				for (int j = allTheWeight/2 + 5; j >= 0; j--)
					if (minWeight[j]){
						minWeight [j + weight [i]] = true;
	                    if ( minPeople [j + weight [i]] > minPeople [j] + 1)
	                        minPeople [j + weight [i]] = minPeople [j] + 1;
	                    if ( maxPeople [j + weight [i]] < maxPeople [j] + 1)
	                        maxPeople [j + weight [i]] = maxPeople [j] + 1;
					}
			for ( int i = allTheWeight / 2; i >= 0; i-- ) 
	            if ( minWeight [i] && ((minPeople [i] <= cases / 2 && maxPeople [i] >= cases / 2) || (minPeople [i] <= cases / 2 + cases % 2 && maxPeople [i] >= cases / 2 + cases % 2)) ) {
	                System.out.println(i + " " + (allTheWeight - i)); break;
	            }
		}
		sc.close();
	}
	
	
	/* Ignore old code. Correct Way is to calculate all possibilities rapidly, and compare from there out (comp. all Permutations)
	 * This Code is left as an example (reSort() is an awesomely effective Recursive Function (I'm A little proud of how fast it is)
	 */
	@Deprecated
	public static String pSort(String o1, String o2){
		//return o1;
		int o1d = Math.abs(Integer.parseInt(o1.substring(0, o1.indexOf(" "))) - Integer.parseInt(o1.substring(o1.indexOf(" ") + 1)));
		int o2d = Math.abs(Integer.parseInt(o2.substring(0, o2.indexOf(" "))) - Integer.parseInt(o2.substring(o2.indexOf(" ") + 1)));
		return (o1d < o2d ? o1 : o2);
	}
	
	@Deprecated
	public static String newSort(ArrayList<Integer> Team1, ArrayList<Integer> Team2, ArrayList<Integer> people, boolean dir){
		if (people.size() == 0){ //No More Weight
			reSort(Team1, Team2, false);
			return (getTeamWeight(Team1) < getTeamWeight(Team2) ? getTeamWeight(Team1) + " " + getTeamWeight(Team2) : getTeamWeight(Team2) + " " + getTeamWeight(Team1));
		}
		if (dir){ //T1 gains Weight
			if (getTeamWeight(Team1) > getTeamWeight(Team2))//T1 Gains Little Weight
				Team1.add(people.remove(0));
			else
				Team1.add(people.remove(people.size() - 1));
			return newSort(Team1,Team2,people,!dir);
		} else { //T2 Gains Weight
			if (getTeamWeight(Team2) > getTeamWeight(Team1)) //T2 Small Gain
				Team2.add(people.remove(0));
			else
				Team2.add(people.remove(people.size() - 1));
			return newSort(Team1,Team2,people,!dir);
		}
	}
	
	@Deprecated
	private static boolean reSort(ArrayList<Integer> Team1, ArrayList<Integer> Team2, boolean f){
		int d = Math.abs(getTeamWeight(Team1) - getTeamWeight(Team2));
		for (int T1 = 0; T1 < Team1.size(); T1++)
			for (int T2 = 0; T2 < Team2.size(); T2++){
				int nT1w = (getTeamWeight(Team1) - Team1.get(T1) + Team2.get(T2));
				int nT2w = (getTeamWeight(Team2) - Team2.get(T2) + Team1.get(T1));
				if (Math.abs(nT1w - nT2w) < d){
					Team2.add(Team1.remove(T1));
					Team1.add(Team2.remove(T2));
					return reSort(Team1, Team2, false);
				}
			}
		if (!f)
			return reSort(Team2, Team1, true);
		return false;
	}
	
	@Deprecated
	private static int getTeamWeight(ArrayList<Integer> team){
		int total = 0;
		for (Integer i : team)
			total += i;
		return total;
	}
	
	@Deprecated
	public static String lazySort(ArrayList<Integer> people){
		ArrayList<Integer> Team1 = new ArrayList<Integer>(people.subList(0, people.size() / 2));
		ArrayList<Integer> Team2 = new ArrayList<Integer>(people.subList(people.size() / 2, people.size()));
		reSort(Team1, Team2, false);
		return (getTeamWeight(Team1) < getTeamWeight(Team2) ? getTeamWeight(Team1) + " " + getTeamWeight(Team2) : getTeamWeight(Team2) + " " + getTeamWeight(Team1));
	}
}
