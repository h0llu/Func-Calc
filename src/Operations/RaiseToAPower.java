package Operations;

import Exceptions.CountException;

public class RaiseToAPower extends BinaryOperation {
	public RaiseToAPower(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	protected int count(int left, int right) {
		return (int)Math.pow(left, right);
	}

	@Override
	protected double count(double left, double right) throws CountException {
		if (left < 0 && right != (int) right) {
			throw new CountException("Raising a negative number to a fractional power: " +
									 left + " ^ " + right);
		}
		return Math.pow(left, right);
	}
}