package module3;

public class TestExceptions {

	public static void main(String[] args)  {
		Complex c1= new Complex (1,2);
		Complex c2 = new Complex (0,0);

		ThreeVector v1 = new ThreeVector (1,2,3);
		ThreeVector v2 = new ThreeVector (0,0,0);

		try {
			FallingParticle p1 = new FallingParticle(-3,4);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			FallingParticle p2 = new FallingParticle(3,-4);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {

			System.out.println(Complex.divide(c1,c2));
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(c2.normalised());
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(ThreeVector.angle(v1,v2));
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(v1.angle(v2));
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(v2.unitVector());
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			FallingParticle.setH(-5);
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}
