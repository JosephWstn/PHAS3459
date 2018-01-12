package finalexam1112;

import java.util.Scanner;

public class OccurrencesAB {

	String id;
	int occA, occB;

	public OccurrencesAB(){}
	public OccurrencesAB(String line){
		Scanner sc = new Scanner(line);

		this.id = sc.next();
		this.occA=sc.nextInt();
		this.occB=sc.nextInt();
		sc.close();
	}
	
	//getters
	public String getID(){
		return this.id;
	}
	
	public int getOccA(){
		return this.occA;
	}
	
	public int getOccB(){
		return this.occB;
	}
}

