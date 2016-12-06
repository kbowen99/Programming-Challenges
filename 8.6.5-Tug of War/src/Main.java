import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numGames = sc.nextInt();
		for (int useLess = 0; useLess < numGames; useLess++){
			ArrayList<Integer> peoples = new ArrayList<>(), t1 = new ArrayList<>(), t2 = new ArrayList<>();
			/*
			 * People The List
			 */
			int numPeople = sc.nextInt();
			for (int p = 0; p < numPeople; p++)
				peoples.add(sc.nextInt());
			Collections.sort(peoples);
			System.out.println(sorter(t1,t2,peoples,true));
		}
		sc.close();
	}
	
	private static String sorter(ArrayList<Integer> Team1, ArrayList<Integer> Team2, ArrayList<Integer> people, boolean dir){
		if (people.size() == 0){
			//makeAmericaGreatAgain(Team1,Team2);
			return getTeamWeight(Team1) + " " + getTeamWeight(Team2);
		} else
			if (T2T(Team1,Team2,people))
				return sorter(Team1,I2A(people.remove(people.size() - 1), Team2), people, dir);
			else
				return sorter(I2A(people.remove(people.size() - 1), Team1),Team2, people, dir);
	}
	
	private static int getTeamWeight(ArrayList<Integer> team){
		int total = 0;
		for (Integer i : team)
			total += i;
		return total;
	}
	
	private static ArrayList<Integer> I2A(int toAdd, ArrayList<Integer> arr){
		arr.add(toAdd);
		return arr;
	}
	
	private static boolean T2T(ArrayList<Integer> T1, ArrayList<Integer> T2, ArrayList<Integer> p){
		int DeltaT1Gains = Math.abs((getTeamWeight(T1) + p.get(p.size() - 1)) - getTeamWeight(T2));
		int DeltaT2Gains = Math.abs(getTeamWeight(T1) - (getTeamWeight(T2) + p.get(p.size() - 1)));
		return DeltaT1Gains >= DeltaT2Gains;
	}
	
	private static boolean makeAmericaGreatAgain(ArrayList<Integer> t1, ArrayList<Integer> t2){
		Collections.sort(t1);
		Collections.sort(t2);
		if (Math.abs(t1.size() - t2.size()) < 2){return true;} else {
			if (t1.size() > t2.size()){
				t2.add(t1.remove(0));
				return makeAmericaGreatAgain(t1, t2);
			} else 
				return makeAmericaGreatAgain(I2A(t2.remove(0), t1), t2);
		}
	}
}
