package minesweep;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {

	static final Boolean DEBUG = false; //To Debug, or not to debug, always the question
	
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int field = 0;
	static ArrayList<boolean[][]> fields = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			if (DEBUG)
				System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e) {}
		
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
					n = 0; m = 0;
					
					if (field != 0)
						System.out.println();
					
					System.out.println("Field #" + (field + 1) + ":");
					
					for (int r = 0; r < fields.get(field).length; r++){
						input = sc.nextLine();
						for(int c = 0; c < fields.get(field)[0].length; c++){
							String tmp = (char)(input.getBytes()[c]) + "";
							fields.get(field)[r][c] = (tmp.equals("*") ? true : false);
						}
					}
					
					for (int r = 0; r < fields.get(field).length; r++){
						for(int c = 0; c < fields.get(field)[0].length; c++){
							if (fields.get(field)[r][c]){
								System.out.print("*");
							}else{
								int count = 0;
								boolean cZero = (c == 0);
								boolean cMax = ((c + 1) == fields.get(field)[r].length);
								boolean rZero = (r < 1);
								boolean rMax = ((r + 1) == fields.get(field).length);
								if (!rZero && fields.get(field)[r-1][c])
									count++;
								if (!rZero && !cZero && fields.get(field)[r-1][c-1])
									count++;
								if (!rZero && !cMax && fields.get(field)[r-1][c+1])
									count++;
								if (!rMax && fields.get(field)[r+1][c])
									count++;
								if (!rMax && !cZero && fields.get(field)[r+1][c-1])
									count++;
								if (!rMax && !cMax && fields.get(field)[r+1][c+1])
									count++;
								if (!cZero && fields.get(field)[r][c-1])
									count++;
								if (!cMax && fields.get(field)[r][c+1])
									count++;
								System.out.print(count);
							}
						}
						System.out.println();
					}
					
					field++;
				}
			} catch (Exception e){}			
		}
	}
}
