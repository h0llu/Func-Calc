package Operations;

import Exceptions.*;

public abstract class UnaryOperation implements Expression {
	private final Expression expression;

	public UnaryOperation(Expression expression) {
		this.expression = expression;
	}

	protected abstract int count (int expression) throws CountException, DivisionByZeroException, OverflowException;
	protected abstract double count (double expression) throws CountException, DivisionByZeroException, OverflowException;

	@Override
	public int evaluate(int x) throws CountException, DivisionByZeroException, OverflowException {
		return count(expression.evaluate(x));
	}

	@Override
	public double evaluate(double x) throws CountException, DivisionByZeroException, OverflowException {
		return count(expression.evaluate(x));
	}
}