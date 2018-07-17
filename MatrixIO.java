/* Lab 2
 *
 * Module: MatrixIO.java
 *
 * Author: D.G.
 * 
 * The purpose of this module is to read in the order of a matrix,
 * followed by the matrix, and evaluate whether the matrix is NxN 
 * for order N, and write the matrix and its determinant to a given 
 * output file.
 * 
 * Methods: main()
 *
 */

import java.io.*;

public class MatrixIO {
	/*
	 * Reads in input file with multiple matrices. Using Determinant.java, evaluates 
	 * whether matrix is NxN for order N, then computes the determinant, and printing 
	 * the matrix itself and it's determinant to a given output file.
	 */
	public static void main(String[] args) {
		Determinant det = new Determinant();
		try {
			if (args.length != 2) { // if more or less than required arguments (input, output)
				System.out.println("Argument Error -> Usage: java -cp bin MatrixIO filename_input filename_output");
				System.exit(1);
			}
			else {
				try { 
					BufferedReader input = new BufferedReader(new FileReader(args[0]));
					String line;
					int len = 0; // holds number of individual characters in input file
					int num_line = 0; // holds number of lines in input file
					while ((line = input.readLine()) != null) { // iterate through file to determine number of numbers in file
						line = line.trim();
						String numbers = line.replace(" ", ""); // remove space between numbers
						len += numbers.length(); // add number of individual numbers 
						num_line++;
						
					}	
					det.get_Length(len); 
					input.close();
					
					BufferedReader in = new BufferedReader(new FileReader(args[0]));
					BufferedWriter out = new BufferedWriter(new FileWriter(args[1])); // write to output argument
					String lines;
					String[][] square = new String[num_line][0]; // hold each line in file
					
					int x = 0;
					while ((lines = in.readLine()) != null) { // iterate again through file
						lines = lines.trim();
						String[] arr = lines.split(" "); // array containing each lines numbers
						square[x] = arr; // append arrays to array
						x++;
						for (int i = 0; i < arr.length; i++) {
							int num = Integer.parseInt(arr[i]); // convert string type numbers to int type
							det.holdArray(num); // append each number to array
						}
					}
					if (det.isSquare(square)) { // if each matrix is NxN for order N
						out.write(det.make2DArray()); // hold each matrix in 2D array
						
					}
					else {
						out.write("Error: Matrix must be NxN for N = {1:6}");
					}
					in.close();
					out.close();
				}
				catch (FileNotFoundException exception) { // file not found handling
					System.out.println("File '" + args[0] + "' was not found.");
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				catch (ArrayIndexOutOfBoundsException exception) {
					System.out.println("Error: Input matrix of NxN must follow order N");
				}
			}
		}
		
		catch (Exception e) { // argument exception handling
			System.err.println(e.toString());
			return;
		 }
	}
}