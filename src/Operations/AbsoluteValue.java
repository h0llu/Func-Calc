package Operations;

public class AbsoluteValue extends UnaryOperation {
	public AbsoluteValue(Expression expression) {
		super(expression);
	}

	@Override
	protected int count(int expression) {
		return expression > 0 ? expression : -1 * expression;
	}

	@Override
	protected double count(double expression) {
		return expression > 0 ? expression : -1 * expression;
	}
}