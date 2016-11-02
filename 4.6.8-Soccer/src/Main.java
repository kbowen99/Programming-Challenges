import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tournaments = Integer.parseInt(sc.nextLine()); // First Line of Input - # of Tournaments
		for (int TournyNum = 0; TournyNum < Tournaments; TournyNum++) {
			ArrayList<Team> scorecard = new ArrayList<>();
			String tournyName = sc.nextLine();
			// Enter each team
			{
				int tournyTeams = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < tournyTeams; i++)
					scorecard.add(new Team(sc.nextLine()));
			}
			// Read Each Entry
			{
				int tournyEntries = Integer.parseInt(sc.nextLine());
				for (int Entry = 0; Entry < tournyEntries; Entry++) {
					String input = sc.nextLine();
					String T1Name = input.substring(0, input.indexOf("#"));
					int T1Goals = Integer.parseInt(input.substring(input.indexOf("#") + 1, input.indexOf("@")));
					int T2Goals = Integer.parseInt(input.substring(input.indexOf("@") + 1, input.lastIndexOf("#")));
					String T2Name = input.substring(input.lastIndexOf("#") + 1);
					scorecard.get(findTeamIndex(scorecard, T1Name)).recordGame(T1Goals, T2Goals);
					scorecard.get(findTeamIndex(scorecard, T2Name)).recordGame(T2Goals, T1Goals);
				}
			}
			//update team Rankings
			updateTeamRankings(scorecard);
			
			System.out.println(tournyName);
			//print teams
			for (Team t : scorecard)
				System.out.println(t.toString());
			System.out.println();
			
		}
		sc.close();
	}
	
	private static int findTeamIndex(ArrayList<Team> listOTeams, String teamName){
		for (int t = 0; t < listOTeams.size(); t++)
			if (listOTeams.get(t).getName().equals(teamName))
				return t;
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	private static void updateTeamRankings(ArrayList<Team> listOTeams){
		Collections.sort(listOTeams);
		for (int r = 0; r < listOTeams.size(); r++){
			listOTeams.get(r).setRank(r + 1);
		}
	}

}
