package shapes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		String s;
		int count = 0; 
		Shape[] shapes = new Shape[100]; 
		
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 4 ... <-------\n");
		
		try (BufferedReader br = new BufferedReader(new FileReader("./shape.txt"))) {
			while ((s = br.readLine()) != null) {
			
				String[] tokens = s.split(",");
			
				if(tokens[0].toLowerCase().equals("circle") && tokens.length == 2){
					Circle circle;
					try {
						circle = new Circle(Double.parseDouble(tokens[1]));
						shapes[count++] = circle;
						
					} catch (ExceptionRadius e) {
						System.out.println(e.getMessage());
					}
					
				}else if(tokens[0].toLowerCase().equals("square") && tokens.length == 2) {
					Square square;
					try {
						square = new Square(Double.parseDouble(tokens[1]));
						shapes[count++] = square;
					} catch (ExceptionRec e) {
						System.out.println(e.getMessage());
					}   
					
				}else if(tokens[0].toLowerCase().equals("rectangle") && tokens.length == 3) {
					Rectangle rectangle;
					try {
						rectangle = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						shapes[count++] = rectangle;
	
					} catch (ExceptionRec e) {
						System.out.println(e.getMessage());
					}
					
				}else if(tokens[0].toLowerCase().equals("parallelogram") && tokens.length == 3) {
					Parallelogram parallelogram;
					try {
						parallelogram = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));					
						shapes[count++] = parallelogram;
					
					} catch (ExceptionRec e) {
						System.out.println(e.getMessage());
					}
					
				}if(tokens[0].toLowerCase().equals("triangle") && tokens.length == 4) {
					Triangle triangle;
					try {
						triangle = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
						shapes[count++] = triangle;						
					} catch(ExceptionTriangle e) {
						System.out.println(e.getMessage());
					}
				} 					
			}
			
			System.out.println();
			System.out.println(count + " shapes were created:");
			
			for(Shape shape : shapes) {
				if(shape != null)
					System.out.println("\n" + shape);
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
