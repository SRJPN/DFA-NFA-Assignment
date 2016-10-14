package dfaAssignment.tuple;

public class NoSuchTransitionException extends Throwable {
    public NoSuchTransitionException(State from, Alphabet alphabet) {
        super("No transition on "+from.toString()+" for alphabet "+alphabet.toString());
    }
}
