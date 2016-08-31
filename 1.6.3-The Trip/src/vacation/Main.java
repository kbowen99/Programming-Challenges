package vacation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()){
			int students = sc.nextInt();
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
				if (diff > 0)
					pDiff += diff;
				else
					nDiff += diff;
			}
			System.out.println((pDiff < (Math.abs(nDiff)) ? pDiff : (nDiff * -1)));
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
