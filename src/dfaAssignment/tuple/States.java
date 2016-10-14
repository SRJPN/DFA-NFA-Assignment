package dfaAssignment.tuple;

import dfaAssignment.tuple.State;

import java.util.ArrayList;

public class States {
    private final ArrayList<State> states;

    public States() {
        this.states = new ArrayList<>();
    }

    public boolean add(State state){
        return states.add(state);
    }

    public boolean hasState(States finalStates) {
        return states.containsAll(finalStates.states);
    }

    public boolean hasState(State state) {
        return states.contains(state);
    }

    public int size() {
        return states.size();
    }
}
