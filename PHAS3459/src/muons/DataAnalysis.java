package muons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import paularain.PRainData;



public class DataAnalysis {

	int decayTime;

	public static int muon (String line){
		Scanner sc = new Scanner(line);
		return sc.nextInt();
	}


	public static  ArrayList<Integer> arrayListFromFile(String fileName) throws Exception{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while ((line = br.readLine()) != null){
			// appends EQPoints object to ArrayList
			int current = muon(line);
				list.add(current);
			
		}	
		return list;
	}

	public static ArrayList<Integer> dataAnalysis (ArrayList<Integer> list) {
		int fifties = 0;
		int above = 0;
		int below = 0;
		ArrayList<Integer> successes = new ArrayList<Integer>();
		for (int i = 1; i <= list.size(); i++) {
			if (list.get(i-1) > 2197) {
				above++;
			}
			else {
				below++;
			}
			if (i %  50 == 0) {
				fifties++;
				System.out.println("for the " + fifties +"th 50 values:");
				System.out.println("Above: "+above);
				System.out.println("Below: "+below);
				successes.add(below);
				above = 0;
				below = 0;
			}
		}
		return successes;
	}





	public static void main (String args[]) throws Exception{
		String saveDir = "N:";
		String saveFile = (saveDir + File.separator + "thirdrun.txt");
		ArrayList<Integer> list = arrayListFromFile(saveFile);
		ArrayList<Integer> nbrOfSuccesses = dataAnalysis(list);
		System.out.println(nbrOfSuccesses);
	}
}
