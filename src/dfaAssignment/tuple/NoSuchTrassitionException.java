package dfaAssignment.tuple;

public class NoSuchTrassitionException extends Throwable {
    public NoSuchTrassitionException(State from, Alphabet alphabet) {
        super("No transsition on "+from.toString()+" for alphabet "+alphabet.toString());
    }
}
