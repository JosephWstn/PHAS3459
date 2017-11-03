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
		SquareMatrix sm3 = new SquareMatrix(null);
		double currentElement;
		for (int t = 0; t < sm1.elements.length; t++) {
			for (int s = 0; s < sm1.elements.length; s++) {
				currentElement = sm1.elements[s][t] + sm2.elements[s][t];
				sm3.elements[s][t] = currentElement;
			}
		}
		return sm3;
	}
}