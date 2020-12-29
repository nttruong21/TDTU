import java.util.Comparator;

public class FractionComparator implements Comparator {
	
	@Override 
	public int compare(Object o1, Object o2) {
		Fraction f1 = (Fraction) o1;
		Fraction f2 = (Fraction) o2;
		
		double ratio = f1.getRatio() - f2.getRatio();
		if(ratio > 0) {
			return 1;
		}
		else if(ratio < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}