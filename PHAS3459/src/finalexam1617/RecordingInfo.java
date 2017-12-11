
package finalexam1617;

import java.util.Scanner;

public class RecordingInfo {

	int sFreq, num, maxAmp, amp;

	public RecordingInfo() {}
	public RecordingInfo(String line) {
		Scanner sc = new Scanner(line);
		this.sFreq = sc.nextInt();
		if(sc.hasNext()) {
			this.num = sc.nextInt();
			this.maxAmp = sc.nextInt();
		}
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
