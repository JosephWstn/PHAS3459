/*
package module5;

import java.util.Arrays;


public class SquareMatrix {
	
	double[][] elements; // Generic array.

	/**
	 * Constructor, does not accept non-square matrices
	 * @param elements
	 * @throws Exception
	 
	public SquareMatrix( double[][] elements) throws Exception {

		this.elements = new double[elements.length][elements[0].length];
		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < elements[0].length; j++)
				this.elements[i][j] = elements[i][j];

		if (elements.length != elements[0].length) {
			throw new Exception("Cannot have a non-square matrix for SquareMatrix");			  
		}		
	}



	
	 * Returns a representation of the matrix that is readable.
	 
	public String toString() {
		StringBuilder sb = new StringBuilder();

		// Loops over elements in matrix to add to sb.
		for (double[] row : this.elements) {
			String line = (Arrays.toString(row)) + "\n";
			sb.append(line);
		}
		String sMatrix = sb.toString();
		return sMatrix;
	}
	
	

	Returns the identity matrix
	 * 
	 * @param size
	 * @return Identity matrix
	 * @throws Exception 
	 
	public static SquareMatrix unitMatrix(int size) throws Exception {
		double[][] iM = new double[size][size];
		SquareMatrix I = new SquareMatrix(iM);
		for (int i = 0; i < size; i++)
			I.elements[i][i] = 1;
		return I;	
	}
	


	
	 * Cheks whether two matrices have the same elements.
	 
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

		final SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(elements, other.elements)) {
			return false;
		}
		return true;
	}

	

	
	 * Ads two equal size SquareMAtrix objects
	 * @param sm1
	 * @param sm2
	 * @return
	 * @throws Exception
	 
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2)  throws Exception {

		if (sm1.elements.length != sm2.elements.length) {
			throw new Exception("Both matrices must be of the same size.");
		}

		double currentElement;
		double[][] currentElementArray = new double[sm1.elements.length][sm1.elements[0].length];
		for (int i=0; i<sm1.elements.length; i++) {
			for (int j=0; j<sm1.elements.length; j++) {
				currentElement = sm1.elements[i][j] + sm2.elements[i][j];
				currentElementArray[i][j] = currentElement;
			}
		}
		return new SquareMatrix(currentElementArray);
	}	

	
	 * Adds two matrices, non-static
	 * @param sm1
	 * @return
	 * @throws Exception
	 
	SquareMatrix add(SquareMatrix sm1) throws Exception {
		SquareMatrix added = SquareMatrix.add(this, sm1);
		return added;
	}



	 
	 * Subtracts SquareMatrix sm2 from SquareMatrix sm1.
	 * @param sm1
	 * @param sm2
	 * @return
	 * @throws Exception
	 
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2)  throws Exception {

		if (sm1.elements.length != sm2.elements.length) {
			throw new Exception("Both matrices must be of the same size.");
		}

		double currentElement;
		double[][] currentElementArray = new double[sm1.elements.length][sm1.elements[0].length];
		for (int i=0; i<sm1.elements.length; i++) {
			for (int j=0; j<sm1.elements.length; j++) {
				currentElement = sm1.elements[i][j] - sm2.elements[i][j];
				currentElementArray[i][j] = currentElement;
			}
		}	
		return new SquareMatrix(currentElementArray);
	}
	

	
	 * Subtracts argument from object it belongs to. Non-static
	 * @param sm1
	 * @return
	 * @throws Exception
	 
	SquareMatrix subtract(SquareMatrix sm1) throws Exception {
		SquareMatrix subtracted = SquareMatrix.subtract(this, sm1);
		return subtracted;
	}
	


	
	 * Multiplies sm1 and sm2.
	 * @param sm1
	 * @param sm2
	 * @return
	 * @throws Exception
	 
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {

		if (sm1.elements.length != sm2.elements.length) {
			throw new Exception("Both matrices must be of the same size.");
		}

		double currentElement;
		double[][] currentElementArray = new double[sm1.elements.length][sm1.elements[0].length];
		for (int i=0; i<sm1.elements.length; i++) {
			for (int j=0; j<sm1.elements.length; j++) {
				for (int k=0; k<sm1.elements.length; k++) {

					currentElement = sm1.elements[i][k] * sm2.elements[k][j];
					currentElementArray[i][j] += currentElement;
				}
			}
		}
		return new SquareMatrix(currentElementArray);
	}
	

	
	 * Multiplies object it belongs to with argument matrix.
	 * @param sm1
	 * @return
	 * @throws Exception
	 
	public SquareMatrix multiply(SquareMatrix sm1) throws Exception{
		SquareMatrix multiplied = SquareMatrix.add(this, sm1);
		return multiplied;
	}	
}

*/