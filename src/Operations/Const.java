package Operations;

public class Const implements Expression {
	private final int intValue;
	private final double doubleValue;

	public Const(int intValue) {
		this.intValue = intValue;
		this.doubleValue = intValue;
	}

	public Const(double doubleValue) {
		this.intValue = (int)doubleValue;
		this.doubleValue = doubleValue;
	}

	@Override
	public int evaluate(int x) {
		return intValue;
	}

	@Override
	public double evaluate(double x) {
		return doubleValue;
	}
}
