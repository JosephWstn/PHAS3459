package group1;

import java.util.Scanner;

public class MonthInfo {

	int year, month;
	String type, region;
	double extent, area;
	private Double double1;

	//constructors - how scanner reads each line
	public MonthInfo(){}
	public MonthInfo (String line){
		Scanner sc = new Scanner(line).useDelimiter(",\\s*");
		this.year = sc.nextInt();
		this.month = sc.nextInt();
		this.type = sc.next();
		this.region = sc.next();
		this.extent = sc.nextDouble();
		this.area = sc.nextDouble();
		sc.close();
	}

	
	//getter methods to get info
	public int getYear() throws Exception{
		if (this.year == -9999){
			throw new Exception();
		}
		else{
			return this.year; 
		}		
	}

	public int getMonth() throws Exception{
		if (this.month == -9999){
			throw new Exception();
		}
		else{
			return this.month; 
		}
	}

	public String getType() throws Exception{
		if (this.type == "-9999"){
			throw new Exception();
		}
		else{
			return this.type; 
		}
	}

	public String getRegion()throws Exception{
		if (this.region == "-9999"){
			throw new Exception();
		}
		else{
			return this.region; 
		}
	}

	public double getExtent()throws Exception{
		if (this.extent == -9999){
			throw new Exception();
		}
		else{
			return this.extent;
		}
	}

	public double getArea()throws Exception{
		if (this.area == -9999){
			throw new Exception();
		}
		else{
			return this.area; 
		}
	}
	
	

	
	public String toString(){
		return ("Year: " +this.year+"\nMonth: "+this.month+"\nData-Type: "+this.type+"\nRegion: "+this.region+"\nExtent: "+this.extent+"\nArea: "+this.area);
	}
}
