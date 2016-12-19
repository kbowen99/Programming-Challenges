import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			long total = 1;
			int pow = sc.nextInt();
			int IDK = sc.nextInt();
			for (int i =0; i < IDK; i++)
				total *= Factorial(sc.nextInt()); //longs and ints seem interchangeable....
			System.out.println(Factorial(pow) / total);
		}
		sc.close();
	}
	
	/**
	 * Why Isn't This Built in?
	 * @param f - To Factorial
	 * @return Factorial
	 */
	private static long Factorial(long f){
		if (f > 1)
			return f * Factorial(f - 1);
		return 1;
	}

}
