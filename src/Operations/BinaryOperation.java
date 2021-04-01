package Operations;

import Exceptions.*;

public abstract class BinaryOperation implements Expression {
	private final Expression left;
	private final Expression right;

	public BinaryOperation(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	protected abstract int count (int left, int right) throws CountException, DivisionByZeroException, OverflowException;
	protected abstract double count (double left, double right) throws CountException, DivisionByZeroException, OverflowException;

	@Override
	public final int evaluate(int x) throws CountException, DivisionByZeroException, OverflowException {
		return count(left.evaluate(x), right.evaluate(x));
	}

	@Override
	public final double evaluate(double x) throws CountException, DivisionByZeroException, OverflowException {
		return count(left.evaluate(x), right.evaluate(x));
	}

}