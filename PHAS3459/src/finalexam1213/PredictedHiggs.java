package finalexam1213;

import java.util.ArrayList;
import java.util.HashMap;

public interface PredictedHiggs {
	
	HashMap<Double, Double> predicted (ArrayList<Background> measured, double binWidth, double min, double max);
}
