package Operations;

import Exceptions.CountException;

public class Variable implements Expression {
	private final String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public int evaluate(int x) throws CountException {
		if (name.equals("x")) {
			return x;
		}
		throw new CountException("variable '" + name + "' doesn't exist");
	}

	@Override
	public double evaluate(double x) throws CountException {
		if (name.equals("x")) {
			return x;
		}
		throw new CountException("variable '" + name + "' doesn't exist");
	}
}
