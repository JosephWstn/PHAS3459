package module5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
public class DataAnalysis {


	static ArrayList<DataPoint> dataFromURL(String url)throws Exception {
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);		
		ArrayList<DataPoint> datapoints = new ArrayList<DataPoint>();
		String line;
		while ((line = br.readLine()) != null){
			Scanner s = new Scanner(line);
			DataPoint dp = new DataPoint (s.nextDouble(), s.nextDouble(), s.nextDouble());
			datapoints.add(dp);
			s.close();
		}
		return datapoints;
	}


	static double goodnessOfFit(Theory t, ArrayList<DataPoint> p){
		double chiSq = 0;

		for(DataPoint dp : p){

			double yt = t.y(dp.getx());
			double ym = dp.gety();
			double ey = dp.getey();

			chiSq += (Math.pow((ym - yt),2))/(Math.pow(ey, 2)); 
		}
		return chiSq;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<DataPoint> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		Theory t2 = new Theory(2);
		Theory t4 = new Theory(4);

		double chiSq2 = goodnessOfFit(t2, data);
		double chiSq4 = goodnessOfFit(t4, data);

		System.out.println("X^2 for y=x^2 is: "+ chiSq2);
		System.out.println("X^2 for y=x^4 is: "+ chiSq4);
		System.out.println("The X^2 value for y=x^2 is lower, and thus better describese the data.\nHowever, both values are extremely high so another value of n should be found to lower the X^2 value further.");
	}
	
}
