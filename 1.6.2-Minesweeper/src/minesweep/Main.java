package minesweep;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {

	static Scanner sc = new Scanner(System.in);
	//static boolean[][] board = null;
	static int n;
	static int m;
	static int field = 0;
	static ArrayList<boolean[][]> fields = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String input = "";
		while (sc.hasNextLine()){
			input = sc.nextLine();
				try{
					if (Integer.parseInt((char)(input.getBytes()[0]) + "") > -1){
						int index = input.indexOf(" ");
						n = Integer.parseInt(input.substring(0, index));
						m = Integer.parseInt(input.substring(index + 1));
						if (n == 0|| m == 0){
							break;
						}
					}
					if (n>0 && m>0){
						fields.add(new boolean[n][m]);
						n = 0;
						m = 0;
						
						if (field != 0){
							System.out.println();
						}
						p("Field #" + (field + 1) + ":");
						
						for (int r = 0; r < fields.get(field).length; r++){
							input = sc.nextLine();
							for(int c = 0; c < fields.get(field)[0].length; c++){
								String tmp = (char)(input.getBytes()[c]) + "";
								fields.get(field)[r][c] = (tmp.equals("*") ? true : false);
							}
						}
						String[][] magic = new String[fields.get(field).length][fields.get(field)[0].length];
						for (int r = 0; r < fields.get(field).length; r++){
							for(int c = 0; c < fields.get(field)[0].length; c++){
								magic[r][c] = (fields.get(field)[r][c] ? "T" : "F");
								//System.out.print((fields.get(field)[r][c] ? "T" : "F"));
							}
						}
						
						for (int r = 0; r < magic.length; r++){
							for(int c = 0; c < magic[0].length; c++){
								if (magic[r][c].equals("T")){
									System.out.print("*");
								}else{
									int count = 0;
									boolean cZero = (c == 0);
									boolean cMax = ((c + 1) == fields.get(field)[r].length);
									boolean rZero = (r < 1);
									boolean rMax = ((r + 1) == fields.get(field).length);
									if (!rZero && magic[r-1][c].equals("T"))
										count++;
									if (!rZero && !cZero && magic[r-1][c-1].equals("T"))
										count++;
									if (!rZero && !cMax && magic[r-1][c+1].equals("T"))
										count++;
									if (!rMax && magic[r+1][c].equals("T"))
										count++;
									if (!rMax && !cZero && magic[r+1][c-1].equals("T"))
										count++;
									if (!rMax && !cMax && magic[r+1][c+1].equals("T"))
										count++;
									if (!cZero && magic[r][c-1].equals("T"))
										count++;
									if (!cMax && magic[r][c+1].equals("T"))
										count++;
									System.out.print(count);
								}
							}
							System.out.println();
						}
						
						field++;
					}
				} catch (Exception e){}
			
		};
	}
	
	private static Object p(Object p){
		System.out.println(p); return p;
	}
}
