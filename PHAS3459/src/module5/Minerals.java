package module5;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Minerals {

	public static void main(String[] args) throws Exception {
		
		HashMap<Integer,Double> masses = new HashMap<Integer,Double>();
		HashMap<String,Integer> places = new HashMap<String,Integer>();


		URL um = new URL ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
		InputStream ism = um.openStream();
		InputStreamReader isrm = new InputStreamReader(ism);
		BufferedReader brm = new BufferedReader(isrm);		
		String line;
		
		
		while ((line = brm.readLine()) != null){
			Scanner sm = new Scanner(line);
			masses.put(sm.nextInt(), sm.nextDouble());
			sm.close();
		}
		
		
		URL ul = new URL ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
		InputStream isl = ul.openStream();
		InputStreamReader isrl = new InputStreamReader(isl);
		BufferedReader brl = new BufferedReader(isrl);		
		
		while ((line = brl.readLine()) != null){
			Scanner sl = new Scanner(line);
			places.put(sl.next(), sl.nextInt());
			sl.close();
		}
		
		Map.Entry<Integer, Double> max = null;
		Map.Entry<Integer, Double> min = null;
		
		for (Map.Entry<Integer, Double> entry : masses.entrySet()){
			
			if(min == null || min.getValue() > entry.getValue()){
				min = entry;
			}
			if(max == null || max.getValue() < entry.getValue()){
				max = entry;
			}
		}
		
		System.out.println("The heaviest sample is code " + max.getKey() + " which has a mass of " + max.getValue()+ "grammes. This was found at " + places.get(max.getKey()));
		System.out.println("The lightest sample is code " + min.getKey() + " which has a mass of " + min.getValue()+ "grammes. This was found at " + places.get(min.getKey()));
	}

}
