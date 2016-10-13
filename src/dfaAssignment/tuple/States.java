package dfaAssignment.tuple;

import dfaAssignment.tuple.State;

import java.util.ArrayList;
import java.util.Collection;

public class States {
    private final ArrayList<State> states;

    public States() {
        this.states = new ArrayList<State>();
    }

    public boolean add(State state){
        return states.add(state);
    }

    public boolean hasState(States finalStates) {
        return states.containsAll((Collection<State>) finalStates.states);
    }

    public boolean hasState(State state) {
        return states.contains(state);
    }
}
