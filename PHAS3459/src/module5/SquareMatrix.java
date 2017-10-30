package module5;

public class SquareMatrix {


	double[][] elements;


	
	public SquareMatrix (double[][] elements) throws Exception{
		System.out.println(elements.length);
		if (elements[0] !=  elements[1]) {
			throw new Exception("SquareMatrix can only use square matrices");
		}
	}
}