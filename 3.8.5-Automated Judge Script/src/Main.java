import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final boolean DEBUG = false;;;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int run = 1;
		try{
		while (sc.hasNextLine()){
			int StandardNumOut = Integer.parseInt(sc.nextLine());//First Line of input
			String[] StandardOutput = new String[StandardNumOut];
			for (int i = 0; i < StandardNumOut; i++) //Standard Output
				StandardOutput[i] = sc.nextLine();
			int TeamNumOut = Integer.parseInt(sc.nextLine());
			String[] TeamOutput = new String[TeamNumOut];
			for (int i = 0; i < TeamNumOut; i++) //Team Output
				TeamOutput[i] = sc.nextLine();
			
			if (DEBUG){
				p("Standard Out:");
				for (String s : StandardOutput)
					p(s);
				p("Team Out:");
				for (String s : TeamOutput)
					p(s);
			}
			
			if (arrIsEqual(TeamOutput, StandardOutput))
				p("Run #" + run + ": Accepted");
			else if (arrIsSimiliar(TeamOutput, StandardOutput))
				p("Run #" + run + ": Presentation Error");
			else
				p("Run #" + run + ": Wrong Answer");
			
			run++;
			
			if (DEBUG)
				p("------------------------------------------");
		}
		} catch (Exception e) {}
		sc.close();
	}
	
	private static boolean arrIsEqual(String[] arr1, String[] arr2){
		boolean isEqual = true;
		if (arr1.length != arr2.length)
			return false;
		for (int i = 0; i < arr1.length; i++)
			if (!arr1[i].equals(arr2[i])){
				isEqual = false;
				break;
			}
		return isEqual;
	}
	
	private static boolean arrIsSimiliar(String[] arr1, String[] arr2){
		boolean isEqual = true;
		ArrayList<Integer> inArr1 = new ArrayList<>();
		ArrayList<Integer> inArr2 = new ArrayList<>();
		
		//Get Every Int in Arr1
		for (String s : arr1){
			char[] currentline = s.toCharArray();
			for (char c : currentline){
				try{
					inArr1.add(Integer.parseInt(c + ""));
				} catch (Exception e){}
			}
		}
		
		//Get Every Int in Arr2
		for (String s : arr2){
			char[] currentline = s.toCharArray();
			for (char c : currentline){
				try{
					inArr2.add(Integer.parseInt(c + ""));
				} catch (Exception e){}
			}
		}
		
		if (DEBUG){
			p("INTS IN ARR1:");
			for (Integer i : inArr1)
				p(i.toString());
			p("INTS IN ARR2:");
			for (Integer i : inArr2)
				p(i.toString());
			
		}
		
		
		if (inArr1.size() == inArr2.size())
			for (int i =0; i < inArr1.size(); i++){
				if ((inArr1.get(i).intValue() == inArr2.get(i).intValue())){
					
				} else{
					isEqual = false;
				}
			}
		else
			isEqual = false;
		
		//-------------Old Version------------------
//		if (arr1.length != arr2.length)
//			return false;
//		for (int i = 0; i < arr1.length; i++){//for each element
//			char[] ar1Char = (arr1[i]).toCharArray();
//			for (char c1 : ar1Char){
//				if (!((arr2[i]).contains(c1 + "")))
//					if (c1 < 59)
//						isEqual = false;
//			}
//		}
		return isEqual;
	}
	
	public static void p(Object O){
		System.out.println(O.toString());
	}

}
