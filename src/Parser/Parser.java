package Parser;

import Exceptions.ParsingException;
import Operations.Expression;

public interface Parser {
	Expression parse(String expression) throws ParsingException;
}