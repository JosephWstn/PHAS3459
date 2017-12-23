package finalexam1617;

import java.util.Scanner;

public class Index {

	public String fileName, type;

	public Index() {}

	//constructor for the object index 
	public Index(String line) {
		Scanner sc = new Scanner(line);
		this.fileName = sc.next();
		this.type = sc.next();
		sc.close();
	}

	//getters
	public String getfileName() {
		return this.fileName;
	}

	public String getType() {
		return this.type;
	}

	//toString
	public String toString(){
		return ("\nFile name: "+fileName+", Type: "+ type);
	}
}

