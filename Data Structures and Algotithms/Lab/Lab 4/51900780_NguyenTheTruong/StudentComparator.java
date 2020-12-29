import java.util.Comparator;

public class StudentComparator implements Comparator {
	
	@Override 
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		
		double ratio = s1.getAverage() - s2.getAverage();
		if(ratio > 0) {
			return 1;
		}
		else if (ratio < 0) {
			return -1;
		}
		return 0;
	}
}