package finateAutomata.tuple;

import java.util.HashSet;

public class States {
    private final HashSet<State> states;

    public States() {
        this.states = new HashSet<>();
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
