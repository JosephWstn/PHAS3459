package finalexam1415;

import java.util.Scanner;

public class Measurement {


	//member variables
	double level, pLevel;
	String id;
	int year, month, day, hour, minute;

	//how to read each line like always
	//level = sea level
	//pLevel = predicted sea level
	public Measurement(){}
	public Measurement(String line){
		Scanner sc = new Scanner(line);

		//this if statement is for the last part of part 3 where the order of each line gets changed
		if(sc.hasNextDouble()){
			this.year = sc.nextInt();
			this.month = sc.nextInt();
			this.day = sc.nextInt();
			this.hour = sc.nextInt();
			this.minute = sc.nextInt();
			this.id=sc.next();
			this.level = sc.nextDouble();
			this.pLevel = sc.nextDouble();
			sc.close();
		}

		else{
			this.id=sc.next();
			this.year = sc.nextInt();
			this.month = sc.nextInt();
			this.day = sc.nextInt();
			this.hour = sc.nextInt();
			this.minute = sc.nextInt();
			this.level = sc.nextDouble();
			this.pLevel = sc.nextDouble();
			sc.close();
		}
	}

	//getter methods
	public String getID(){
		return this.id;
	}

	public int getYear(){
		return this.year;
	}

	public int getMonth(){
		return this.month;
	}

	public int getDay(){
		return this.day;
	}

	public int getHour(){
		return this.hour;
	}

	public int getMinute(){
		return this.minute;
	}

	public double getLevel(){
		return this.level;
	}

	public double getPLevel(){
		return this.pLevel;
	}

	public String toString(){
		return ("Site ID: " + this.id +"\nYear: "+this.year +"\nMonth: "+ this.month +"\nDay: "+this.day+"\nHour: "+this.hour+"\nMinute: "+this.minute+"\nLevel Recorded: "+this.level+"\nLevel Predicted: "+this.pLevel);
	}
}