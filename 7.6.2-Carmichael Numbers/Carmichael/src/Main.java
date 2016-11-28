import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nums = " 561 1105 1729 2465 2821 6601 8911 10585 15841 29341 41041 46657 52633 62745 63973 75361 ",cNum = "";
		while (Integer.parseInt(cNum = sc.nextLine().trim()) != 0)
			System.out.println((nums.contains(" " + cNum + " ") ? "The number " + cNum + " is a Carmichael number." : cNum + " is normal."));
		sc.close();
	}
}
