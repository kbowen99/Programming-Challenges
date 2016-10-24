import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCases = sc.nextInt();
		sc.nextLine();sc.hasNextLine();
		for (int useless = 0; useless < tCases; useless++){
			ArrayList<Fragment> fragments = new ArrayList<>();
			
			{//Containing Variable
				String in = sc.nextLine();
				while (!in.equals("")){ //Input all frags
					fragments.add(new Fragment(in));
					in = sc.nextLine();
				}
			}
			Collections.sort(fragments);
			
			for (Fragment s : fragments)
				System.out.println(s.getContents());
			System.out.println();
			
		}
	}

}
