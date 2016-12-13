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
			ArrayList<Integer> peoples2 = new ArrayList<>(peoples);
			Collections.sort(peoples);
			String nS = newSort(t1,t2,peoples,true);
			String lS = lazySort(peoples2);
			
			System.out.println(pSort(nS,lS) + "\n");
		}
		sc.close();
	}
	
	public static String pSort(String o1, String o2){
		int o1d = Math.abs(Integer.parseInt(o1.substring(0, o1.indexOf(" "))) - Integer.parseInt(o1.substring(o1.indexOf(" ") + 1)));
		int o2d = Math.abs(Integer.parseInt(o2.substring(0, o2.indexOf(" "))) - Integer.parseInt(o2.substring(o2.indexOf(" ") + 1)));
		return (o1d < o2d ? o1 : o2);
	}
	
	public static String newSort(ArrayList<Integer> Team1, ArrayList<Integer> Team2, ArrayList<Integer> people, boolean dir){
		if (people.size() == 0){ //No More Weight
			reSort(Team1, Team2, false);
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
