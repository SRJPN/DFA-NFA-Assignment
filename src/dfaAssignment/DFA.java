package dfaAssignment;

import dfaAssignment.tuple.*;

public class DFA {

    private final States states;
    private final Alphabets alphabets;
    private final Transsitions transsitions;
    private final State initialState;
    private final States finalStates;

    private DFA(States states, Alphabets alphabets, Transsitions transsitions, State initialState, States finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.transsitions = transsitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public static DFA generateDFA(States states, Alphabets alphabets, Transsitions transsitions, State initialState, States finalStates) throws InvalidTupleException {
        boolean finalStatesValidation = states.hasState(finalStates);
        boolean initialStateValidation = states.hasState(initialState);
        if(finalStatesValidation && initialStateValidation)
            return new DFA(states, alphabets, transsitions, initialState, finalStates);
        throw new InvalidTupleException();
    }

    public boolean check(Alphabets string)  {
        State current = initialState;
        for (Alphabet alphabet : string) {
            current = transsitions.getTranssition(current, alphabet);
        }
        return finalStates.hasState(current);
    }
}
