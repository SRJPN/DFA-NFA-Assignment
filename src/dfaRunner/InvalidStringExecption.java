package dfaRunner;

import dfaAssignment.tuple.Alphabets;

public class InvalidStringExecption extends Throwable {
    public InvalidStringExecption(Alphabets alphabets) {
        super(alphabets.toString());
    }
}
