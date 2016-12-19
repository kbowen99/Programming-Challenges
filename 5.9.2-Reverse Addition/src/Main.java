import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int CASES = sc.nextInt();
		for (int u = 0; u < CASES; u++){
			BigInteger input = sc.nextBigInteger();
			int count = 0;
			input = input.add(reverseInt(input));
			count++;
			while (!isPalindrone(input)){
				input = input.add(reverseInt(input));
				count++;
			}
			System.out.println(count + " " + input);
		}
		sc.close();
	}
	
	private static BigInteger reverseInt(BigInteger n){
		String out = "";
		for (char c : n.toString().toCharArray())
			out = c + out;
		return new BigInteger(out);
	}
	
	private static boolean isPalindrone(BigInteger n){
		return n.equals(reverseInt(n));
	}
}
