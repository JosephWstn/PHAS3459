package module5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
public class DataAnalysis {
	
	
	static ArrayList dataFromURL(String url)throws IOException {
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		Scanner s = new Scanner(br);
		double xi, yi, eyi;
		while (s.hasNextLine()){
			
			s.nextDouble() = xi;
			s.nextDouble() = yi;
			s.nextDouble() = eyi;
			
			s.nextLine();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
