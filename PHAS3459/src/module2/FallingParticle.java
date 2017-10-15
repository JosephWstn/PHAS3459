package module2;

public class FallingParticle {
	
	// member variables mass, drag co-eff, time elapsed, height @ time t, initial height, velocity @ time t, gravity
	static double m, d, t=0, z=10, h=10, v=0;
	final static double g = 9.81;
	
	//constructor for falling particle with arguments mass and dragg co-eff
	public FallingParticle(double m, double d) {
		this.m = m; 
		this.d = d;
	}
	
	//height setter
	public double setH(double h){
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
	public double getV(double v){
		return v;
	}
	
	//time getter
	public double getT (double t){
		return t;
	}
	
	//method to be carried out every timestep
	static double doTimeStep(double deltaT){
		//set what the acceleration is
		double a = (d*Math.pow(v, 2)/m) - g;
		//update velocity and height
		v += a * deltaT;
		z += ( v * deltaT);
		System.out.println("Acceleration:" + a + " m/s^2"); //this is so i can monitor the acceleration to make sure it's working
		return a;	
	}
	
	//method to initiate the drop
	static void drop (double deltaT){
		//height starts at initial height
		z=h; 
		double ttot=0;
		//loop until the height is zero
		while (z>=0){
			//these so i can keep an eye on time, velocity and height
			System.out.format("Time: "+ttot + " s.\n"); 
			System.out.format("Height: " + z + " m.\n");
			System.out.format("Velocity: " + v+" m/s.\n \n");
			//carry out the timestep method and update total time
			doTimeStep(deltaT);
			ttot += deltaT; //update total time
		}
		
		//System.out.println("velocity "+v);
		System.out.println("Values when the particle reached the bottom:");
		System.out.println("Time: "+ttot+" s");
		System.out.println("Velocity: "+v+" m/s. This is the terminal velocity");
	}
	
}
