package module5;

import java.util.Arrays;

public class SquareMatrix {


	double[][] elements;



	public SquareMatrix (double[][] elements) throws Exception{
		this.elements = new double[elements.length][elements[0].length];
		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < elements[0].length; j++)
				this.elements[i][j] = elements[i][j];
		if (elements.length != elements[0].length) {
			throw new Exception("SquareMatrix can only use square matrices");
		}
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (double row[]  : this.elements) {
			String line = Arrays.toString(row);
			sb.append(line +"\n");
		}
		String sm = sb.toString();
		return sm;
	}

	public static SquareMatrix unitMatrix(int size) throws Exception{
		double[][] ia = new double [size][size];
		for (int t=0; t < size; t++) {
			ia [t][t]=1;
		}
		SquareMatrix i = new SquareMatrix(ia);
		return i;
	}


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

	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.elements.length != sm2.elements.length){
			throw new Exception ("To add matrices they must be the same size.");
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
	
	public SquareMatrix add(SquareMatrix sm1) throws Exception{
		SquareMatrix added = SquareMatrix.add(this,sm1);
		return added;
	}

	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2)throws Exception{
		if (sm1.elements.length != sm2.elements.length){
			throw new Exception ("To subtract matrices they must be the same size.");
		}
		double currentElement;
		double [][] currentElementArray = new double [sm1.elements.length][sm1.elements[0].length];
		for (int i=0; i<sm1.elements.length;i++){
			for (int j=0; j<sm1.elements.length;j++){
				currentElement = sm1.elements[i][j] - sm2.elements[i][j];
				currentElementArray [i][j]= currentElement;
			}
		}
		return new SquareMatrix(currentElementArray);
	}
	
	public SquareMatrix subtract(SquareMatrix sm1) throws Exception{
		SquareMatrix sub = SquareMatrix.subtract(this,sm1);
		return sub;
	}

	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2)throws Exception{
		if (sm1.elements.length != sm2.elements.length){
			throw new Exception ("To multiply squarematrices they must be the same size.");
		}
		double currentElement;
		double[][] currentElementArray = new double [sm1.elements.length][sm1.elements[0].length];
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
	
	public SquareMatrix multiply(SquareMatrix sm1) throws Exception{
		SquareMatrix mul = SquareMatrix.multiply(this,sm1);
		return mul;
	}
}
