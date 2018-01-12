package finalexam1112;

import java.util.Scanner;

public class Population {

	
	String id;
	int population;

	public Population(){}
	public Population(String line){
		Scanner sc = new Scanner(line);

		this.id = sc.next();
		this.population=sc.nextInt();

		sc.close();
	}
	
	//getters
	public String getID(){
		return this.id;
	}
	public int getPopulation(){
		return this.population;
	}
}
