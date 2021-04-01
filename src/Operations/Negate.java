package Operations;

import Exceptions.OverflowException;

public class Negate extends UnaryOperation {
	public Negate(Expression expression) {
		super(expression);
	}

	@Override
	protected int count(int expression) throws OverflowException {
		if (expression == Integer.MIN_VALUE) {
			throw new OverflowException("Negating MIN_VALUE");
		}
		return -expression;
	}

	@Override
	protected double count(double expression) {
		return -expression;
	}
}
