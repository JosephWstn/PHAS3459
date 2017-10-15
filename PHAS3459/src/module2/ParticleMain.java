package module2;

public class ParticleMain {

	public static void main(String[] args) {
		//set mass and drag co-eff
		FallingParticle p = new FallingParticle(5.2,3.6);

		//set initial height and velocity
		p.setH(10);
		p.setV(0);


		//falling with timestep of 0.5s, printing total time and final velocity
		FallingParticle.drop(0.5);
		System.out.println("For a time step of 0.5s:");
		System.out.println("Final velocity: "+ p.getV() + " m/s");
		System.out.println("Time taken: "+p.getT()+ " s");
		System.out.println();

		//timestep 0.1s
		FallingParticle.drop(0.1);
		System.out.println("For a time step of 0.1s:");
		System.out.println("Final velocity: "+ p.getV() + " m/s");
		System.out.println("Time taken: "+p.getT()+ " s");
		System.out.println();

		//timestep 0.01s
		FallingParticle.drop(0.01);
		System.out.println("For a time step of 0.01s:");
		System.out.println("Final velocity: "+ p.getV() + " m/s");
		System.out.println("Time taken: "+p.getT()+ " s");
		System.out.println();

		//timestep 0.001s
		FallingParticle.drop(0.001);
		System.out.println("For a time step of 0.001s:");
		System.out.println("Final velocity: "+ p.getV() + " m/s");
		System.out.println("Time taken: "+p.getT()+ " s");
		System.out.println();

		//timestep 0.0001s
		FallingParticle.drop(0.0001);
		System.out.println("For a time step of 0.0001s:");
		System.out.println("Final velocity: "+ p.getV() + " m/s");
		System.out.println("Time taken: "+p.getT()+ " s");
		System.out.println();

		//explain the difference in results
		System.out.println("The timestep defines the steps in the simulation. So a timestep of 0.5 seconds means the particle's position and speed are \nbeing updated 0.5 seconds at a time. \nThis means that the code will actually simulate too far, and will find the time to go slightly below the height z=0, as it \nonly knows to stop once the z it calculates is lower than 0. \nThe smaller the timestep, the less it will step over zero and know to stop, this is why the lower timesteps provide a more accurate result.");
	}
}
