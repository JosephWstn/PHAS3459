package finalexam1516;

import java.util.ArrayList;
import java.util.Scanner;

public class SignalData {
	ArrayList<Double> voltList;
	String id;
	
	public SignalData(){}
	
	public SignalData(String line){
		Scanner sc = new Scanner(line);
		ArrayList<Double> volts = new ArrayList<Double>();
		this.id=sc.next();
		while (sc.hasNextDouble()){
			volts.add(sc.nextDouble());
		}
		this.voltList = volts;
		sc.close();
	}
	
	public String getID(){
		return this.id;
	}
	
	public ArrayList<Double> getVoltList(){
		return this.voltList;
	}
	
	public String toString(){
		return ("ID: "+this.id + ".          Voltages: "+ this.voltList+"\n");
	}
}
