package finalexam1011;

import java.util.ArrayList;
import java.util.Scanner;

public class Reading {

	String id, type;
	int year, month;
	ArrayList<Integer> monthData;
	
	public Reading(){}
	public Reading(String line){
		int dayData;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(line);
		this.id = sc.next();
		this.year = sc.nextInt();
		this.month = sc.nextInt();
		this.type = sc.next();
		
		while(sc.hasNextInt() ){
			dayData = sc.nextInt();
			list.add(dayData);
		}
		this.monthData = list;
		sc.close();
	}
	
	//getters
	public String getID(){
		return this.id;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getMonth(){
		return this.month;
	}
	
	public String getType(){
		return this.type;
	}
	
	public ArrayList<Integer> getMonthData(){
		return this.monthData;
	}
	
	public String toString(){
		return ("ID: "+this.id +"\nYear: "+this.year + "\nMonth: "+this.month+"\nType: "+this.type+"\n \n");
	}
}
