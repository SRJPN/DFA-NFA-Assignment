package finateAutomata.tuple;

import java.util.HashSet;

public class Transitions {
    private final HashSet<Transition> transitions = new HashSet<>();

    public boolean add(Transition transition){
        return transitions.add(transition);
    }

    public State getTransition(State from, Alphabet alphabet) throws NoSuchTransitionException {
        for (Transition transition : transitions) {
            if(transition.hasTransition(from, alphabet)){
                return transition.getTo();
            }
        }
        throw new NoSuchTransitionException(from, alphabet);
    }

    public int size() {
        return transitions.size();
    }
}
