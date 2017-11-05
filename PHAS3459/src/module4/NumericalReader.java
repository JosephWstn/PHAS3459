
package module4;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
public class NumericalReader {


	// declaring variables
	static double minValue;
	static double maxValue;
	static double sumOfValues;
	static int nValues;
	private String file;

 
	/*
	 * User inputs string from keyboard
	 * stores as string
	 */
	public static String getStringFromKeyboard() throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Type the folder you want to save the document");
		String s = b.readLine();
		return s;
	}

	/*
	 * Takes URL string as argument
	 * returns URL as bufferedreader
	 */
	public BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);	
	}

	/*
	 * Creates file dataFile
	 * Initialises values
	 */
	void analysisStart(String dataFile) {
		this.file = (dataFile);
		this.minValue = 0;
		this.maxValue = 0;
		this.nValues = 0;
		this.sumOfValues = 0;
		System.out.println("The file will be located at: "+ dataFile);
	}

	/*
	 * Method takes each line of a text as argument. Ignores any lines that are blank or begin with a letter.
	 * If value is number, converts it to double and finds max number, min number, sum of numbers and total number of values
	 */
	void analyseData(String line) throws Exception{

		//scanning each line
		Scanner s = new Scanner(line);
		while(s.hasNextDouble()) {
			//ignore if line is empty or begins with a letter
			if (line.isEmpty() || Character.isSpaceChar(line.charAt(0)) || Character.isLetter(line.charAt(0))){
			}

			else{
				//convert scanner to double
				double d = s.nextDouble();
				System.out.println(d);

				//initialise first value as the min
				if (minValue == 0) {
					minValue = d;
				}

				//initialise first value as the max
				if (maxValue == 0) {
					maxValue = d;
				}

				//update sum of values
				sumOfValues += d;

				//update total number of values
				nValues++;

				//update min value
				if (d < minValue) {
					minValue = d;
				}

				//update max value
				if (d > maxValue) {
					maxValue = d;
				}

				//writes numbers to the file
				FileWriter fw = new FileWriter (this.file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);

				//each number on a seperate line in file
				pw.println(d);
				pw.close();
			}
		}
		s.close();
	}

	//method prints minValue etc
	static void analysisEnd() {
		System.out.println();
		System.out.println("Min: " + minValue);
		System.out.println("Max: " + maxValue);
		System.out.println("Average: " + sumOfValues / nValues);
		System.out.println("Number of Values: " + nValues);
		System.out.println();
	}


	public static void main(String[] args) throws Exception {

		//User types folder that will form a save directory
		String saveDir;
		try{
			saveDir = NumericalReader.getStringFromKeyboard();
		}
		//if folder cannot be found, use the home directory
		catch (Exception e){
			System.out.println("This directory is invalid, home directory will be used");
			saveDir = System.getProperty("user.home");
		}

 
		//initialising save file
		String saveFile1 = (saveDir + File.separator + "numbers1.txt");


		// File 1
		System.out.println("File 1: ");


		NumericalReader nr1 = new NumericalReader();
		BufferedReader reader1 = null;
		String line = "";

		try{
			//Get the .txt from URL
			reader1 = nr1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");

			//initialises values
			nr1.analysisStart(saveFile1); 

			System.out.println("Numbers in file:");
			line = "";

			//Loop until the end of the document
			while ((line = reader1.readLine()) != null) {
				// analyse lines, check for comments etc
				nr1.analyseData(line); 
			}
			// print min, max, etc
			nr1.analysisEnd(); 
		}
		catch (Exception e){
			System.out.println("Error: " + e);
		}

		// file 2

		System.out.println("File 2: ");

		//initialise numericalreader, buffered reader & savefile
		NumericalReader nr2 = new NumericalReader();
		BufferedReader reader2 = null;
		String saveFile2 = (saveDir + File.separator + "numbers2.txt");

		try{
			//get .txt file from URL
			reader2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");

			//method initializes values
			nr2.analysisStart(saveFile2);
			System.out.println("Numbers in file:");

			//Loop until the end of the document
			while ((line = reader2.readLine()) != null) {
				// analyze lines, check for comments etc
				nr2.analyseData(line); // analyze lines, check for comments etc.
			}
			// print min, max, etc
			nr2.analysisEnd(); // print min, max, etc.
		}
		catch (Exception e){
			System.out.println("Error: " + e);
		}

	}
}


