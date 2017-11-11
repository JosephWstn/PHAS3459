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
		
		
		SquareMatrix atb = SquareMatrix.multiply(am,bm);
		SquareMatrix bta = SquareMatrix.multiply(bm,am);
		SquareMatrix ctd = SquareMatrix.multiply(cm, dm);
		
		System.out.println(SquareMatrix.add(am,bm));
		System.out.println(SquareMatrix.subtract(am,bm));
		System.out.println(atb);
		System.out.println(bta);
		System.out.println(SquareMatrix.subtract(atb,bta));
		System.out.println(ctd);
		System.out.println(ctd.equals(SquareMatrix.unitMatrix(2)));
		
		
	}	
}