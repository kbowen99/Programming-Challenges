import java.util.Scanner;

public class Main {
	static int[] xPrimes;
	static boolean[] cPrimes;
	public static void main(String[] args) {
		sieveOfEratosthenes(1000000);
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while ((n = sc.nextInt()) != 0){
			if (n < 8)
				System.out.println("Impossible.");
			else {
				if (n % 2 == 0)
					System.out.println("2 2 ");
				else
					System.out.println("2 3 ");
				
				n -= (4 + n % 2);
				
				for (int i = 0; i < xPrimes.length; i++)
					if (!cPrimes[n - xPrimes[i]]){
						System.out.println(xPrimes[i] + " " + xPrimes[i]);
						break;
					}
			}
		}
		sc.close();
	}
	
	/*
	 * I Have a very rough idea of what this is trying to do, but it looks like it works
	 * thanks wikipedia and stackOverflow
	 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * http://stackoverflow.com/questions/586284/finding-prime-numbers-with-the-sieve-of-eratosthenes-originally-is-there-a-bet
	 */
	public static void sieveOfEratosthenes(int X){
		cPrimes = new boolean[X + 1];
	    for (int i = 2; i * i <= X; i++) 
	        if (!cPrimes [i]) 
	            for (int j = i; i * j <= X; j++) 
	            	cPrimes [i*j] = true;
	    int numPrimes = 0;
	    for (int i = 2; i <= X; i++)
	        if (!cPrimes [i])
	        	numPrimes++;
	    xPrimes = new int [numPrimes];
	    int index = 0;
	    for (int i = 2; i <= X; i++)
	        if (!cPrimes [i])
	        	xPrimes [index++] = i;
	}
}