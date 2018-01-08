package finalexam1415;

import java.util.Scanner;

public class IDCode {

	//member variables
	String site, id;

	//how to read each line like always
	public IDCode(){}
	public IDCode(String line){
		Scanner sc = new Scanner(line);
		this.site=sc.next();
		this.id= sc.next();
		sc.close();
	}

	//getter methods
	public String getSite(){
		return this.site;
	}

	public String getID(){
		return this.id;
	}
}