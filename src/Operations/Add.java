package Operations;

import Exceptions.OverflowException;

public class Add extends BinaryOperation {
	public Add(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	protected int count(int left, int right) throws OverflowException {
		if ((left > 0 && right > Integer.MAX_VALUE - left) || (left < 0 && right < Integer.MIN_VALUE - left)) {
			throw new OverflowException(left + " + " + right);
		}
		return left + right;
	}

	@Override
	protected double count(double left, double right) throws OverflowException {
		if ((left > 0 && right > Double.MAX_VALUE - left) || (left < 0 && right < -Double.MAX_VALUE - left)) {
			throw new OverflowException(left + " + " + right);
		}
		return left + right;
	}
}