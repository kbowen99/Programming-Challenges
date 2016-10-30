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
			////ArrayList<Integer> sortedFlapjacks = new ArrayList<>();
			////for (Integer I : pancakes)
				////sortedFlapjacks.add(I);
			////Collections.sort(sortedFlapjacks);
			
			//___________________
			if (DEBUG){
				p("--------------------------------------");
				p("Input FlapJacks:");
				pList(pancakes);
				p("Goal FlapJacks:");
				////pList(sortedFlapjacks);
			}
			//___________________
			
			int position = 0;
//			p("Input Pancakes");
//			pList(pancakes);
			//Collections.reverse(pancakes);
//			p("Curr Pancakes --------------");
//			pList(pancakes);
			
			p(input);
			
			boolean isOr = !isOrderedList(pancakes);
			String order = "";
			while(isOr){
				int maxIndex = 0;
				int largest = 0;
				for(int i = position; i < pancakes.size(); i++) {
					if(pancakes.get(i) > largest) {
						maxIndex = i;
						largest = pancakes.get(i);
					}
				}
				isOr = !isOrderedList(pancakes);
				if(maxIndex != pancakes.size() - 1) {
					pancakes = flip(pancakes, maxIndex);
					order += (maxIndex + 1) + " ";
				}
				isOr = !isOrderedList(pancakes);
				pancakes = flip(pancakes, position);
				order += (position + 1) + " ";
				position++;
				isOr = !isOrderedList(pancakes);
				
				p("Curr Pancakes --------------");
				pList(pancakes);
			}
			order = (order.length() > 1 ? order.substring(0, order.length() - 2) : "1 ");
			p(order + "0");
		}
	}
	
	private static Object p(Object o){
		System.out.println(o.toString()); return o;
	}
	
	private static boolean listIsEqual(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		String s1 = "";
		for (Integer I : arr1)
			s1 += I.intValue() + "";
		String s2 = "";
		for (Integer I : arr2)
			s2 += I.intValue() + "";
		return s1.equals(s2);
	}
	
	private static boolean isOrderedList(ArrayList<Integer> mSort){
		int last = mSort.get(0);
		for (Integer currint : mSort){
			if (currint > last)
				return false;
			last = currint;
		}
		return true;
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
