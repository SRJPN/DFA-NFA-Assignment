package dfaAssignment.tuple;

import java.util.HashSet;

public class Transitions {
    HashSet<Transition> transitions = new HashSet<Transition>();

    public boolean add(Transition transition){
        return transitions.add(transition);
    }

    public State getTransition(State from, Alphabet alphabet) throws NoSuchTrassitionException {
        for (Transition transition : transitions) {
            if(transition.hasTranssition(from, alphabet)){
                return transition.getTo();
            }
        }
        throw new NoSuchTrassitionException(from, alphabet);
    }

    public int size() {
        return transitions.size();
    }
}
