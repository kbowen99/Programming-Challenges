import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	final static boolean DEBUG = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.nextLine();
			Scanner numScan = new Scanner(input);
			// numScan.useDelimiter("[^0-9]+");
			numScan.nextInt();
			ArrayList<Integer> nums = new ArrayList<>();
			ArrayList<Integer> diffs = new ArrayList<>();

			// input numbers
			while (numScan.hasNextInt())
				nums.add(numScan.nextInt());

			// calculate diffs
			int lastDiff = Integer.MAX_VALUE;
			for (int i = 1; i < nums.size(); i++) {
				int currScan = nums.get(i);
				int lastScan = nums.get(i - 1);
				int diff = Math.abs(lastScan - currScan);
				lastDiff = diff;
				addLogically(diffs, lastDiff);
			}

			// check diffs
			System.out.println((isJolly(diffs) ? "Jolly" : "Not jolly"));

			if (DEBUG) {
				System.out.println("INPUT:");
				for (int i : nums)
					System.out.print(i + " ");
				System.out.println();
				System.out.println("OUTPUT:");
				for (int i : diffs)
					System.out.print(i + " ");
				System.out.println();
				System.out.println();
			}
			// if (nums.size() == 1)
			// System.out.println("Jolly");
			// else {
			// int lastDiff = Integer.MAX_VALUE;
			// for (int i = 1; i < nums.size(); i++) {
			// int currScan = nums.get(i);
			// int lastScan = nums.get(i - 1);
			// int diff = Math.abs(lastScan - currScan);
			// if (diff > lastDiff) {
			// System.out.println("Not jolly");
			// break;
			// }
			// if (i == nums.size() - 1)
			// System.out.println("Jolly");
			// lastDiff = diff;
			// }
			// }

			numScan.close();
		}
		sc.close();
	}

	private static void addLogically(ArrayList<Integer> addTo, int addee) {
		if (addTo.size() == 0) {
			addTo.add(addee);
		} else {
			for (int i = 0; i < addTo.size(); i++) {
				if (addee > addTo.get(i)) {
					addTo.add(i, addee);
					break;
				}
			}
			if (!addTo.contains(addee)) {
				addTo.add(addee);
			}
		}

	}

	private static boolean isJolly(ArrayList<Integer> diffs) {
		if (diffs.size() == 0)
			return true;		
		if (!diffs.contains(1))
			return false;
		if (diffs.size() > 0) {
			int lastDiff1 = diffs.get(0);
			for (int check : diffs) {
				if (!(check == lastDiff1 || check == (lastDiff1 - 1))) {
					return false;
				}
				lastDiff1 = check;
			}
		}
		return true;
	}

}
