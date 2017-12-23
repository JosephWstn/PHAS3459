package finalexam1617;

import java.util.ArrayList;

public interface SoundClassification {

	//Algorithm will take into account 2 factors: the info in the title (sampling freq etc) and the individual amplitudes
	String classification (ArrayList<Integer> ampList, ArrayList<Integer> titleInfo);
}
