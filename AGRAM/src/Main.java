import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for (int u = 0; u < 5; u++){
			String input = sc.nextLine();
			for (String s : input.split(","))
				System.out.println(s.trim().toCharArray()[0]);
		}
		sc.close();
	}
}
