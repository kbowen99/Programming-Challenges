import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int useless = 0; useless < cases; useless++){
			int input = sc.nextInt();
			System.out.println((isSmith(input) ? "'Tis Smith" : "'Tisnt Smith"));
		}
		sc.close();
	}
	
	private static boolean isSmith(int num){
		if (isPrime(num))
			return false;
		if (sumFactors(num) == sumDigits(num))
			return true;
		return false;
	}
	
	private static boolean isPrime(int num){
		BigInteger test = new BigInteger(num + "");
		BigInteger adder = new BigInteger(num + "");
		return adder.equals((test.subtract(BigInteger.ONE)).nextProbablePrime());
	}
	
	private static int sumDigits(int num){
		String n = num + "";
		int sum = 0;
		for (int i = 0; i < n.length(); i++)
			sum += Integer.parseInt(n.substring(i, i+1));
		return sum;
	}
	
	private static int sumFactors(int num)
	{
	    int k = num;
	    int p = 2;
	    int sum = 0;
	    while(p!=-1&&num!=1)
	    {
	        int c = 0;
	        while(num%p==0&&num!=1)
	        {
	        	num = num/p;
	            c++;
	        }
	        sum= sum + c*sumDigits(p);
	        p++;
	    }
	    if(num==k)
	        return -1;
	    if(num!=1)
	        sum+=sumDigits(num);
	    return sum;
	}
}
