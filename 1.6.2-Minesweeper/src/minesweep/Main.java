package minesweep;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	//static boolean[][] board = null;
	static int n;
	static int m;
	static int field = 0;
	static ArrayList<boolean[][]> fields = new ArrayList<>();
	
	public static void main(String[] args) {
		String input = "";
		while (sc.hasNext()){
			input = sc.nextLine();
			
				try{
					if (Integer.parseInt((char)(input.getBytes()[0]) + "") > 0){
						int index = input.indexOf(" ");
						n = Integer.parseInt(input.substring(0, index));
						m = Integer.parseInt(input.substring(index + 1));
					}
					if (n>0 && m>0){
						fields.add(new boolean[n][m]);
						p("Field #" + (field + 1) + ":");
						n = 0;
						m = 0;
						
						for (int r = 0; r < fields.get(field).length; r++){
							input = sc.nextLine();
							for(int c = 0; c < fields.get(field)[0].length; c++){
								String tmp = (char)(input.getBytes()[c]) + "";
								fields.get(field)[r][c] = (tmp.equals("*") ? true : false);
							}
						}
						
						for (int r = 0; r < fields.get(field).length; r++){
							for(int c = 0; c < fields.get(field)[0].length; c++){
								System.out.print((fields.get(field)[r][c] ? "T" : "F"));
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
