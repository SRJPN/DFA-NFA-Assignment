package dfaRunner;

import dfaAssignment.tuple.Alphabets;

class InvalidStringException extends Throwable {
    public InvalidStringException(Alphabets alphabets) {
        super(alphabets.toString());

    }
}
