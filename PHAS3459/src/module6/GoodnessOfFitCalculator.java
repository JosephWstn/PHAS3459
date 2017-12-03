package module6;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Interface to carry out a goodness of fit calculation
 */
public interface GoodnessOfFitCalculator {

	double goodnessOfFit(Collection<DataPoint> c, Theory t);
} 