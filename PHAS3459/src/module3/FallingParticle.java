package module3;

public class FallingParticle {

	// member variables mass, drag co-eff, time elapsed, height @ time t, initial height, velocity @ time t, gravity
	static double m, d, t=0, z=10, h=10, v=0;
	final static double g = 9.8065;

	//constructor for falling particle with arguments mass and dragg co-eff
	public FallingParticle(double m, double d) throws Exception {
		//exception if mass or drag coeff is negative. Or if mass is 0. 
		if (m <= 0) {
			throw new Exception("Cannot have negative or zero mass");
		}
		if (d < 0) {
			throw new Exception("Cannot have negative drag coefficient");
		}
		this.m = m; 
		this.d = d;
	}

	//height setter
	public static double setH(double h) throws Exception {
		//exception if trying to drop from negative or zero height
		if (h<=0) {
			throw new Exception("Cannot drop from negative or zero height");
		}
		return h;
	}
	//height getter
	public double getZ(double z){
		return z;
	}

	//velocity setter
	public double setV(double v){
		return v;
	}

	//velocity getter
	public double getV(){
		return v;
	}

	//time getter
	public double getT (){
		return t;
	}

	//method to be carried out every timestep
	static double doTimeStep(double deltaT){
		//set acceleration
		double a = (d*Math.pow(v, 2)/m) - g;
		//update velocity and height
		v += a * deltaT;
		z += ( v * deltaT);
		return a;	
	}

	//method to initiate the drop
	static void drop (double deltaT) {
		//height starts at initial height, velocity starts at 0
		z=h;
		v=0;
		t=0;
		//loop until the height is zero
		while (z>0){
			//carry out the timestep method and update total time
			doTimeStep(deltaT);
			t += deltaT; //update total time
		}
	}
}
 