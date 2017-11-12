package module5;

import java.util.Arrays;

public class SquareMatrix {


	double[][] elements;


	/**
	 * Constructor, initialise squarematrix as a 2d array
	 * Throws exception if not a square matrix
	 * @param elements
	 * @throws Exception
	 */
	public SquareMatrix (double[][] elements) throws Exception{
		this.elements = new double[elements.length][elements[0].length];
		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < elements[0].length; j++)
				this.elements[i][j] = elements[i][j];
		if (elements.length != elements[0].length) {
			throw new Exception("SquareMatrix can only use square matrices");
		}
	}


	/*
	 * Returns SquareMatrix as a readable string 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (double row[]  : this.elements) {
			String line = Arrays.toString(row);
			sb.append(line +"\n");
		}
		String sm = sb.toString();
		return sm;
	}

	/*
	 * Returns a unit matrix.
	 * Input is the size of the unitmatrix  
	 */
	public static SquareMatrix unitMatrix(int size) throws Exception{
		double[][] ia = new double [size][size];
		for (int t=0; t < size; t++) {
			ia [t][t]=1;
		}
		SquareMatrix i = new SquareMatrix(ia);
		return i;
	}


	/*
	 * Tests if two squarematrices have the same elements 
	 */
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;

			// returns false if given a null object.
		} else if (obj == null) {
			System.out.println("equals was provided with a null object!");
			return false;

			// Returns false if objects are of different classes
		} else if (getClass() != obj.getClass()) {
			return false;
		}

		//return false if any of the elemets are different
		final SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(elements, other.elements)) {
			return false;
		}
		return true;
	}


	/*
	 * Adds two SquareMatrices together
	 * Arguments are two squarematrices 
	 * Throws Exception if matrices are not the same size or aren't square 
	 */
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.elements.length != sm2.elements.length){
			throw new Exception ("To add matrices they must be the same size.");
		}
		//initialising each element and final 2d array
		double currentElement;
		double[][] currentElementArray = new double[sm1.elements.length][sm1.elements[0].length];
		//loops through each element, adding corresponding elements together
		for (int i=0; i<sm1.elements.length; i++) {
			for (int j=0; j<sm1.elements.length; j++) {
				currentElement = sm1.elements[i][j] + sm2.elements[i][j];
				currentElementArray[i][j] = currentElement;
			}
		}
		return new SquareMatrix(currentElementArray);
	}

	// non-static adding method that calls on the static version
	public SquareMatrix add(SquareMatrix sm1) throws Exception{
		SquareMatrix added = SquareMatrix.add(this,sm1);
		return added;
	}

	/*
	 * Subtracts two SquareMatrices 
	 * Arguments are two squarematrices 
	 * Throws Exception if matrices are not the same size or aren't square 
	 */
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2)throws Exception{
		if (sm1.elements.length != sm2.elements.length){
			throw new Exception ("To subtract matrices they must be the same size.");
		}
		//initialising each element and final 2d array
		double currentElement;
		double [][] currentElementArray = new double [sm1.elements.length][sm1.elements[0].length];
		//loops through each element, subtracting corresponding elements 
		for (int i=0; i<sm1.elements.length;i++){
			for (int j=0; j<sm1.elements.length;j++){
				currentElement = sm1.elements[i][j] - sm2.elements[i][j];
				currentElementArray [i][j]= currentElement;
			}
		}
		return new SquareMatrix(currentElementArray);
	}

	// non-static subtracting method that calls on the static version
	public SquareMatrix subtract(SquareMatrix sm1) throws Exception{
		SquareMatrix sub = SquareMatrix.subtract(this,sm1);
		return sub;
	}

	/*
	 * Multiplies two SquareMatrices 
	 * Arguments are two squarematrices 
	 * Throws Exception if matrices are not the same size or aren't square 
	 */
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2)throws Exception{
		if (sm1.elements.length != sm2.elements.length){
			throw new Exception ("To multiply squarematrices they must be the same size.");
		}
		//initialise each element and final 2d array
		double currentElement;
		double[][] currentElementArray = new double [sm1.elements.length][sm1.elements[0].length];
		//goes through each element multiplying necessary values
		for (int i =0; i<sm1.elements.length;i++){
			for (int j = 0; j<sm1.elements.length;j++){
				for (int k =0; k<sm1.elements.length;k++){

					currentElement = sm1.elements[i][k] * sm2.elements[k][j];
					currentElementArray[i][j] += currentElement;
				}
			}
		}
		return new SquareMatrix(currentElementArray);
	}

	// non-static multiply method that calls on the static version
	public SquareMatrix multiply(SquareMatrix sm1) throws Exception{
		SquareMatrix mul = SquareMatrix.multiply(this,sm1);
		return mul;
	}
}
