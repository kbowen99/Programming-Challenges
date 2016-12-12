import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger[] fibbSeq = new BigInteger[482];
		fibbSeq[0] = BigInteger.ZERO;
		fibbSeq[1] = BigInteger.ONE;
		for (int i = 2; i < fibbSeq.length; i++)
			fibbSeq[i] = fibbSeq[i - 2].add(fibbSeq[i - 1]);
		while (sc.hasNextBigInteger()){
			BigInteger lesser = sc.nextBigInteger();
			BigInteger larger = sc.nextBigInteger();
			if (lesser.compareTo(larger) > 0){
				BigInteger tmp = lesser;
				lesser = larger;
				larger = tmp;
			}
			if (lesser.equals(BigInteger.ZERO) || larger.equals(BigInteger.ZERO)){
				if (larger.add(lesser).equals(BigInteger.ZERO))
					break;
				//System.out.println("1");
				//continue;
			}
			int c = 0;
			for (int i = 2; i < fibbSeq.length; i++)
				if (cBI(fibbSeq[i], lesser, '>'))
					if (cBI(fibbSeq[i],larger, '<'))
						c++;
					else
						break;
			System.out.println(c);				
		}
		sc.close();
	}
	
	public static boolean cBI(BigInteger left, BigInteger right, char dir){
		if (dir == '>')
			return left.compareTo(right) >= 0;
		return left.compareTo(right) <= 0;
	}

}
