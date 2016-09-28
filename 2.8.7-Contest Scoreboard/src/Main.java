import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int runs = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		for (int r = 0; r < runs; r++) { // run Each "Case"
			ArrayList<Participant> peoples = new ArrayList<>(); // contains all
																// participants
			while (true) {
				String input = sc.nextLine();
				if (input.trim().equals(""))
					break;
				char charAtEnd = input.toCharArray()[input.length() - 1]; // get 'L'
				// get all numbers
				Scanner numScan = new Scanner(input);
				int contestant = numScan.nextInt();
				int problem = numScan.nextInt();
				int time = numScan.nextInt();
				numScan.close();
				// see if participant exists
				int index = -1;
				for (int i = 0; i < peoples.size(); i++)
					if (peoples.get(i).getContestantNum() == contestant)
						index = i;
				if (index == -1) {
					Participant nu = new Participant(contestant);
					peoples.add(nu);
					peoples.get(peoples.indexOf(nu)).addProblem(problem,time,charAtEnd);
				} else {
					peoples.get(index).addProblem(problem,time,charAtEnd);
				}
				
				Collections.sort(peoples);
			}
			for (Participant p : peoples){
				
				System.out.println(p.contestantNum + " " + p.correctProbs + " " + p.totalTime);
			}
			
			if (peoples.size() > 0)
				System.out.println();
			
		}
		sc.close();
	}
}
