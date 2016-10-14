package dfaAssignment.tuple;

import dfaAssignment.tuple.Transsition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Transsitions {
    HashSet<Transsition> transsitions = new HashSet<Transsition>();

    public boolean add(Transsition transsition){
        return transsitions.add(transsition);
    }

    public State getTranssition(State from, Alphabet alphabet) throws NoSuchTrassitionException {
        for (Transsition transsition : transsitions) {
            if(transsition.hasTranssition(from, alphabet)){
                return transsition.getTo();
            }
        }
        throw new NoSuchTrassitionException(from, alphabet);
    }

    public int size() {
        return transsitions.size();
    }
}
