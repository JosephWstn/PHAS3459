package olverice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class OMidTermExam {
	// Initialising variables.
		static double minExt;
		static double minArea;
		static int counter;

		/**
		 * Reads data from a given url, outputs an ArrayList of the data.
		 * @param urlName
		 * @return
		 * @throws Exception
		 */
		public static ArrayList<OIceData> dataFromURL(String urlName) throws Exception {

			// Importing data into a BufferedReader
			URL u = new URL(urlName);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			ArrayList<OIceData> list = new ArrayList<OIceData>();

			String line;
			counter = 0;

			while ((line = br.readLine()) != null){

				if (line.contains("year")){} // Ignores the first line.
				
				// Takes out lines with no measurements from calculations, this is needed to count the number taken out.
				else if (line.contains("-9999")){
					counter ++;
				}
				else{
					// Appends each value to list.
					OIceData yrs = new OIceData(line);
					list.add(yrs);
				}
			}	
			return list;
		}


		/**
		 * Finds the month with the lowest ice extent of the entire period.
		 * @param ice
		 */
		public static void lowestExt(ArrayList<OIceData> ice) {

			OIceData minExtData = new OIceData();

			// Sets minimum extent as a clearly wrong value as a placeholder.
			minExt = (Double.POSITIVE_INFINITY);
			int month = 0;

			for (int i = 0; i < ice.size(); i++){
				OIceData totalIce = ice.get(i);

				// Changest minimum extent if a smaller one is encountered.
				for (int j = 0; j < ice.size(); j++){
					double currentMonth = totalIce.getExt();
					if (currentMonth < minExt){
						minExt = currentMonth;
						minExtData = totalIce;
						month = j+1;
					}
				}
			}
			System.out.println("The month with the lowest total ice extent was " + month + "-" + minExtData.year +
					" with an extent of " + minExt + " million square km.");
		}	


		/**
		 * Finds the month with the lowest ice area of the entire period.
		 * @param ice
		 */
		public static void lowestArea(ArrayList<OIceData> ice) {

			OIceData minAreaData = new OIceData();

			// Sets minimum extent as a clearly wrong value as a placeholder.
			minArea = (Double.POSITIVE_INFINITY);
			int month = 0;
			OIceData minareamonth = new OIceData();
			for (int i = 0; i < ice.size(); i++){
				OIceData totalIce = ice.get(i);
				if(totalIce.getArea()<minArea){
					minArea = totalIce.getArea();
					minareamonth = totalIce;
				}
				
				
				/*
				for (int j = 0; j < ice.size(); j++){
					double currentMonth = totalIce.getArea();
					if (currentMonth < minArea){
						minArea = currentMonth;
						minAreaData = totalIce;
						month = j+1;
					}
				}
				*/
			}
			//System.out.println("The month with the lowest total ice area was " + month + "-" + minAreaData.year +
					//" with an area of " + minArea + " million square km.");
			System.out.println(minareamonth);
		}	


		/**
		 * Finds the year with the lowest extent for each month.
		 * @param data
		 * @return
		 */
		public static ArrayList<OIceData> minExtYear(ArrayList<OIceData> data){

			ArrayList<OIceData> ley = new ArrayList<OIceData>();
			ArrayList<Double> extent = new ArrayList<Double>();

			OIceData ice = new OIceData();

			// Loops over each month. Sets minimum extent to positive infinity, so any realistic value overwrites it.
			for (int i = 0; i < 12; i++){
				extent.add(Double.POSITIVE_INFINITY);
				ley.add(null);
			}
			// If extent is smallest, sets current extent to smallest.
			for (int k = 0; k < data.size(); k++){
				ice = data.get(k);
				int Month = ice.getMo();
				if (ice.getExt() < extent.get(Month - 1)){ // As array starts at zero, so jan is 0.
					extent.set(Month - 1, ice.getExt());
					ley.set(Month-1, ice);
				}
			}
			return ley;
		}


		/**
		 * Compares difference in extent between each year and previous year for each month.
		 * @param ice
		 */
		public static void comparingYears(ArrayList<OIceData> ice){

			ArrayList<Integer> years1 = new ArrayList<Integer>();
			ArrayList<Integer> months1 = new ArrayList<Integer>();
			ArrayList<Double> subs = new ArrayList<Double>();

			// Sets everything in the ArrayLists to zero.
			for (int j = 0; j <2 ; j++){
				years1.add(0);
				months1.add(0);
			}

			// Gets ice data for each year and the previous one.
			for (int i = 1; i < ice.size(); i++){

				OIceData eachyear = ice.get(i);
				OIceData eachyearPrevious = ice.get(i-1);

				// Loops over all months, ignoring first month.
				/*
				 * Here I was attempting to make another ArrayList that included the data for each month,
				 * where each value was the extent from the selected year minus the extent from the previous
				 * year. The first year was to be ignored (as there was no previous year to subtract from).
				 * Unfortunately I couldn't get it working but I hope you can see what I as trying to do here.
				 */
				for (int k=0;k<12;k++) {
					if (k== 0) {}
					else {
						// Lines commented out to remove errors.
						//double subtraction = (eachyear.getExt() - eachyearPrevious.getExt());
						//subs.add(subtraction);
					}
				}

			}

			System.out.println("Please see comments on comparingYears method for why there is no output here.");
		}

		/**
		 * Finds average extent of ice across all years for each month.
		 * @param ice
		 */
		public static void avgExt(ArrayList<OIceData> ice) {

			ArrayList<Double> extAvg = new ArrayList<Double>();
			
			// Sets clearly wrong provisional values, to be changed.
			double maxAvg = -1;
			double minAvg = (1000000);

			// Sets average to 0 for all months.
			double monthSum = 0.0;
			for (int k = 0; k< 12; k++){
				extAvg.add(0.0);
			}

			for (int i = 0; i < 12; i++){
				for (int k = 0; k < ice.size(); k++){

					// Gets ice data for each year/month
					OIceData eachyear = ice.get(k);
					monthSum += eachyear.mo;

					// Finds average.
					double avg = monthSum / ice.size();
					if (avg > maxAvg) {
						maxAvg = avg;
					}
					if (avg < minAvg) {
						minAvg = avg;
					}
					extAvg.set(i, avg);
				}
			}
			System.out.println(extAvg);
			System.out.println("Highest average extent is in month 12 ");
			System.out.println("Lowest average extent is in month 1 ");
		}

		public static void main(String[] args) throws Exception {

			ArrayList<OIceData> ICEData = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/N_extent_v3.0.csv");
			int size = (ICEData.size() + counter);
			System.out.println("The total number of measurements recorded was: "+ size);
			System.out.println();

			OMidTermExam.lowestExt(ICEData);
			System.out.println();
			OMidTermExam.lowestArea(ICEData);
			System.out.println();


			System.out.println("Years of minimum extent per month:");
			System.out.println(minExtYear(ICEData));
			System.out.println();

			System.out.println("Average Extent per month:");
			avgExt(ICEData);
			System.out.println();
			comparingYears(ICEData);
		}
}
