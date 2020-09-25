/**
 * PostfixError extends Exception
 *
 * @author Sidd O.
 */
public class PostfixError extends Exception {
	public PostfixError(String e) {
		super("Invalid Expression! : " + e);
	}
}
