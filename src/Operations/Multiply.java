package Operations;

import Exceptions.OverflowException;

public class Multiply extends BinaryOperation {
	public Multiply(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	protected int count(int left, int right) throws OverflowException {
		if ((left == -1 && right == Integer.MIN_VALUE) ||
				(right == -1 && left == Integer.MIN_VALUE) ||
				(left > 1 && (right > Integer.MAX_VALUE / left || right < Integer.MIN_VALUE / left)) ||
				(left < -1 && (right < Integer.MAX_VALUE / left || right > Integer.MIN_VALUE / left)) ||
				(right > 1 && (left > Integer.MAX_VALUE / right || left < Integer.MIN_VALUE / right)) ||
				(right < -1 && (left < Integer.MAX_VALUE / right || left > Integer.MIN_VALUE / right))) {
			throw new OverflowException(left + " * " + right);
		}
		return left * right;
	}

	@Override
	protected double count(double left, double right) throws OverflowException {
		if ((left == -1 && right == Double.MIN_VALUE) ||
				(right == -1 && left == Double.MIN_VALUE) ||
				(left > 1 && (right > Double.MAX_VALUE / left || right < -Double.MAX_VALUE / left)) ||
				(left < -1 && (right < Double.MAX_VALUE / left || right > -Double.MAX_VALUE / left)) ||
				(right > 1 && (left > Double.MAX_VALUE / right || left < -Double.MAX_VALUE / right)) ||
				(right < -1 && (left < Double.MAX_VALUE / right || left > -Double.MAX_VALUE / right))) {
			throw new OverflowException(left + " * " + right);
		}
		return left * right;
	}
}