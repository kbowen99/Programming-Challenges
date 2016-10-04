import java.util.Scanner;

public class Main {

	static char[] keyboard = {
			'`','1','2','3','4','5','6','7','8','9','0','-','=',
			'Q','W','E','R','T','Y','U','I','O','P','[',']','\\',
			'A','S','D','F','G','H','J','K','L',';','\'',
			'Z','X','C','V','B','N','M',',','.','/'
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()){
			String input = sc.nextLine();
			char[] inChar = input.toUpperCase().toCharArray();
			String output = "";
			
			for (char c : inChar){
				if (c == ' ')
					output += " ";
				else 
					for (int k = 0; k < keyboard.length; k++)
						if (c == keyboard[k]){
							output += keyboard[k-1];
							break;
						}
			}
			System.out.println(output);
		}
		sc.close();
	}
}
