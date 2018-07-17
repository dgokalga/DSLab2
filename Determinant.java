/* Lab 2
 *
 * Module: Determinant.java
 *
 * Author: D.G.
 * 
 * The purpose of this module is to evaluate input matrices from an input file, 
 * determine whether they are NxN for order N, and calculate the determinant of the 
 * square matrix recursively, appending the matrix itself and its calculated determinant
 * to a string object that is to be written to an output file.
 * 
 * 
 * Methods: Determinant(), get_Length(), isSquare(), holdArray(), make2DArray(),
 * 			calc_Det(), Minor(), printMat()
 *
 */

public class Determinant {
	private int x; 
	private int len; // hold number of characters in file
	private String output_mat; // hold final output string
	private int[] arr; // hold each individual number from input file 
	private int[][] one; // hold 1x1
	private int[][] two; // hold 2x2
	private int[][] three; // hold 3x3
	private int[][] four; // hold 4x4
	private int[][] five; // hold 5x5
	private int[][] six; // hold 6x6
	/*
	 * Constructor method 
	 */
	public Determinant() { 
		len = 0;
		x = 0;
		output_mat = "";
		one = new int[1][1];
		two = new int[2][2];
		three = new int[3][3];
		four = new int[4][4];
		five= new int[5][5];
		six = new int[6][6];
	}
	/*
	 * 
	 * Evaluates the number of individual numbers (or size dimension) 
	 * in the input file.
	 * Creates array to hold each individual number using the size dimension.  
	 * 
	 * Input: int object
	 * 
	 */
	public void get_Length(int input) {
		len = input;
		arr = new int[len]; // create arr to hold each character using input size dimension
	}
	
	/*
	 * Evaluates whether the matrices in the input file are squares, 
	 * or of order N (NxN).
	 * 
	 * Input: 2D array object
	 * 
	 * Returns boolean value true if matrix of order N is NxN, or false otherwise.
	 * 	 
	 */
	public boolean isSquare(String[][] input) {
		boolean nxn = false; // true if matrix is square
		for (int x = 0; x < input.length; x++) { 
			if (input[x].length == 1 && input[x][0].endsWith("1")) { // if order 1
				if (input[x+1].length == 1) { // if matrix is of lenght 1
					nxn = true;
					x++;
				}
				else  { // not square
					nxn = false;
					break;
				}
			}
			else if (input[x].length == 1 && input[x][0].endsWith("2")){ // if order 2
				if (input[x+1].length == 2 && input[x+2].length == 2) { // if matrix is 2x2
					nxn = true;
					x = x + 2;
					
				}
				else  {
					nxn = false;
					break;
				}
			}
			else if (input[x].length == 1 && input[x][0].endsWith("3")){ // if order 3
				if (input[x+1].length == 3 && input[x+2].length == 3 && 
					input[x+3].length == 3){ // if matrix is 3x3
					nxn = true;
					x = x + 3;
					
				}
				else  {
					nxn = false;
					break;
				}
			}
			else if (input[x].length == 1 && input[x][0].endsWith("4")){ // if order 4
				if (input[x+1].length == 4 && input[x+2].length == 4 && 
					input[x+3].length == 4 && input[x+4].length == 4){ // if matrix is 4x4
					nxn = true;
					x = x + 4;
					
				}
				else  {
					nxn = false;
					break;
				}
			}
			else if (input[x].length == 1 && input[x][0].endsWith("5")){ // if order 5
				if (input[x+1].length == 5 && input[x+2].length == 5 && 
					input[x+3].length == 5 && input[x+4].length == 5 &&
					input[x+5].length == 5){ // if matrix is 5x5
					nxn = true;
					x = x + 5;
					
				}
				else  {
					nxn = false;
				}
			}
			else if (input[x].length == 1 && input[x][0].endsWith("6")){ // if order 6
				if (input[x+1].length == 6 && input[x+2].length == 6 && 
					input[x+3].length == 6 && input[x+4].length == 6 &&
					input[x+5].length == 6 && input[x+6].length == 6){ // if matrix is 6x6 
					nxn = true;
					x = x + 6;
					
				}
				else  {
					nxn = false;
				}
			}
			else {
				nxn = false;
				break;
			}
		}
		return nxn; // return true if all matrices were squares, false otherwise.
	}

