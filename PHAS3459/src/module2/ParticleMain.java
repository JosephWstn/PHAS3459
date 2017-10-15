package module2;

public class ParticleMain {

	public static void main(String[] args) {
		//set mass and drag co-eff
		FallingParticle.h=10;
		FallingParticle p = new FallingParticle(5.2,3.6);
		FallingParticle.drop(0.0001);
		
	}
}
