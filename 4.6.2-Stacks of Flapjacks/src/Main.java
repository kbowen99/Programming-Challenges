import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static final boolean DEBUG = false;;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()){
			//Input Pancakes
			ArrayList<Integer> pancakes = new ArrayList<>();
			String input = sc.nextLine();
			Scanner numscan = new Scanner(input);
			while (numscan.hasNextLine())
				pancakes.add(numscan.nextInt());
			numscan.close();
			
			//Find correct order of flappjacks
			ArrayList<Integer> sortedFlapjacks = new ArrayList<>();
			for (Integer I : pancakes)
				sortedFlapjacks.add(I);
			Collections.sort(sortedFlapjacks);
			
			//___________________
			if (DEBUG){
				p("--------------------------------------");
				p("Input FlapJacks:");
				pList(pancakes);
				p("Goal FlapJacks:");
				pList(sortedFlapjacks);
			}
			//___________________
			
			if (!listIsEqual(pancakes, sortedFlapjacks)){
				
			}
			p("Input FlapJacks:");
			pList(pancakes);
			pancakes = flip(pancakes, 1);
			p("Flipped FlapJacks:");
			pList(pancakes);
		}
	}
	
	private static Object p(Object o){
		System.out.println(o.toString()); return o;
	}
	
	private static boolean listIsEqual(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		boolean isEqual = true;
		if (arr1.size() == arr2.size())
			for (int i = 0; i < arr1.size(); i++)
				if (arr1.get(i).intValue() != arr2.get(i).intValue())
					isEqual = false;
		else
			isEqual = false;
		
		return isEqual;
	}
	
	private static ArrayList<Integer> flip(ArrayList<Integer> toFlip, int FlipIndex){
		ArrayList<Integer> outList = new ArrayList<>();
		ArrayList<Integer> tmpList = new ArrayList<>();
		for (int i = FlipIndex; i < toFlip.size(); i++) //Get Flipped Portion
			tmpList.add(toFlip.get(i));
		for (int i = 0; i < FlipIndex; i++)
			outList.add(toFlip.get(i));
		for (int i = tmpList.size() - 1; i >= 0; i--)
			outList.add(tmpList.get(i));
		
		return outList;
	}
	
	private static void pList(ArrayList<Integer> toPrint){
		for (Integer I : toPrint)
			System.out.print(I.intValue() + " ");
		System.out.println();
	}
}
