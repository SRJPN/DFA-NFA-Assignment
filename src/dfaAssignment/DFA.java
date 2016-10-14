package dfaAssignment;

import dfaAssignment.tuple.*;

public class DFA {

    private final States states;
    private final Alphabets alphabets;
    private final Transitions transitions;
    private final State initialState;
    private final States finalStates;

    private DFA(States states, Alphabets alphabets, Transitions transitions, State initialState, States finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public static DFA generateDFA(States states, Alphabets alphabets, Transitions transitions, State initialState, States finalStates) throws InvalidTupleException {
        boolean finalStatesValidation = states.hasState(finalStates);
        boolean initialStateValidation = states.hasState(initialState);
        boolean transitionAlphabetValidation = transitionAlphabetValidation(transitions, alphabets, states);
        if(finalStatesValidation && initialStateValidation && transitionAlphabetValidation)
            return new DFA(states, alphabets, transitions, initialState, finalStates);
        throw new InvalidTupleException();
    }

    public boolean check(Alphabets string) throws NoSuchTransitionException {
        State current = initialState;
        for (Alphabet alphabet : string) {
            current = transitions.getTransition(current, alphabet);
        }
        return finalStates.hasState(current);
    }

    private static boolean transitionAlphabetValidation(Transitions transitions, Alphabets alphabets, States states){
        return transitions.size() == (alphabets.size()*states.size());
    }
}
