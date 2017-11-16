package paularain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class PRainAnalysis {

	
	public static double max3rain;
	public static double max3rain1;
	public static double max3rain2;
	public static double maxRain;
	public static int totalY;
	public static int counter;

	// reads data from URL & returns it as ArrayList
	public static ArrayList<PRainData> dataFromURL(String urlName) throws Exception{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<PRainData> list = new ArrayList<PRainData>();
		String line;
		// scans each line of buffered reader
		while ((line = br.readLine()) != null){
			if (line.contains("a") || line.contains("A")){}
			else{
				// appends EQPoints object to ArrayList
				PRainData points = new PRainData(line);
				list.add(points);
			}
		}	
		return list;
	}

	public static void WettestMonth(ArrayList<PRainData> rain){
		PRainData maxRainData = new PRainData();
		maxRain = 0.0;
		int month = 0;
		for (int i = 0; i < rain.size(); i++){
			PRainData eachyear = rain.get(i);
			for (int k = 0; k < 12; k++){
				double currentMonth = eachyear.months.get(k);
				if (currentMonth > maxRain){
					maxRain = currentMonth;
					maxRainData = eachyear;
					month = k+1;
				}
			}
		}
		System.out.println("The wettest month was the " + month + "th month of " + maxRainData.year + " with rainfall of " + maxRainData.months.get(month-1) + "mm");
	}

	public static void WettestDriestPerMonth(ArrayList<PRainData> rain){
		ArrayList<Double> rainfallMax = new ArrayList<Double>();
		ArrayList<Double> rainfallMin = new ArrayList<Double>();
		ArrayList<Integer> yearfallMax = new ArrayList<Integer>();
		ArrayList<Integer> yearfallMin = new ArrayList<Integer>();
		double months = 0.0;
		for (int k = 0; k< 12; k++){
			rainfallMax.add(0.0);
			rainfallMin.add(100000.0);
			yearfallMax.add(0);
			yearfallMin.add(0);
		}
		for (int i = 0; i < 12; i++){
			for (int k = 0; k < rain.size(); k++){
				PRainData eachyear = rain.get(k);
				months = eachyear.months.get(i);
				if (months > rainfallMax.get(i)){
					yearfallMax.set(i, rain.get(k).year);
					rainfallMax.set(i, months);
				}
				if (months < rainfallMin.get(i)){
					yearfallMin.set(i, rain.get(k).year);
					rainfallMin.set(i, months);
				}
			}
		}
		System.out.println(rainfallMax + "and" + yearfallMax + "and" +rainfallMin + "and" + yearfallMin);
	}

	public static void Wettest3Months(ArrayList<PRainData> rain){
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<Integer> months3 = new ArrayList<Integer>();
		ArrayList<Integer> years1 = new ArrayList<Integer>();
		ArrayList<Integer> months31 = new ArrayList<Integer>();
		ArrayList<Integer> years2 = new ArrayList<Integer>();
		ArrayList<Integer> months32 = new ArrayList<Integer>();
		for (int j = 0; j < 3; j++){
			years.add(0);
			months3.add(0);
			years1.add(0);
			months31.add(0);
			years2.add(0);
			months32.add(0);
		}
		max3rain = 0.0;
		max3rain1 = 0.0;
		max3rain2 = 0.0;
		for (int i = 0; i < rain.size()-1; i++){
			PRainData eachyear = rain.get(i);
			PRainData eachyearNext = rain.get(i+1);
			for (int k = 0; k < 12; k++){
				if (k <=9){
					double current3Months = eachyear.months.get(k) + eachyear.months.get(k+1) + eachyear.months.get(k+2);
					if (current3Months > max3rain){
						max3rain = current3Months;
						months3.set(0, k+1);
						months3.set(1, k+2);
						months3.set(2, k+3);
						years.set(0, rain.get(i).year);
						years.set(1, rain.get(i).year);
						years.set(2, rain.get(i).year);
					}
				}
				if (k == 10){
					double current3Months1 = eachyear.months.get(k) + eachyear.months.get(k+1) + eachyearNext.months.get(k-10);
					if (current3Months1 > max3rain1){
						max3rain1 = current3Months1;
						months31.set(0, 11);
						months31.set(1, 12);
						months31.set(2, 1);
						years1.set(0, rain.get(i).year);
						years1.set(1, rain.get(i).year);
						years1.set(2, rain.get(i+1).year);
					}
				}
				if (k == 11){
					double current3Months2 = eachyear.months.get(k) + eachyearNext.months.get(k-11) + eachyearNext.months.get(k-10);
					if (current3Months2 > max3rain2){
						max3rain2 = current3Months2;
						months32.set(0, 12);
						months32.set(1, 1);
						months32.set(2, 2);
						years2.set(0, rain.get(i).year);
						years2.set(1, rain.get(i+1).year);
						years2.set(2, rain.get(i+1).year);
					}
				}
			}
		}
		if (max3rain > max3rain1 && max3rain > max3rain2){
			System.out.println("Wettest 3 months: "+ max3rain + "and"+ years +"and"+ months3);
		}
		if (max3rain1 > max3rain && max3rain1 > max3rain2){
			System.out.println("Wettest 3 months: "+ max3rain1 + "and"+ years1 +"and"+ months31);
		}
		if (max3rain2 > max3rain && max3rain2 > max3rain1){
			System.out.println("Wettest 3 months: "+max3rain2 + "and"+ years2 +"and"+ months32);
		}
	}

	public static void AverageRMSMonthly(ArrayList<PRainData> rain){
		ArrayList<Double> rainfallAvg = new ArrayList<Double>();
		ArrayList<Double> rainfallRMS = new ArrayList<Double>();
		double months = 0.0;
		for (int k = 0; k< 12; k++){
			rainfallAvg.add(0.0);
			rainfallRMS.add(0.0);
		}
		for (int i = 0; i < 12; i++){
			for (int k = 0; k < rain.size(); k++){
				PRainData eachyear = rain.get(k);
				months += eachyear.months.get(i);
				double avg = months/rain.size();
				double rms = Math.sqrt((months*months)/(rain.size()));
				rainfallAvg.set(i, avg);
				rainfallRMS.set(i, rms);
			}
		}
		System.out.println("average: " + rainfallAvg + "RMS: " + rainfallRMS);
	}

	public static void Compare2012(ArrayList<PRainData> rain){
		ArrayList<Double> percentage = new ArrayList<Double>();
		ArrayList<Double> count = new ArrayList<Double>();
		int size = rain.size();
		PRainData year2012 = rain.get(size-1);
		double perc = 0.0;
		counter = 0;
		double months = 0.0;
		double months2012 = 0.0;
		for (int i = 0; i < 12; i++){
			percentage.add(0.0);
			count.add(0.0);
		}
		for (int c = 0; c<12; c++){
			months2012 = year2012.months.get(c);
			for (int k = 0; k < rain.size(); k++){
				PRainData eachyear = rain.get(k);
				for (int j = 0; j < 12; j++){
					months = eachyear.months.get(j);
					if (months2012 == 0.0){}
					else{
						if (c==j){
							if (months > months2012){
								count.set(c, count.get(c)+1);
							}
						}
					}
				}
			}
		}
		for (int c = 0; c<12; c++){
			perc = (count.get(c)/(size-1))*100;
			percentage.set(c, perc);
		}

		System.out.println(percentage);
	}

	public static void main (String args[]) throws Exception{

		ArrayList<PRainData> RainRainGoAway = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2012-13/HadEWP_monthly_qc.txt");

		WettestMonth(RainRainGoAway);

		WettestDriestPerMonth(RainRainGoAway);

		Wettest3Months(RainRainGoAway);

		AverageRMSMonthly(RainRainGoAway);

		Compare2012(RainRainGoAway);

	}
}
