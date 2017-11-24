package module6;

public class LabelledDataPoint extends DataPoint{



	private String label;


	public LabelledDataPoint(double x, double y, double ey, String label) throws Exception {
		super(x, y, ey);
		this.x=x;
		this.y=y;
		this.ey=ey;
		this.label = label;
	}


	public String toString() {
		return (this.label +": x = " + this.x + ", y = " + this.y + " \u00B1 "+ this.ey);	
	}




}
