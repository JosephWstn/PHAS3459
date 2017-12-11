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
		ArrayList<Integer> list = new ArrayList<Integer>();
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
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
		return (double) list.get(1)/ (double)list.get(0);
	}

	//ArrayList of the amplitudes
	public static ArrayList<Integer> arrayListFromURL(String urlName) throws IOException{
		ArrayList<Integer> list = new ArrayList<Integer>();
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		boolean first = true;
		double duration;
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

	//ArrayList of index info
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




	public static void main(String[] args) throws IOException {
		ArrayList<Integer> titleInfo = titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		ArrayList<Integer> ampList = arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		String saveDir = "N:";
		String indexFile = (saveDir + File.separator + "index.txt");
		ArrayList<Index> indexInfo = indexInfo(indexFile);

		System.out.println("index info: "+indexInfo);
		System.out.println();
		System.out.print("Duration of recoding01: "+duration (titleInfo));
	}
}