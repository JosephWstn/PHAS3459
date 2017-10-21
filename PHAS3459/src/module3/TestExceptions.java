package module3;

public class TestExceptions {

	public static void main(String[] args)  {
		
		//define complex numbers to trigger exceptions
		Complex c1= new Complex (1,2);
		Complex c2 = new Complex (0,0);
		
		//define vectors to trigger exceptions
		ThreeVector v1 = new ThreeVector (1,2,3);
		ThreeVector v2 = new ThreeVector (0,0,0);

		//try particle with negative mass
		try {
			FallingParticle p1 = new FallingParticle(-3,4);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//try particle with negative drag coeff
		try {
			FallingParticle p2 = new FallingParticle(3,-4);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//try to divide by zero complex number (0 + 0i)
		try {

			System.out.println(Complex.divide(c1,c2));
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//try to normalise complex number 0+0i
		try {
			System.out.println(c2.normalised());
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//try to find angle between vectors. One is (0,0,0)
		try {
			System.out.println(ThreeVector.angle(v1,v2));
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//try to find angle between vectors. One is (0,0,0)
		try {
			System.out.println(v1.angle(v2));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//try to find unit vector of (0,0,0)
		try {
			System.out.println(v2.unitVector());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//try to drop particle from negative height
		try {
			FallingParticle.setH(-5);
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}
