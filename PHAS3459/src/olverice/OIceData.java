package olverice;

import java.util.Scanner;

public class OIceData {
	// Initialising variables
		int year; 	// Year of measurement
		int mo;		// Month of measurment
		String dType;	// data source used to compile data
		String region;	// Hemisphere in question
		double extent;	//Total area of land/sea covered by ice in millions of square kilometers.
		double area;	// Total area of actual ice in millions of square kilometers.

		// Blank constructor
		public OIceData() {}

		/**
		 * Takes the data from each line using a scanner.
		 * @param line
		 */
		public OIceData(String line)	{

			Scanner sc = new Scanner(line);
			sc.useDelimiter(",\\s*");		

			this.year = sc.nextInt();
			this.mo = sc.nextInt();
			this.dType = sc.next();
			this.region = sc.next();
			this.extent = sc.nextDouble();
			this.area = sc.nextDouble();			

			sc.close();			
		}

		/**
		 * Returns the information for an earthquake including time, data, position and the magnitude.
		 */
		public String toString() {
			return ("Measurement on " + mo + "-" + year + " using " + dType + " as a data source."
					+ " the extent covered by ice is " + extent + " million square kilometers. The"
					+" total area of actual ice is " + area + "million square kilometers. \n");	
		}


		// Getter methods for use in analysis.
		int getYear() {
			return this.year;
		}
		
		int getMo() {
			return this.mo;
		}
		
		String getdType() {
			return dType;
		}
		
		String getRegion() {
			return this.region;
		}
		
		double getExt() {
			return this.extent;
		}

		double getArea() {
			return this.area;
		}
	}


