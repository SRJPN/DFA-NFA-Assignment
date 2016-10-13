package dfaAssignment.tuple;

import java.util.ArrayList;
import java.util.Iterator;

public class Alphabets extends ArrayList<Alphabet> {

    public boolean hasAlphabet(Alphabet alphabet) {
        return contains(alphabet);
    }

    @Override
    public String toString() {
        Iterator<Alphabet> iterator = this.iterator();
        String result = "";
        while(iterator.hasNext()){
             result += iterator.next().toString();
        }
        return result;
    }
}
