import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Make sure both n1 + n2 == 0, as there are really mean test cases where one number is 0
		for(int n1 = sc.nextInt(), n2 = sc.nextInt(); (n1 + n2) != 0;n1 = sc.nextInt(), n2 = sc.nextInt()){
			int carries = 0, remainder = 0;
			while (n1 + n2 > 0){
				remainder = (n1 % 10 + n2 % 10 + remainder) / 10; //Add new Remainder (and Divide out old Remainder
				n1 /= 10; n2 /= 10; //Move over Decimal (drop excess -> floored)
				carries += remainder; //Keep Track of how many times you "Carry" the number
			}
			//Print it (With Required Formatting, I would never forget that...)
			System.out.println((carries > 0 ? (carries > 1 ? carries + " carry operations." : carries + " carry operation.") : "No carry operation."));
		}
		sc.close();
	}

}
