package Exceptions;

public class ParsingException extends Exception {
	public ParsingException(String message) {
		super("Parsing error: " + message);
	}
}