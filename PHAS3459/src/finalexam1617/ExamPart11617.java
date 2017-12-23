package finalexam1617;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ExamPart11617 {

	public static int sFreq, num, maxAmp, amp;



	//ArrayList of the information in the title
	public static ArrayList<Integer> titleInfo(String urlName) throws IOException{
		//initialise the arraylist of integers
		ArrayList<Integer> list = new ArrayList<Integer>();
		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//boolean to only consider the first line
		boolean first = true;
		String line;
		while ((line = br.readLine()) != null){
			RecordingInfo currentLine = new RecordingInfo(line);
			if(first) {
				list.add(currentLine.getsFreq());
				list.add(currentLine.getNum());
				list.add(currentLine.getMaxAmp());
				first = false;
			}
			else {
				return list;
			}

		}
		return list;
	}

	//Duration = num / sFreq
	public static double duration (ArrayList<Integer> list) {
		//cast to double so the output can have decimal places
		return (double) list.get(1)/ (double)list.get(0);
	}

	//ArrayList of the amplitudes (ie data after first line) 
	public static ArrayList<Integer> arrayListFromURL(String urlName) throws IOException{
		//initialise arraylist of integers
		ArrayList<Integer> list = new ArrayList<Integer>();
		//read URL and turn it into buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//first boolean so it ignores the title line
		boolean first = true;
		String line;
		while ((line = br.readLine()) != null){
			RecordingInfo currentLine = new RecordingInfo(line);
			if(first) {
				first = false;
			}
			else {
				list.add(currentLine.getAmp());
			}

		}
		return list;
	}

	//ArrayList of index info - this is from a file as the URL wasn't working
	public static ArrayList<Index> indexInfo (String fileName) throws IOException{
		ArrayList<Index> list = new ArrayList<Index>();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new  BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null){
			Index current = new Index (line);
			list.add(current);
		}
		return list;
	}

	//root mean square calculator, pretty intuitive from the equstion
	public static double amplitude (ArrayList<Integer> ampList, ArrayList<Integer> titleInfo){
		double sum=0;
		for (int i =0; i < ampList.size(); i++){
			sum += Math.pow(ampList.get(i), 2);
		}
		//Math.sqrt(sum/ampList.size()) is the root mean squre
		//titleInfo.get(2) is max amp
		return 20*Math.log10(Math.sqrt(sum/ampList.size())/titleInfo.get(2));
	}


	public static void main(String[] args) throws IOException {

		//array list of the information in the title line of recording 01
		ArrayList<Integer> titleInfo01 = titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");

		//array list of all the amplitudes in recording 01
		ArrayList<Integer> ampList01 = arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");

		//getting the index from the file
		String saveDir = "N:";
		String indexFile = (saveDir + File.separator + "index.txt");
		ArrayList<Index> indexInfo = indexInfo(indexFile);

		double amp01 = amplitude(ampList01, titleInfo01); 

		//printing stuff out for recording 01:

		System.out.println("Recording 01 information: ");
		System.out.println();
		System.out.println(indexInfo.get(0));
		System.out.println();
		System.out.print("Duration of recoding01: "+duration (titleInfo01));
		System.out.println();
		System.out.println("Amplitude of recording01: "+amp01);
	}
}