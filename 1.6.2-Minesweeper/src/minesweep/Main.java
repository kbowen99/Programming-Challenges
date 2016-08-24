package minesweep;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static boolean[][] board = null;
	static int n;
	static int m;
	
	public static void main(String[] args) {
		String input = "";
		while (sc.hasNext()){
			input = sc.nextLine();
			
			//Try to take input for board
			if (board == null){
				try{
					if (Integer.parseInt((char)(input.getBytes()[0]) + "") > 0){
						n = Integer.parseInt((char)(input.getBytes()[0]) + "");
					}
					if (Integer.parseInt((char)(input.getBytes()[3]) + "") > 0){
						m = Integer.parseInt((char)(input.getBytes()[3]) + "");
					}
					if (n>0 && m>0){
						board = new boolean[n][m];
						p("")
					}
				} catch (Exception e){}
			}

		};
	}
	
	private static Object p(Object p){
		System.out.println(p); return p;
	}
}
