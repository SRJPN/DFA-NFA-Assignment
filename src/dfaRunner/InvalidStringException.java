package dfaRunner;

import finateAutomata.tuple.Alphabet;

import java.util.ArrayList;

class InvalidStringException extends Throwable {
    public InvalidStringException(ArrayList<Alphabet> alphabets) {
        super(alphabets.toString());

    }
}
