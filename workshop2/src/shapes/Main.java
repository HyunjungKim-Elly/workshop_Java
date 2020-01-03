package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		String s;
		int count=0;
		Shape[] shapes = new Shape[100]; 
		
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------\n");
		
		try (BufferedReader br = new BufferedReader(new FileReader("./shape.txt"))) {
			while ((s = br.readLine()) != null) {
			
				String[] tokens = s.split(",");
			
				if(tokens[0].toLowerCase().equals("circle") && tokens.length == 2){
					Circle circle = new Circle(Double.parseDouble(tokens[1]));
					if(circle.getRadius() > 0)
						shapes[count++] = circle;	
					
				}else if(tokens[0].toLowerCase().equals("square") && tokens.length == 2) {
					Square square = new Square(Double.parseDouble(tokens[1]));   
					if(square.getLength() > 0 && square.getWidth() > 0)
						shapes[count++] = square;
					
				}else if(tokens[0].toLowerCase().equals("rectangle") && tokens.length == 3) {
					Rectangle rectangle = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
					if(rectangle.getLength() > 0  && rectangle.getWidth() > 0)
						shapes[count++] = rectangle;
					
				}else if(tokens[0].toLowerCase().equals("parallelogram") && tokens.length == 3) {
					Parallelogram parallelogram = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
					if(parallelogram.getLength() > 0 && parallelogram.getWidth() > 0)
						shapes[count++] = parallelogram;
					
				}else if(tokens[0].toLowerCase().equals("triangle") && tokens.length == 4) {
					Triangle triangle = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
					if(triangle.checkTriangle(triangle.getS1(), triangle.getS2(), triangle.getS3()))
						shapes[count++] = triangle;
				} 					
			}
			System.out.println();
			System.out.println(count + " shapes were created:");
			
			for(int i=0; i<count; i++) {
				System.out.print(shapes[i]);
				System.out.printf(" perimeter = %g\n", shapes[i].perimeter());
				System.out.println();
			}
		
		} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
}
