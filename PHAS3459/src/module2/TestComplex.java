package module2;

public class TestComplex {

	public static void main(String[] args) {
		
		//define two complex numbers to test the complex methods
		Complex c1 = new Complex (1,2);
		Complex c2 = new Complex (-2,-1);
		
		System.out.println("CN 1: "+c1);
		System.out.println("CN 2: "+c2);
		System.out.println();
		System.out.println("CN 1 times CN 2: "+Complex.multiply(c1,c2));
		System.out.println();
		System.out.println("CN 1 divided by CN 2: "+Complex.divide(c1, c2));
		System.out.println();
		System.out.println("CN 1 times I: "+Complex.multiply(c1, Complex.I));
		System.out.println();
		System.out.println("CN 1 divided by zero: "+Complex.divide(c1, Complex.ZERO));
		System.out.println();
		System.out.println("CN 1 times complex conjugate of CN 2: "+Complex.multiply(c1,c2.conjugate()));
		System.out.println();
		System.out.println("CN 2 times complex conjugate of CN 2: "+Complex.multiply(c2,c2.conjugate()));
		
			
	}

}
