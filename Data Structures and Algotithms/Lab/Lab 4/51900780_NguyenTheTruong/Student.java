public class Student {
	private String name;
	private double math;
	private double prog;
	private double DSA1;
	
	public Student(String name, double math, double prog, double DSA1) {
		this.name = name;
		this.math = math;
		this.prog = prog;
		this.DSA1 = DSA1;
	}
	
	public double getMath() {
		return this.math;
	}
	
	public double getProg() {
		return this.prog;
	}
	
	public double getDSA1() {
		return this.DSA1;
	}
	
	public double getAverage() {
		return (this.math + this.prog + this.DSA1) / 3;
	}
	
	public String toString() {
		return "Name: " + this.name + "\nMathematics: " + this.math + "\nProgramming: " + this.prog + "\nDSA1: " + this.DSA1 + "\nGrade average: " + getAverage();
	}
}