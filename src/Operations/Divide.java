package Operations;

import Exceptions.DivisionByZeroException;
import Exceptions.OverflowException;

public class Divide extends BinaryOperation {
	public Divide(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	protected int count(int left, int right) throws DivisionByZeroException, OverflowException {
		if (right == -1 && left == Integer.MIN_VALUE) {
			throw new OverflowException(left + " / " + right);
		}
		if (right == 0) {
			throw new DivisionByZeroException(left + " / " + right);
		}
		return left / right;
	}

	@Override
	protected double count(double left, double right) throws DivisionByZeroException, OverflowException {
		if ((right > 0 && right < 1 && (left > Double.MAX_VALUE * right || left < -Double.MAX_VALUE * right)) ||
				(right > -1 && right < 0 && (left < Double.MAX_VALUE * right || left > -Double.MAX_VALUE * right))) {
			throw new OverflowException(left + " / " + right);
		}
		if (right == 0) {
			throw new DivisionByZeroException(left + " / " + right);
		}
		return left / right;
	}
}