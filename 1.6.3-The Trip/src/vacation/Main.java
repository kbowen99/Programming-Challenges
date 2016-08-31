package vacation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true){
			int students = sc.nextInt();
			if(students <= 0 || students > 1000) {
				break;
			}
			if (students == 0)
				break;
			double avg;
			double[] monies = new double[students];
			for (int i = 0; i < students; i++){
				monies[i] = sc.nextDouble();
			}
			avg = arrayAvg(monies);
			double pDiff = 0,nDiff = 0;
			for (double m : monies){
				double diff = (m - avg);
				diff = (double)Math.round(diff * 100d) / 100d;
				//diff = ((double)((int)(diff * 100.0))/100);
				if (diff > 0)
					pDiff += diff;
				else
					nDiff += diff;
			}
			
			double magic = (pDiff < (Math.abs(nDiff)) ? pDiff : (nDiff * -1));
			System.out.printf("$%.2f\n", magic);
		}
		sc.close();
	}
	
	public static double arrayAvg(double[] arr){
		double tmp = 0;
		for (double i : arr){
			tmp += i;
		}
		return (tmp / (double)arr.length);
	}

}
