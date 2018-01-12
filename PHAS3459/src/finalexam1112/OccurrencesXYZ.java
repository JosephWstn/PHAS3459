package finalexam1112;

import java.util.Scanner;

public class OccurrencesXYZ {

	
	String id;
	int occX, occY, occZ;

	public OccurrencesXYZ(){}
	public OccurrencesXYZ(String line){
		Scanner sc = new Scanner(line);

		this.id = sc.next();
		this.occX=sc.nextInt();
		this.occY=sc.nextInt();
		this.occZ=sc.nextInt();
		sc.close();
	}
	
	//getters
	public String getID(){
		return this.id;
	}
	
	public int getOccX(){
		return this.occX;
	}
	
	public int getOccY(){
		return this.occY;
	}
	
	public int getOccZ(){
		return this.occZ;
	}
	
	public String toString(){
		return ("ID: " + this.id + "\nX: " + this.occX +"\nY: "+this.occY + "\nZ: "+this.occZ+"\n\n");
	}
}
