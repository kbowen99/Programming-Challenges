import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static final boolean DEBUG = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCases = sc.nextInt();
		sc.nextLine();sc.nextLine();
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
			
			ArrayList<ComboFrag> randyFrags = new ArrayList<>();
			
			while (fragments.size() >=2){
				randyFrags.add(new ComboFrag(fragments.remove(0), fragments.remove(fragments.size() - 1)));
			}
			
			ComboFrag lastFrag = new ComboFrag(new Fragment(""),new Fragment(""));
			
			ArrayList<Fragment> likelyCombos = new ArrayList<>();
			
			for (ComboFrag cf : randyFrags){
				if (lastFrag.getC1().getContents().length() == 0)
					lastFrag = cf;
				else {
					//lf c1
					if (lastFrag.getC1().getContents().equals(cf.getC1().getContents()))
						likelyCombos.add(cf.getC1());
					if (lastFrag.getC1().getContents().equals(cf.getC2().getContents()))
						likelyCombos.add(cf.getC2());
					//lf c2
					if (lastFrag.getC2().getContents().equals(cf.getC1().getContents()))
						likelyCombos.add(cf.getC1());
					if (lastFrag.getC2().getContents().equals(cf.getC2().getContents()))
						likelyCombos.add(cf.getC2());
					
					lastFrag = cf;
				}
			}
			if (likelyCombos.size() > 0)
				System.out.println(likelyCombos.get(0).getContents() + "\n");
			else{
				int c1 = Integer.parseInt(randyFrags.get(0).getC1().getContents());
				int c2 = Integer.parseInt(randyFrags.get(0).getC2().getContents());
				System.out.println((c1 < c2 ? randyFrags.get(0).getC1().getContents() : randyFrags.get(0).getC2().getContents()) + "\n");
			}
			
			if (DEBUG){
				System.out.println("FRAGS:");
				for (Fragment s : fragments)
					System.out.println(s.getContents() + " ");
				
				System.out.println("COMBOFRAGS:");
				for (ComboFrag s : randyFrags)
					System.out.println(s.getC1().getContents() + " || " + s.getFrag1().getContents() + "|" + s.getFrag2().getContents() + "\n" + s.getC2().getContents());
				
				System.out.println("COMBOS:");
				for (Fragment f : likelyCombos)
					System.out.println(f.getContents());
			}
			
		}
	}

}
