package muons;

import java.util.Scanner;

public class CurrentMuon {
	int decayTime;

	public CurrentMuon(){};
	public CurrentMuon(String line){
		Scanner sc = new Scanner(line);
		this.decayTime = sc.nextInt();
		sc.close();
	}
	
	public int muon (String line){
		Scanner sc = new Scanner(line);
		this.decayTime = sc.nextInt();
		sc.close();
		return this.decayTime;
	}
	
}
