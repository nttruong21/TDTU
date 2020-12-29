public class Fraction {
	private int num;
	private int den;
	
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int getDen() {
		return this.den;
	}
	
	public double getRatio() {
		return (double) this.num / this.den;
	}
	public String toString() {
		return this.num + "/" + this.den;
	}
}