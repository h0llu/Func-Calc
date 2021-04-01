package Operations;

import Exceptions.*;

public interface Expression {
	int evaluate(int x) throws CountException, DivisionByZeroException, OverflowException;
	double evaluate (double x) throws CountException, DivisionByZeroException, OverflowException;
}