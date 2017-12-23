
package finalexam1617;

import java.util.Scanner;

public class RecordingInfo {

	int sFreq, num, maxAmp, amp;

	//constructor for the recording info document
	public RecordingInfo() {}
	public RecordingInfo(String line) {
		Scanner sc = new Scanner(line);
		//assume each line has the 3 bits of info
		this.sFreq = sc.nextInt();
		//if the line has more (ie is the first line), carry on
		if(sc.hasNext()) {
			this.num = sc.nextInt();
			this.maxAmp = sc.nextInt();
		}
		//if the line is only one long, then it is the amplitude, so set it to amplitude
		else{
			this.amp = this.sFreq;
		}
		sc.close();
	}

	public int getAmp() {
		return this.amp;
	}

	public int getsFreq() {
		return this.sFreq;
	}

	public int getNum() {
		return this.num;
	}

	public int getMaxAmp() {
		return this.maxAmp;
	}
}

//no toString is needed as it knows how to print integers