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

	
	//arraylist of the index information from the URL.
	//throwing both exception and ioexception bc trying to make it work
	public static ArrayList<Index> indexInfoURL (String urlName)  throws Exception, IOException{
		ArrayList<Index> list = new ArrayList<Index>();
		//read URL and turn it into buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		//put the indexes into the list
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


	public static void main(String[] args) {
		try{
			//array list of the information in the title line of recordings 
			ArrayList<Integer> titleInfo01 = titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
			ArrayList<Integer> titleInfo02 = titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
			ArrayList<Integer> titleInfo03 = titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
			ArrayList<Integer> titleInfo04 = titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");
			
			
			
			//array list of all the amplitudes in recording 01
			ArrayList<Integer> ampList01 = arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
			ArrayList<Integer> ampList02 = arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
			ArrayList<Integer> ampList03 = arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
			ArrayList<Integer> ampList04 = arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");
			

			ArrayList<Index> indexInfo = indexInfoURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt"); 
					
			
			double amp01 = amplitude(ampList01, titleInfo01); 
			double amp02 = amplitude(ampList02, titleInfo02); 
			double amp03 = amplitude(ampList03, titleInfo03); 
			double amp04 = amplitude(ampList04, titleInfo04); 
			
			
			//printing stuff out for recording 01:
			System.out.println("Recording 01 information: ");
			//System.out.println(indexInfo2.get(0));
			System.out.print("Duration of recoding01: "+duration (titleInfo01));
			System.out.println("\nAmplitude of recording01: "+amp01);
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//printing stuff out for recording 02:
			System.out.println("Recording 02 information: ");
			//System.out.println(indexInfo2.get(1));
			System.out.print("Duration of recoding02: "+duration (titleInfo02));
			System.out.println("\nAmplitude of recording02: "+amp02);
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//printing stuff out for recording 03:
			System.out.println("Recording 03 information: ");
			//System.out.println(indexInfo2.get(2));
			System.out.print("Duration of recoding03: "+duration (titleInfo03));
			System.out.println("\nAmplitude of recording03: "+amp03);
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//printing stuff out for recording 04:
			System.out.println("Recording 04 information: ");
			//System.out.println(indexInfo2.get(3));
			System.out.print("Duration of recoding04: "+duration (titleInfo04));
			System.out.println("\nAmplitude of recording04: "+amp04);
			
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("The corresponding instruments are: ");
			for(int i =0; i<3 ; i++){
				System.out.println(indexInfo.get(i));
			}
			
		}
		
		//catching the exception and the ioexception
		catch (IOException E){
			E.printStackTrace();
			System.out.println("incorrect URL: IOException");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Incorrect URL: Regular Exception");
		}
	}
}