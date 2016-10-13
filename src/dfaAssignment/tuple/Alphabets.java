package dfaAssignment.tuple;

import java.util.ArrayList;

public class Alphabets extends ArrayList<Alphabet> {

    public boolean hasAlphabet(Alphabet alphabet) {
        return contains(alphabet);
    }
}
