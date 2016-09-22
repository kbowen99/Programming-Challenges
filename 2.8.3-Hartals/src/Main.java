import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * Tval = Number of cases
		 */
		int Tval = sc.nextInt();
		for (int useless = 0; useless < Tval; useless++){
			/*
			 * nVals = Days to run
			 */
			int nVal = sc.nextInt();
			/*
			 * pVal = Number of Parties
			 */
			int pVal = sc.nextInt();
			/*
			 * Hartal Parameter (per party)
			 */
			int[] hVals = new int[pVal];
			
			//input Hvals
			for (int i = 0; i < pVal; i++)
				hVals[i] = sc.nextInt();
			
			/*
			 * Hartals/Party
			 */
			String[][] schedule = new String[pVal][nVal];
			
			//Plan Strikes
			for (int party = 0; party < pVal; party++)
				for (int day = 0; day < nVal; day++)
					schedule[party][day] = (day % hVals[party] == 0 ? "X" : "-");
			
			
			
			//Print Strikes
			System.out.println();
			for (int party = 0; party < pVal; party++){
				System.out.print("Party: " + party + "|");
				for (int day = 0; day < nVal; day++)
					System.out.print(schedule[party][day]);
				System.out.println();
			}
			
		}
		sc.close();
	}

}
