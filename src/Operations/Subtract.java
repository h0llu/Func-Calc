package Operations;

import Exceptions.OverflowException;

public class Subtract extends BinaryOperation {
	public Subtract(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	protected int count(int left, int right) throws OverflowException {
		if ((right > 0 && left < Integer.MIN_VALUE + right) || (right < 0 && left > Integer.MAX_VALUE + right)) {
			throw new OverflowException(left + " - " + right);
		}
		return left - right;
	}

	@Override
	protected double count(double left, double right) throws OverflowException {
		if ((right > 0 && left < -Double.MAX_VALUE + right) || (right < 0 && left > Double.MAX_VALUE + right)) {
			throw new OverflowException(left + " - " + right);
		}
		return left - right;
	}
}