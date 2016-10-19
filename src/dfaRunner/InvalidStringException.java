package dfaRunner;

import dfaAssignment.tuple.Alphabet;
import dfaAssignment.tuple.Alphabets;

import java.util.ArrayList;

class InvalidStringException extends Throwable {
    public InvalidStringException(ArrayList<Alphabet> alphabets) {
        super(alphabets.toString());

    }
}
