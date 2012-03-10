package ast;

public class Number extends Expr {
	public double value;
	
	public Number() {
		
	}
	
	public Number(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
