package paularain;

import java.util.ArrayList;
import java.util.Scanner;

public class PRainData {
	
	public int year;
	public ArrayList<Double> months;
	public double ann;

	public PRainData() {}
	public PRainData(String line){
		Scanner sc = new Scanner(line);
		this.year = sc.nextInt();
		ArrayList<Double> MonthlyData = new ArrayList<Double>();
		int i = 0;
		while (i < 12){
			i++;
			double monthly = sc.nextDouble();
			MonthlyData.add(monthly);
		}
		this.months = MonthlyData;
		this.ann = sc.nextDouble();
		sc.close();
	}

	public String toString() {
		return "RainData [year=" + year + ", months=" + months + ", ann=" + ann + "]";
	}




}
