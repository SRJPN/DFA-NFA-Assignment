package dfaAssignment.tuple;

public class Transition {
    private final State from;
    private final Alphabet alphabet;
    private final State to;

    public Transition(State from, Alphabet alphabet, State to) {
        this.from = from;
        this.alphabet = alphabet;
        this.to = to;
    }

    public boolean hasTransition(State from, Alphabet alphabet) {
        return this.from.equals(from) && this.alphabet.equals(alphabet);
    }

    public State getTo() {
        return to;
    }
}
