import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int size = sc.nextInt(); size != 0; size = sc.nextInt()){
			int count = sc.nextInt();
			long[] B1 = new long[9];
			long[] B2 = new long[9];
			
			long[][] B1Combo = new long[9][65];
			long[][] B2Combo = new long[9][65];
			
			//The Great Initializer (it Aint Pretty, and it easy to screw up)
			for (int i = 0; i <= size; i++){
				if (i > 0){
					B1[i] = (i % 2 == 0 ? B1[i - 1] : i);
					if (i < size)
						B2[i] = (i % 2 == 0 ? B2[i - 1] : i + 1);
				}
				B1Combo[i][0] = 1;
				if (i < size)
					B2Combo[i][0] = 1;
			}
			
			//MATHS - Thanks Wolfram
			for (int i = 1; i <= size; i++)
				for (int j = 1; j <= count && j <= i; j++){
					if (i < size)
						B2Combo[i][j] = B2Combo[i-1][j] + B2Combo[i-1][j-1] * (B2[i] - j + 1);
					B1Combo[i][j] = B1Combo[i-1][j] + B1Combo[i-1][j-1] * (B1[i] - j + 1);
				}
			//Yet Another For loop... So Many Iterations
			long total = 0;
			for (int i = 0; i <= count; i++)
				total += B1Combo[size][i] * B2Combo[size - 1][count - i];
			System.out.println(total);
		}
		sc.close();
	}

}
