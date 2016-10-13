package dfaAssignment.tuple;

import dfaAssignment.tuple.Transsition;

import java.util.ArrayList;

public class Transsitions {
    ArrayList<Transsition> transsitions = new ArrayList<Transsition>();

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
}
