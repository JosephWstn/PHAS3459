package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class WordCounter {

	/*
	 * Argument is URL as string
	 * Returns the URL as a buffered reader
	 */
	public static BufferedReader brFromURL(String urlName) throws Exception {
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);	
	}

	/*
	 * Argument is filename
	 * Reades file and returns the file as bufferedreader
	 */
	public static BufferedReader brFromFile(String fileName) throws Exception{
		FileReader fr = new FileReader(fileName);
		return new BufferedReader(fr);
	}

	/*
	 * Method counts words in a file
	 * Argument is the data as a bufferedreader
	 * returns number of words
	 */
	public static int countWordsInResource(BufferedReader dataAsBR) {
		//buffered reader to scanner
		Scanner s = new Scanner(dataAsBR);
		int sum = 0;
		while (s.hasNext()) {
			//update sum
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
