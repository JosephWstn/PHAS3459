package finalexam1516;

import java.util.ArrayList;
import java.util.Scanner;

public class SignalData {
	ArrayList<Double> voltList;
	String id;
	
	public SignalData(){}
	public SignalData(String line){
		Scanner sc = new Scanner(line);
		this.id=sc.next();
		while (sc.hasNextDouble()){
			this.voltList.add(sc.nextDouble());
		}
		this.voltList.add(sc.nextDouble());
		sc.close();
	}
	
	public String getID(){
		return this.id;
	}
	
	public ArrayList<Double> getVoltList(){
		return this.voltList;
	}
}
