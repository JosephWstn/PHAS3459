package mybaseball;
import java.util.Scanner;
public class playersinfo {
	
	String name, team, pos;
	int games, ab, runs, hits, twob, threeb, hr;
	double rbi, avg, obp;
	
	public playersinfo(){};
	public playersinfo(String line){
		Scanner sc = new Scanner(line).useDelimiter("\t");
		this.name = sc.next();
		this.team = sc.next();
		this.pos = sc.next();
		this.games = sc.nextInt();
		this.ab = sc.nextInt();
		this.runs = sc.nextInt();
		this.hits = sc.nextInt();
		this.twob = sc.nextInt();
		this.threeb = sc.nextInt();
		this.hr= sc.nextInt();
		this.rbi = sc.nextDouble();
		this.avg = sc.nextDouble();
		this.obp = sc.nextDouble();
		sc.close();
	}
	
	public String toString(){
		//return ("name: "+this.name+"\nteam: "+this.team+"\nposition: "+this.pos+"\ngames: "+this.games+"\nab: "+this.ab);
		return ("name: "+this.name+"\nteam: "+this.team+"\nposition: "+this.pos+"\ngames: "+this.games+"\nab: "+this.ab+"\nruns: "+this.runs+"\nhits: "+this.hits+"\n2b: "+this.twob+"\n3b: "+this.threeb+"\nhr: "+this.hr+"\nrbi: "+this.rbi+"\navg: "+this.avg+"\nobp: "+this.obp);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getTeam(){
		return this.team;
	}
	
	public String getPos(){
		return this.pos;
	}
	
	public int getGames(){
		return this.games;
	}
	
	public int getAb(){
		return this.ab;
	}
	
	public int getRuns(){
		return this.runs;
	}
	
	public int getHits(){
		return this.hits;
	}
	
	public int getTwob(){
		return this.twob;
	}
	
	public int getThreeb(){
		return this.threeb;
	}
	
	public int getHr(){
		return this.hr;
	}
	
	public double getRbi(){
		return this.rbi;
	}
	
	public double getAvg(){
		return this.avg;
	}
	
	public double getObp(){
		return this.obp;
	}
	
	public double getSlg()throws Exception{
		try{
		return ((this.hits + (2*this.twob)+(3*this.threeb)+(4*this.hr))/this.ab);
		}
		catch (Exception e){
			return 0;
		}
	}
	
	public double getOps() throws Exception{
		return getSlg()+this.obp;
	}
}
