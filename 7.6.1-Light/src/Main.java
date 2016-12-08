import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = 0;
		while ((n = sc.nextLong()) != 0)
			System.out.println((n == (Math.pow((long)Math.sqrt(n), 2)) ? "yes" : "no"));
		sc.close();
	}
}
