import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangleGenerator {
	//Generates and displays a Pascal's triangle.
	
	private static int lines; //Number of lines to generate
	private static ArrayList<ArrayList<Integer>> triangle; //array list of array lists; each sub-list represents one line.
	
	public static void main(String args[]){
		
		triangle = new ArrayList<ArrayList<Integer>>();
		
		//Get number of lines to generate
		System.out.println("How many lines would you like to generate?");
		Scanner input = new Scanner(System.in);
		
		try{
			lines = input.nextInt();
		}catch(Exception e){
			System.out.println("Sorry, there was an error reading your input. Please enter only an integer value. Generating 10 lines by default:");
			lines = 10;
		}
		
		//Generate triangle
		//Feed the first line:
		ArrayList<Integer> firstLine = new ArrayList<Integer>();
			firstLine.add(1);
			triangle.add(firstLine);
		for(int currentLine = 0; currentLine < lines; currentLine++){
			//Get the latest line and feed it in to line generator
			@SuppressWarnings("unused")
			int testing = triangle.size();
			triangle.add(generateLineFrom(triangle.get((triangle.size() -1 ))));
		}
		
		displayTriangle();
	}
	
	private static ArrayList<Integer> generateLineFrom(ArrayList<Integer> previousLine){
		ArrayList<Integer> newLine = new ArrayList<Integer>();
		int currentValue = 0;
		
		newLine.add(1);
		
		for(Integer i : previousLine){
			try{
				//Sum i and the next i
				currentValue = i.intValue() + previousLine.get((previousLine.indexOf(i) + 1)).intValue();
			}catch(Exception e){
				//Occurs when the next value is out-of-bounds
				currentValue = i.intValue() + 1;
			}
			newLine.add(currentValue);
		}//Next i
		
		newLine.add(1);
		
		return newLine;
	}
	
	private static void displayTriangle(){
		//TODO: Have this formatted so that it actually looks like a triangle.
		
		for(ArrayList<Integer> currentLine : triangle){
			//Display this line
			for(Integer i : currentLine){
				System.out.print("  " + i.toString() + "  ");
			}
			System.out.println("");
		}
	}
}
