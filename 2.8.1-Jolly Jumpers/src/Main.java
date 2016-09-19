import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			String input = sc.nextLine();
			Scanner numScan = new Scanner(input);
			numScan.useDelimiter("[^0-9]+");
			
			int lastScan = numScan.nextInt();;
			int lastDiff = Integer.MAX_VALUE;
			while (numScan.hasNextInt()){
				int scan = numScan.nextInt();
				int diff = Math.abs(lastScan - scan);
				if (diff > lastDiff || diff == 0){
					System.out.println("Not jolly"); break;
				}
				if (!numScan.hasNextInt()){
					System.out.println("Jolly"); break;
				}
				lastScan = scan;
				lastDiff = diff;
			}
			
			numScan.close();
		}
		sc.close();
	}

}
