package dfaAssignment.tuple;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatesTest {
    private States states;

    @Before
    public void setUp() throws Exception {
        this.states = new States();
        states.add(new State("q1"));
        states.add(new State("q2"));
        states.add(new State("q3"));
        states.add(new State("q4"));
    }

    @Test
    public void hasState_returns_true_if_the_given_states_is_a_subset_of_states() throws Exception {
        States finalStates = new States();
        finalStates.add(new State("q1"));
        finalStates.add(new State("q2"));

        assertTrue(states.hasState(finalStates));
    }

    @Test
    public void hasState_returns_false_if_the_given_states_is_not_a_subset_of_states() throws Exception {
        States finalStates = new States();
        finalStates.add(new State("q5"));
        finalStates.add(new State("q6"));

        assertFalse(states.hasState(finalStates));
    }

    @Test
    public void hasState_returns_true_if_the_given_state_belongs_to_states() throws Exception {
        assertTrue(states.hasState(new State("q1")));
    }

    @Test
    public void hasState_returns_false_if_the_given_state_does_not_belongs_to_states() throws Exception {
        assertFalse(states.hasState(new State("q5")));
    }

}