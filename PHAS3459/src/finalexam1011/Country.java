package finalexam1011;

import java.util.ArrayList;
import java.util.Scanner;

public class Country {
	String id, country, namePart;

	public Country(){}
	public Country(String line){
		String fullName ="";
		Scanner sc = new Scanner(line);
		this.id = sc.next();

		while(sc.hasNext()){
			namePart = sc.next();
			fullName += namePart +" ";
		}
		this.country = fullName;
		sc.close();
	}

	//getters
	public String getID(){
		return this.id;
	}

	public String getCountry(){
		return this.country;
	}
}
