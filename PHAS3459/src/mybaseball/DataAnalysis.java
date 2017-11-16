package mybaseball;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.omg.CORBA.SystemException;
public class DataAnalysis {

	
	//url to buffered reader
	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}

	static String line;
	
	
	//count number of players
	public static int totalplayers (BufferedReader br) throws Exception {

		int i = 0;
		while ((line = br.readLine()) != null){
			if (line.isEmpty() || line.contains("Player")){	}
			else{
				i++;
			}
		}
		return i;
	}
	
	//find who has most homeruns
	public static playersinfo mostHR (String urlName) throws Exception{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		int maxhr = 0;
		playersinfo maxhrplayer = new playersinfo();
		while ((line = br.readLine()) != null){
			if (line.isEmpty() || line.contains("Player")){
			}
			else{
				playersinfo currentplayer = new playersinfo(line);
				if (currentplayer.getHr() > maxhr){
					maxhrplayer = currentplayer;
					maxhr = currentplayer.getHr();
				}
			}
		}
		return maxhrplayer;
	}
	
	
	//make arraylist of players and their info 
	public static ArrayList<playersinfo> sortedplayers(BufferedReader br) throws Exception{
		ArrayList <playersinfo> list = new ArrayList<playersinfo>();
		String line;
		while ((line = br.readLine()) != null){
			if (line.isEmpty() || line.contains("Player")){}
			else{
				playersinfo currentplayer = new playersinfo(line);
				list.add(currentplayer);
			}
		}
		return list;
	}


	//sort into hasmap of teams. Keys are the teams. Values are arrays of the playerinfo of the players in those teams
	public static HashMap<String, ArrayList<playersinfo>> sortteams(BufferedReader br) throws IOException, Exception{
		HashMap<String, ArrayList<playersinfo>> sortedBatters = new HashMap<String, ArrayList<playersinfo>>();
		ArrayList <playersinfo> list = sortedplayers(brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt"));
		for (playersinfo currentplayer : list){
			String currentTeam = currentplayer.getTeam();
			ArrayList<playersinfo> currentplayersinfo = sortedBatters.get(currentTeam);

			if (currentplayersinfo == null){
				sortedBatters.put(currentTeam, new ArrayList<playersinfo>());
			}

			sortedBatters.get(currentTeam).add(currentplayer);

		}
		return sortedBatters;
	}

	
	//this is where the real shit happens
	//data analysis to do the rest
	//input the hashmap of the sorted teams - although i don't actually use this
	public static void dataAnalysis(HashMap<String, ArrayList<playersinfo>> map) throws IOException, Exception{
		//i do this again because it's 4am and cba to change it
		BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
		map = sortteams(br);
		//hashmap. Key: teams. Values: number of people in that team with 10+ at bats
		HashMap <String, Integer> teamtenab = new HashMap <String, Integer>();
		//hashmap. Key: teams. Values: info of player in that team with highest SLG
		HashMap<String, playersinfo> teamslg = new HashMap<String, playersinfo>();
		//hashmap. Key: teams. Values: info of player in that team with highest OPS
		HashMap<String, playersinfo> teamops = new HashMap<String, playersinfo> ();
		String line;
		int i;
		
		//loop through text
		while ((line = br.readLine()) != null){
			//skip title lines obv
			if (line.isEmpty() || line.contains("Player")){}
			else{
				//read current line, making it currentplayer info
				playersinfo currentplayer = new playersinfo (line);
				//currentteam is the team on the line it's reading 
				String currentteam = currentplayer.getTeam();
				
				//this is if the team hasn't been in the loop yet
				if (teamtenab.get(currentteam)== null){
					//put the team in the hashmaps, just put anything in that isn't null for them to be updated later
					teamtenab.put(currentteam, 0);
					teamslg.put(currentteam, currentplayer);
					teamops.put(currentteam, currentplayer);
				}

				//considering playes with at bad of 10+
				if (currentplayer.getAb() >= 10){
					// add one to the current number of players in the team with 10+ atbat
					//breaking it down:
					
					
					//teamtenab. - the hashmap of teams and 10+ atbat players
					//.get(currentteam) - get's the value for this team - ie the number of players with 10+ atbat
					// +1 to this
					int incriment = teamtenab.get(currentteam) +1;
					
					//put this new value (ie old value +1) into the hashmap
					teamtenab.put(currentteam, incriment);
					
					//if this player's SLG is higher than his team's highest SLG, put him in the hashmap for <team, highest SLG player>
					if (currentplayer.getSlg() > teamslg.get(currentteam).getSlg()){
						teamslg.put(currentteam,currentplayer);
					}
					
					//if this player's OPS is higher than his team's highest SLG, put him in the hashmap for <team, highest OPS player>
					if (currentplayer.getOps() > teamslg.get(currentteam).getOps()){
						teamops.put(currentteam,currentplayer);
					}

				}
			}
		}
		
		//now we print all this shit out
		Object[] a = teamtenab.keySet().toArray();
		Object[] b = teamtenab.values().toArray();
		Object[] c = teamslg.values().toArray();
		Object[] d = teamops.values().toArray();
		for (int j = 0;  j < teamtenab.keySet().size(); j++){
			System.out.println("\n\nTeam: " + a[j] + "\nPlayers with at least 10 At-Bats: "+b[j] + "\n \n \nPlayer with max SLG:\n \n"+ c[j]+"\n \n \nPlayer with max OPS:\n \n"+d[j]+"\n \n \n \n");
		}
	}

	public static void main (String args[]) throws Exception{
		BufferedReader dataAsBR = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
		int total = totalplayers(dataAsBR);
		playersinfo maxhrp = mostHR("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
		System.out.println("Total number of players: " +total);
		System.out.println();
		System.out.println("Player with the most homeruns:\n" + maxhrp.toString());
		System.out.println();
		HashMap<String, ArrayList<playersinfo>> teamhm = sortteams(dataAsBR);
		dataAnalysis(teamhm);

	}

}
