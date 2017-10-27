
package module4;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
public class NumericalReader {

	public NumericalReader() {}
	static double minValue;
	static double maxValue=0;
	static double sumOfValues;
	static int nValues;

	public static String getStringFromKeyboard() throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Type the folder you want to save the document");
		String s = b.readLine();
		return s;
	}


	public BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);	
	}


	static void analysisStart(String dataFile) throws IOException {
		FileWriter f = new FileWriter(dataFile);
		int minValue, maxValue, nValues, sumOfValues;
		System.out.println("The file will be saved in: "+ dataFile);
	}


	static void analyseData(String line) throws IOException{
		
		Scanner lineScanner = new Scanner(line);
		while(lineScanner.hasNext()) {
			if (line.isEmpty() || Character.isSpaceChar(line.charAt(0)) || Character.isLetter(line.charAt(0))){
			}

			if (Character.isDigit(line.charAt(0))){
				double convertToDouble = Double.parseDouble(line);
				sumOfValues += convertToDouble;
				nValues++;
				System.out.println(convertToDouble);
				if (convertToDouble < minValue) {
					minValue = Integer.parseInt(line);
				}

				if (convertToDouble < maxValue) {
					maxValue = Integer.parseInt(line);
				}
				lineScanner.next();
			}

		}

		lineScanner.close();
	}

	static void analysisEnd() {
		System.out.println("Min: " + minValue);
		System.out.println("Max: " + maxValue);
		System.out.println("Average: " + sumOfValues / nValues);
		System.out.println("Sum: " + sumOfValues);
		System.out.println("Number of Values: " + nValues);
	}

	public static void main(String[] args) throws IOException {


		String saveDir = NumericalReader.getStringFromKeyboard();
		String saveFile = ("D:" + File.separator + saveDir + File.separator + "numbers.txt");

		NumericalReader nr1 = new NumericalReader();
		NumericalReader nr2 = new NumericalReader();
		
		BufferedReader reader1 = nr1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		String line1 = "";
		
		BufferedReader reader2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		String line2 = "";
		
		nr2.analysisStart(saveFile); // initialize minValue etc.
		while ((line1 = reader1.readLine()) != null) {
			nr1.analyseData(line1); // analyze lines, check for comments etc.
		}
		nr1.analysisEnd(); // print min, max, etc.
	}
}


