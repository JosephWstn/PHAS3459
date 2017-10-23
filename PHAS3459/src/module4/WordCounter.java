package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class WordCounter {


	public static BufferedReader brFromURL(String urlName) throws Exception {
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);	
	}

	public static BufferedReader brFromFile(String fileName) throws Exception{
		FileReader fr = new FileReader(fileName);
		return new BufferedReader(fr);
	}

	public static int countWordsInResource(BufferedReader dataAsBR) {
		Scanner s = new Scanner(dataAsBR);
		int sum = 0;
		while (s.hasNext()) {
			sum++;
			s.next();
		}
		s.close();
		return sum;
	}



	public static void main(String[] args) throws Exception {
		try {
			System.out.println(countWordsInResource(brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt")));
		}
		catch (Exception e) {
			System.out.println("URL does not exist");
		}
	}
}
