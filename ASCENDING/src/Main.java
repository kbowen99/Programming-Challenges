import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static String input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int RUN = 0; RUN < 5; RUN++){
			ArrayList<Integer> nums = new ArrayList<>();
			input = sc.nextLine();
			nums.add(Integer.parseInt(input.substring(1,1 + (Integer.parseInt(input.toCharArray()[0] + "")))));//Grab First Num
			input = input.substring((Integer.parseInt(input.toCharArray()[0] + "")) + 1);//Remove Used characters
			while (input.length() > 0){
				String CNUM = nextNum(nums," ");
				if (CNUM.length() > 0)
					nums.add(Integer.parseInt(CNUM));
			}
			for (Integer i : nums)
				System.out.print((!i.equals(nums.get(nums.size() - 1)) ? i + " " : i +"\n"));
		}
		sc.close();
	}
	
	private static String nextNum(ArrayList<Integer> numArray, String currNum){
		//System.out.println(input + "|" + currNum);
		if (input.length() == 0 && Integer.parseInt(currNum) < numArray.get(numArray.size() - 1))
			return "";
		if (currNum.trim().length() == 0){
			currNum = input.toCharArray()[input.length() - 1] + "";
			input = input.substring(0, input.length() - 1);
			return nextNum(numArray,currNum);
		}
		if (Integer.parseInt(currNum) < (numArray.get(numArray.size() - 1)) + 1){
			currNum += input.toCharArray()[input.length() - 1] + ""; 
			input = input.substring(0, input.length() - 1);
			return nextNum(numArray,currNum);
		}
		if (Integer.parseInt(currNum) >= numArray.get(numArray.size() - 1) + 1)
			return currNum;
		
		return nextNum(numArray,currNum);
	}

}
