package module4;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
public class NumericalReader {

	public NumericalReader() {}
	int minValue, maxValue, nValues, sumOfValues;

	public static String getStringFromKeyboard() throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Type Something");
		String s = b.readLine();
		System.out.println("You typed: " + s);
		return s;
	}

	public BufferedReader brFromURL(String urlName) throws Exception{
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);	
	}

	void analysisStart(String dataFile) throws IOException {
		FileWriter f = new FileWriter(dataFile);
		int minValue, maxValue, nValues, sumOfValues;
	}


	void analyseData(String line) throws IOException{
		Scanner lineScanner = new Scanner(line);
		while(lineScanner.hasNext()) {
			if (line.isEmpty() || Character.isLetter(line.charAt(0))){
				lineScanner.next();
			}
			System.out.println(line);
			FileWriter f = new FileWriter(line);

			if (minValue > Integer.parseInt(line)) {
				minValue = Integer.parseInt(line);
			}

			if (maxValue < Integer.parseInt(line)) {
				maxValue = Integer.parseInt(line);
			}

			nValues++;
			sumOfValues+=Integer.parseInt(line);
			lineScanner.next();
		}
	}

	void analysisEnd() {
		System.out.println("Min: " + minValue);
		System.out.println("Max: " + maxValue);
		System.out.println("Average: " + sumOfValues / nValues);
		System.out.println("Number of Values: " + nValues);
	}

	public static void main(String[] args) throws 	IOException {

		String dataFile = ("N:" + File.separator + "mywork" + File.separator + "numbers.txt");
		File outputfile = new File(dataFile);
		FileWriter fw = new FileWriter(outputfile);
		String saveDir = NumericalReader.getStringFromKeyboard();

		String saveFile = (saveDir + File.separator + dataFile);
		NumericalReader nr = new NumericalReader();
		nr.analysisStart(saveFile);
		while ((saveFile = br .readLine()) != null) {
			nr.analyseData(saveFile); // analyze lines, check for comments etc.
		}
		nr.analysisEnd(); // print min, max, etc.
	}
}


