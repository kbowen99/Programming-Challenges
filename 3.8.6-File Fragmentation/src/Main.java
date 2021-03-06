import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static final boolean DEBUG = false;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try {
			if (true)
				System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e) {}
		
		Scanner sc = new Scanner(System.in);
		Outputter sOut = new Outputter();
		int tCases = sc.nextInt();
		sc.nextLine();sc.nextLine();
		
		for (int useless = 0; useless < tCases; useless++){
			ArrayList<Fragment> fragments = new ArrayList<>();
			
			{//Containing Variable
				String in = sc.nextLine();
				while (!in.equals("") && sc.hasNextLine()){ //Input all frags
					fragments.add(new Fragment(in));
					in = sc.nextLine();
					
				}
			}
			try{
			Collections.sort(fragments);
			} catch (Exception e) {}
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
				sOut.println(likelyCombos.get(0).getContents());
			else{
				int c1 = Integer.parseInt(randyFrags.get(0).getC1().getContents());
				int c2 = Integer.parseInt(randyFrags.get(0).getC2().getContents());
				//sOut.println((c1 < c2 ? "true" : "false"));
				sOut.println((c1 < c2 ? randyFrags.get(0).getC1().getContents() : randyFrags.get(0).getC2().getContents()));
			}
			sOut.println();
			sOut.println();
			sOut.println();
			sOut.println();
			
			if (DEBUG){
				sOut.println("FRAGS:");
				for (Fragment s : fragments)
					sOut.println(s.getContents() + " ");
				
				sOut.println("COMBOFRAGS:");
				for (ComboFrag s : randyFrags)
					sOut.println(s.getC1().getContents() + " || " + s.getFrag1().getContents() + "|" + s.getFrag2().getContents() + "\n" + s.getC2().getContents());
				
				sOut.println("COMBOS:");
				for (Fragment f : likelyCombos)
					sOut.println(f.getContents());
			}
			
		}
		sOut.dump();
		sc.close();
	}

}
