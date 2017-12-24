package finalexam1617;

import java.util.ArrayList;
import java.util.Collections;

public class LowOrMediumOrHigh implements SoundClassification{

	ArrayList<Integer> ampList, titleInfo;

	//constrcutor for low, medium or high test
	public LowOrMediumOrHigh (ArrayList<Integer> ampList, ArrayList<Integer> titleInfo){
		this.ampList = ampList;
		this.titleInfo = titleInfo;
	}


	private double spectralDensity(ArrayList<Integer> ampList, double t, double f) {
		int bigN = ampList.size();
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
			sumCos += ampList.get(n)* Math.cos(z*n);
			sumSin += ampList.get(n)* Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
	}


	@Override
	public String classification(ArrayList<Integer> ampList, ArrayList<Integer> titleInfo) {
		//i'm not sure what t is, i'm going to say that it is duration
		double t = ExamPart11617.duration(titleInfo);
		double sD100 = spectralDensity(ampList, t, 100);
		double sD400 = spectralDensity(ampList, t, 400);
		double sD1000 = spectralDensity(ampList, t, 1000);
		ArrayList<Double> sDList = new ArrayList<Double>();
		sDList.add(sD100);
		sDList.add(sD400);
		sDList.add(sD1000);
		System.out.println(sDList);
		if (Collections.max(sDList) == sD100){
			return ("low");
		}
		else if (Collections.max(sDList) == sD400){
			return ("medium");
		}
		else{
			return ("high");
		}
	}
}