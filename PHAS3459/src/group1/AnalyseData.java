package group1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalyseData {


	//get bufferedreader
	public static BufferedReader brFromFile(String fileName) throws Exception{
		FileReader fr = new FileReader(fileName);
		return new BufferedReader(fr);
	}


	//find total measurements and lowest area & extent
	static String line1;
	public static void totandmins(BufferedReader br) throws Exception{
		int tot = 0;
		double extentmin = Double.POSITIVE_INFINITY;
		double areamin = Double.POSITIVE_INFINITY;
		MonthInfo lowestextentmonth = new MonthInfo();
		MonthInfo lowestareamonth = new MonthInfo();
		while ((line1 = br.readLine()) != null){
			if (line1.contains("year")){}
			else{
				MonthInfo currentmonth = new MonthInfo(line1);
				tot++;
				try{
					if (currentmonth.getExtent() < extentmin){
						extentmin = currentmonth.getExtent();
						lowestextentmonth = currentmonth;
					}
					if (currentmonth.getArea() < areamin){
						areamin = currentmonth.getArea();
						lowestareamonth = currentmonth;
					}
				}
				catch (Exception e){}
			}
		}
		System.out.println("Number of data points: "+tot+"\n");
		System.out.println("Month with lowest Extent: \n"+lowestextentmonth+"\n \n");
		System.out.println("Month with lowest Area: \n"+lowestareamonth);
	}


	public static HashMap<Integer, ArrayList<MonthInfo>> sortintomonths (BufferedReader br) throws IOException, Exception{
		String line2;
		HashMap<Integer, ArrayList<MonthInfo>> monthdatamap = new HashMap<Integer, ArrayList<MonthInfo>>();
		ArrayList<MonthInfo> listjan = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listfeb = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listmar = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listapr = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listmay = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listjun = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listjul = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listaug = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listsep = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listoct = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listnov = new ArrayList<MonthInfo>();
		ArrayList<MonthInfo> listdec = new ArrayList<MonthInfo>();

		while ((line2 = br.readLine()) != null){
			if (line2.contains("year")){}
			else{
				MonthInfo currentmonthinfo = new MonthInfo(line2);
				if (monthdatamap.get(currentmonthinfo.getMonth())== null){
					monthdatamap.put(currentmonthinfo.getMonth(), new ArrayList<MonthInfo>() );
				}

				if (currentmonthinfo.getMonth() ==1 ){
					listjan.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listjan);
				}
				else if (currentmonthinfo.getMonth() ==2 ){
					listfeb.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listfeb);
				}
				else if (currentmonthinfo.getMonth() ==3 ){
					listmar.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listmar);
				}
				else if (currentmonthinfo.getMonth() ==4 ){
					listapr.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listapr);
				}
				else if (currentmonthinfo.getMonth() ==5 ){
					listmay.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listmay);
				}
				else if (currentmonthinfo.getMonth() ==6 ){
					listjun.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listjun);
				}

				else if (currentmonthinfo.getMonth() ==7 ){
					listjul.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listjul);
				}

				else if (currentmonthinfo.getMonth() ==8 ){
					listaug.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listaug);
				}

				else if (currentmonthinfo.getMonth() ==9 ){
					listsep.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listsep);
				}

				else if (currentmonthinfo.getMonth() ==10 ){
					listoct.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listoct);
				}

				else if (currentmonthinfo.getMonth() ==11 ){
					listnov.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listnov);
				}

				else {
					listdec.add(currentmonthinfo);
					monthdatamap.put(currentmonthinfo.getMonth(),listdec);
				}


			}

		}
		return monthdatamap;
	}

	public static void lowestextentyears(HashMap<Integer, ArrayList<MonthInfo>> map) throws Exception{
		for (int i =1; i<=12; i++){
			double minextent = Double.POSITIVE_INFINITY;
			MonthInfo minextentyear = new MonthInfo();
			ArrayList<MonthInfo> monthlist = map.get(i);
			double extentSum = 0;
			for (int j = 0; j<monthlist.size(); j++){
				
				try{
					double currentextent = monthlist.get(j).getExtent();
					if(currentextent < minextent){
						minextent = currentextent;
						minextentyear = monthlist.get(j);
					}
					extentSum += currentextent;
				
				
				if (i !=1){
					int previousMonth = i-1;
					double previousExtent = map.get(i-1).get(j).getExtent();
					double extentdifference = currentextent - previousExtent;
					System.out.println("Difference in extent month "+i+" minus month "+ previousMonth + " of "+monthlist.get(j).getYear()+" equals "+extentdifference);
					
				}
				

			
			
			
			
			

				}
				catch (Exception e){}
			}
			System.out.println("\nMonth: "+i+"\nMin Extent year: "+minextentyear+"\n ");
			double averageExtent = extentSum/monthlist.size();
			System.out.println("Average Extent for month "+i+" = " +averageExtent +"\n \n \n");
		}
		}
	


	public static void main (String args[]) throws Exception{
		BufferedReader dataAsBR1 = brFromFile("D:" +  File.separator + "N_extent_v3.0.csv");
		BufferedReader dataAsBR2 = brFromFile("D:" +  File.separator + "N_extent_v3.0.csv");
		totandmins(dataAsBR1);
		HashMap<Integer, ArrayList<MonthInfo>> hm =  sortintomonths(dataAsBR2);
		lowestextentyears(hm);
	}
}
