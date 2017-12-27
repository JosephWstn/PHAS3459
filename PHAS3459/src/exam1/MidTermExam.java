package exam1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;




public class MidTermExam {

	//Read the data from the URL and put it into an ArrayList of MonthlyInfo objects
	public static ArrayList<MonthlyInfo> dataFromURL(String urlName) throws Exception{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<MonthlyInfo> list = new ArrayList<MonthlyInfo>();
		String line;
		//scans each line of buffered reader
		while ((line = br.readLine()) != null){
			if (line.contains("year")){}
			else{
				// appends object to ArrayList
				MonthlyInfo currentmonth = new MonthlyInfo(line);
				list.add(currentmonth);
			}
		}	
		return list;
	}

	//method takes the ArrayList of MonthlyInfo and finds the total number of measurements, and
	//months of lowers extent and area
	public static void totandmins(ArrayList<MonthlyInfo> arrayList) throws Exception {
		//print total number of measurements
		System.out.println("Total number of measurements (including months with no data where -9999 was printed): " + arrayList.size()+"\n");

		//initialise a MonthlyInfo to be updated as the current month being analysed
		MonthlyInfo currentMonth = new MonthlyInfo();

		//initialise a monthlyinfo for the info of minumum extent and area months
		MonthlyInfo minExtentMonth = new MonthlyInfo();
		MonthlyInfo minAreaMonth = new MonthlyInfo();

		//set initial placeholders for minimum extent and area to be overridden immediately 
		double minExtent = Double.POSITIVE_INFINITY;
		double minArea= Double.POSITIVE_INFINITY;

		//loop over arraylist of all MonthlyInfo

		for (int i = 0; i < arrayList.size(); i++){
			//update current month
			currentMonth = arrayList.get(i);
			try {
				//update minimumExtent info if necessary
				if (currentMonth.getExtent() < minExtent){
					minExtent = currentMonth.getExtent();
					minExtentMonth = currentMonth;
				}
				if (currentMonth.getArea() < minArea) {
					minArea = currentMonth.getArea();
					minAreaMonth = currentMonth;
				}
			}
			//catch exceptions for months with -9999 info
			catch(Exception e) {}
		}

		System.out.println("Information of month with lowest Extent:\n"+minExtentMonth);
		System.out.println();
		System.out.println("Information of month with lowest Area:\n"+minAreaMonth+"\n \n \n");
	}



	/*
	 * Method to find:
	 * year of lowest area for each month
	 * Differences from each year to the previous year for each month
	 * Find the 5 largest changes in area for each month 
	 * Find Average area across all years for each month, finding the max and min
	 * Argument is ArrayList of all of the data
	 * No return statement - all necessary outputs are printed in the method
	 */
	public static void dataAnalysis (ArrayList<MonthlyInfo> arrayList) throws Exception{

		//first, sort information into HashMap as the integer month as the keys, and an ArrayList of all the MonthlyInfo of that month as the values
		HashMap<Integer, ArrayList<MonthlyInfo>> monthInfoMap = new HashMap<Integer, ArrayList<MonthlyInfo>>();
		for (MonthlyInfo currentMonth : arrayList){

			int currentM = currentMonth.getMonth();
			ArrayList<MonthlyInfo> currentMonthInfo = monthInfoMap.get(currentM);
			if(currentMonthInfo == null){
				monthInfoMap.put(currentM, new ArrayList<MonthlyInfo>());
			}
			monthInfoMap.get(currentM).add(currentMonth); 


		}





		
		//HashMap of the area differences and the corresponding year - to find the top 5
		HashMap<Double, Integer> dropYearMap = new HashMap<Double,Integer>();
		
		//initialise other values
		double maxAverage = 0;
		double minAverage = Double.POSITIVE_INFINITY;
		int maxAverageMonth = 0;
		int minAverageMonth = 0;
		double maxAverageDifference = 0;
		double minAverageDifference = 0;
		
		System.out.println("Monthly data: \n \n \n");
		//loop through all months
		//values initialised in this loop are because they need to be reset for each month
		for (int i =1; i<=12; i++){



			//placeholder for lowest area, it is in the loop so it resets each month
			double minArea = Double.POSITIVE_INFINITY;

			//initialise sum of differences for average
			double sumOfDifferences = 0;

			//information of the month of a particular year with the lowest area
			MonthlyInfo minAreaYear = new MonthlyInfo();

			//get the arraylist of years for the current month i
			ArrayList<MonthlyInfo> monthList = monthInfoMap.get(i);

			double areaSum = 0;
			//loop over all the years for this month i 
			for (int j = 0; j<monthList.size(); j++){

				try{
					//update year of minimum area if necessary
					double currentArea = monthList.get(j).getArea();
					if(currentArea < minArea){
						minArea = currentArea;
						minAreaYear = monthList.get(j);
					}

					//sum for average
					areaSum += currentArea;

					//exclude first month for area change each year
					if (i !=1){
						int previousMonth = i-1;
						double previousArea = monthInfoMap.get(i-1).get(j).getArea();
						double areaDifference = currentArea - previousArea;
						System.out.println("Difference in area month "+i+" minus month "+ previousMonth + " of "+monthList.get(j).getYear()+" equals "+areaDifference+" million km^2");
						sumOfDifferences += areaDifference;
						dropYearMap.put(areaDifference, monthList.get(j).getYear());
					}

				}
				catch(Exception e) {}
			}
			
			try {
				//turn the keyset of the area differences into an array
				Double[] differenceArray = dropYearMap.keySet().toArray(new Double[5]);

				//sort the array of the area differences into descending order 
				Arrays.sort(differenceArray, Collections.reverseOrder());


				//find the years of the 5 largest drops as they are the values for these keys
				System.out.println("\nYears With Max 5 drops in area for month "+i+ " are:");
				for(int k = 0; k<5; k++) {
					System.out.println(k+1+": " + dropYearMap.get(differenceArray[k])+", with a drop of "+ differenceArray[k]+" million km^2");
				}
			}
			catch (Exception e) {}



			//print out info of specific month with lowest area
			System.out.println("\nFor Month "+i+":\nYear With Minimum Area:\n"+minAreaYear+"\n ");

			//finding the years that displayed the maximum and minimum average differences in ears
			double averageArea = areaSum/monthList.size();
			if (averageArea > maxAverage) {
				maxAverage = averageArea;
				maxAverageMonth = i;
				maxAverageDifference = sumOfDifferences/monthList.size();
			}

			if (averageArea < minAverage) {
				minAverage = averageArea;
				minAverageMonth = i;
				minAverageDifference = sumOfDifferences/monthList.size();
			}
 
			System.out.println("Average Area for month "+i+" across all years = " +averageArea +" million km^2\n \n \n");

			//clear hashmap of area differences and years so it is empty for next month loop 
			dropYearMap.clear();
		}

		
		//months with lowest area for linear extrapolation, although i did not have time to complete this calculation
		System.out.println("The month with the highest average area was month " + maxAverageMonth +" with an average area of "+maxAverage +" million km^2");
		System.out.println("The month with the lowest average area was month " + minAverageMonth +" with an average area of "+minAverage+" million km^2");



	}




	public static void main(String[] args) throws Exception{
		ArrayList<MonthlyInfo> dataAsArrayList = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/N_extent_v3.0.csv");
		totandmins(dataAsArrayList);
		dataAnalysis(dataAsArrayList);
	}

}
