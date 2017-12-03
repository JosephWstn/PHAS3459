package module6;

//LabelledDataPoint is a type of DataPoint but with a label after ey
public class LabelledDataPoint extends DataPoint{

	//Member variable for the label
	private String label;

	//constructor for labelleddatapoint
	public LabelledDataPoint(double x, double y, double ey, String label) throws Exception {
		super(x, y, ey); 
		this.x=x;
		this.y=y;
		this.ey=ey;
		this.label = label;
	}

	//How to print a labelled datapoint
	public String toString() {
		return (this.label +": x = " + this.x + ", y = " + this.y + " \u00B1 "+ this.ey);	
	}
}
