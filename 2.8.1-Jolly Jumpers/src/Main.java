import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.nextLine();
			Scanner numScan = new Scanner(input);
			// numScan.useDelimiter("[^0-9]+");
			numScan.nextInt();
			ArrayList<Integer> nums = new ArrayList<>();

			// input numbers
			while (numScan.hasNextInt())
				nums.add(numScan.nextInt());

			// for (int i : nums)
			// System.out.println(i + " ");

			if (nums.size() == 1)
				System.out.println("Jolly");
			else {
				int lastDiff = Integer.MAX_VALUE;
				for (int i = 1; i < nums.size(); i++) {
					int currScan = nums.get(i);
					int lastScan = nums.get(i - 1);
					int diff = Math.abs(lastScan - currScan);
					if (diff > lastDiff) {
						System.out.println("Not jolly");
						break;
					}
					if (i == nums.size() - 1)
						System.out.println("Jolly");
					lastDiff = diff;
				}
			}

			// int lastScan = numScan.nextInt();
			// int lastDiff = Integer.MAX_VALUE;
			// while (numScan.hasNextInt()){
			// int scan = numScan.nextInt();
			// int diff = Math.abs(lastScan - scan);
			// if (diff > lastDiff || diff == 0){
			// System.out.println("Not jolly"); break;
			// }
			// if (!numScan.hasNextInt()){
			// System.out.println("Jolly"); break;
			// }
			// lastScan = scan;
			// lastDiff = diff;
			// }

			numScan.close();
		}
		sc.close();
	}

}
