package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		String s;
		int count = 0; 
		double min = 0;
		double max = 0;
		double totalParal = 0;
		double totalTri = 0;
		double []firstTriangle = new double[1];
		Shape[] shapes = new Shape[100]; 
		
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------\n");
		
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
					
				}else if(tokens[0].toLowerCase().equals("triangle") && tokens.length == 4) {
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
			
			for(int i = 0; i < count; i++) {
				System.out.print(shapes[i]);
				System.out.printf(" perimeter = %g\n", shapes[i].getPerimeter());
				System.out.println();
			}
			
			System.out.println();
			System.out.println("------->Task 2 ... <-------\n");
			
			
			// set maximum and minimum
			for(int i = 0; i < count; i++) {
				if(shapes[i].getClass().getSimpleName().equals("Circle")) {
					if(shapes[i].getPerimeter() >= max) {
						max = shapes[i].getPerimeter();
					}
				}
				
				if(shapes[i].getClass().getSimpleName().equals("Triangle")){
					if(firstTriangle[0] == 0.0) {
						firstTriangle[0] = shapes[i].getPerimeter();	
						min = firstTriangle[0];
					}else if(min >= shapes[i].getPerimeter()) {
						min = shapes[i].getPerimeter();
					}
				}
			}	
										
			// removing minimum and maximum
			for(int i = 0; i < count; i++) {
				if(shapes[i].getClass().getSimpleName().equals("Circle")) {
					if(shapes[i].getPerimeter() == max) {
						for(int j = i; j < count; j++) {
							shapes[j] = shapes[j+1];
						}
						count--;
					}
				}
			}
			
			for(int i = 0; i < count; i++) {
				if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
					if(shapes[i].getPerimeter() == min) {
						for(int j = i; j < count; j++) {
							shapes[j] = shapes[j+1];
						}
						count--;
					}
				}
			}
			
			System.out.println();
			System.out.println(count + " shapes were created:");
			
			for(int i = 0; i < count; i++) {
				System.out.print(shapes[i]);
				System.out.printf(" perimeter = %g\n", shapes[i].getPerimeter());
				System.out.println();
			}

			
			System.out.println();
			System.out.println("------->Task 3 ... <-------\n");
			
			for(Shape shape:shapes) {
				if(shape instanceof Parallelogram) {
					totalParal += shape.getPerimeter();
				}else if(shape instanceof Triangle) {
					totalTri += shape.getPerimeter();
				}
			}
			
			System.out.println("Total perimeter of Parallelogram is: " + totalParal);
			System.out.println("Total perimeter of Triangle is: " + totalTri);
		
		} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
}