	/* 
	 * Appends each individual number from input file into array 
	 * 
	 * Input: int object (each individual number from file) 
	 */
	public void holdArray(int input) {
		arr[x] = input; 
		x++;
		}
	
	/*
	 * Creates 2D array to hold each matrix of order N, and evaluates
	 * it to determine the determinant by calling printMat() method.
	 * 
	 * 
	 * Returns string object that holds the matrix and its determinant. 
	 */
	public String make2DArray() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) { // if order 1
				one[0][0] = arr[i+1]; // append next element in array to 2D array
				i++;
				output_mat += printMat(one); // append matrix and determinant to string 
			}
			else if (arr[i] == 2) { // if order 2
				for (int y = 0; y < 2; y++) {
					for (int x = 0; x < 2; x++) {
						two[y][x] = arr[i+1]; // append next 4 elements to 2D array
						i++;
					}	
				}
				output_mat += printMat(two);
			}
			else if (arr[i] == 3) { // if order 3
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						three[y][x] = arr[i+1]; // append next 9 elements to 2D array
						i++;
					}
				}
				output_mat += printMat(three);
			}
			else if (arr[i] == 4) { // if order 4
				for (int y = 0; y < 4; y++) {
					for (int x = 0; x < 4; x++) {
						four[y][x] = arr[i+1]; // append next 16 elements to 2D array
						i++;
					}
				}
				output_mat += printMat(four);
			}
			else if (arr[i] == 5) { // if order 5
				for (int y = 0; y < 5; y++) {
					for (int x = 0; x < 5; x++) {
						five[y][x] = arr[i+1]; // append next 25 elements to 2D array
						i++; 
					}
				}
				output_mat += printMat(five);
			}
			else if (arr[i] == 6) { // if order 6
				for (int y = 0; y < 6; y++) {
					for (int x = 0; x < 6; x++) {
						six[y][x] = arr[i+1]; // append next 36 elements to 2D array
						i++;
					}			
				}
				output_mat += printMat(six);
			}	
		}
		return output_mat; // return final String with all matrices and calculated determinants
	}	
	
	/*
	 * Recursively determines the sum of products needed to calculate the determinant,
	 * by creating the minor, based on the values of the first row of the matrix (row = 0, col++)
	 * 
	 * Input: 2D matrix and its length.
	 * 
	 * Recursively returns int sum of products to determine the determinant.
	 */
	public int calc_Det(int[][] input, int len) {
		int sum = 0; // initialize the sum
		int[][] input2 = new int[len][len]; // creates array based on recursively decreasing length
		if (input.length == 1) { // if matrix of order 1
			return input[0][0]; // return single element from matrix
		}
		else {
			for (int n = 0; n < len; n++) { // iterate through first row of matrix
				Minor(input, input2, 0, n, len); // create minor of matrix
				sum += Math.pow(-1, 0 + n) * input[0][n] * calc_Det(input2, len - 1); // recursively add value
			}
			return sum; // return determinant
		} 
	}
	
	/*
	 * Creates minor of input matrix that holds each element not in the given row 
	 * or column of the given value in the matrix. 
	 * 
	 * Input: input matrix, empty 2D array, int row position of value, int col position of value,
	 * int lenght of input matrix.
	 * 	 
	 */
	public void Minor(int[][] input, int[][] input2, int no_row, int no_col, int len) {
		int new_row = 0;
		int new_col = 0;
		for (int x = 0; x < len; x++) { // row
			for (int y = 0; y < len; y++) { // column
				if (x != no_row && y != no_col) { // if element is not in the input row position or col position
					input2[new_row][new_col] = input[x][y]; // append each element from input matrix to empty minor matrix
					new_row++;
					if (new_row == len - 1) { // when row if filled, go to next column
						new_row = 0;
						new_col++;
					}
				}	
			}
		}
	}
	
	/* 
	 * Given an input matrix of order N, appends the matrix itself, and its determinant, 
	 * in string form to string object.
	 * 
	 * Input: Matrix stored in 2D array
	 * 
	 * Returns string object the displays the input matrix and its determinant.
	 */
	public String printMat(int[][] input) {
		String output = "";
		output += "For matrix: \n";
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input.length; col++) {
				output += (input[row][col] + " "); // appends matrix to string 
			}
			output += ("\n");
		}
		output += "The determinant is: " + calc_Det(input, input.length); // calculates determinant and appends to string
		output += "\n";
		output += "\n";
		return output;
	}
	
}
	
