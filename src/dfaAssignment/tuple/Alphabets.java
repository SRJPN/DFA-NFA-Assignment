package dfaAssignment.tuple;

import java.util.HashSet;
import java.util.Iterator;

public class Alphabets {
    HashSet<Alphabet> alphabets = new HashSet<>();

    public boolean hasAlphabet(Alphabet alphabet) {
        return alphabets.contains(alphabet);
    }

    @Override
    public String toString() {
        Iterator<Alphabet> iterator = alphabets.iterator();
        String result = "";
        while(iterator.hasNext()){
             result += iterator.next().toString();
        }
        return result;
    }

    public void add(Alphabet alphabet) {
        alphabets.add(alphabet);
    }

    public int size() {
        return alphabets.size();
    }

    public Iterator<Alphabet> iterator() {
        return alphabets.iterator();
    }
}
