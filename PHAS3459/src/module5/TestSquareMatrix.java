package module5;

public class TestSquareMatrix {

	public static void main(String[] args) throws Exception {


		//matrix a
		double [][] aa = {{1.0,2.0,0.0},
				{0.0,2.0,0.0},
				{-2.0,0.0,1.0} };

		SquareMatrix am = new SquareMatrix(aa);


		//matrix b
		double [][] ba = {{2.0,1.0,0.0},
				{0.0,1.0,0.0},
				{-1.0,0.0,1.0} };

		SquareMatrix bm = new SquareMatrix(ba);

		//matrix c
		double [][] ca = {{4.0,3.0},
				{3.0,2.0}};

		SquareMatrix cm = new SquareMatrix(ca);

		//matrix d
		double [][] da = {{-2.0,3.0},
				{3.0,-4.0} };

		SquareMatrix dm = new SquareMatrix(da);

		//multiplying necessary matrices
		SquareMatrix atb = SquareMatrix.multiply(am,bm);
		SquareMatrix bta = SquareMatrix.multiply(bm,am);
		SquareMatrix ctd = SquareMatrix.multiply(cm, dm);

		System.out.println("Matrix a: \n" + am);
		System.out.println("Matrix b: \n" + bm);
		System.out.println("Matrix c: \n" + cm);
		System.out.println("Matrix d: \n" + dm);
		System.out.println("a + b = \n" + SquareMatrix.add(am,bm));
		System.out.println("a - b = \n" + SquareMatrix.subtract(am,bm));
		System.out.println("a x b = \n" + atb);
		System.out.println("b x a = \n" + bta);
		System.out.println("ab - ba = \n" + SquareMatrix.subtract(atb,bta));
		System.out.println("c x d = \n" +ctd);
		System.out.println("This will return true if c x d equals a 2x2 unit matrix: \n"+ctd.equals(SquareMatrix.unitMatrix(2)));


	}	
}