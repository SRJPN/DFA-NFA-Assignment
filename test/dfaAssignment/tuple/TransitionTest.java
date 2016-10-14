package dfaAssignment.tuple;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransitionTest {
    @Test
    public void hasTranssition_returns_true_for_valied_transition() throws Exception {
        State from = new State("q1");
        State to = new State("q2");
        Alphabet a = new Alphabet("A");
        Transition transition = new Transition(from, a, to);

        assertTrue(transition.hasTransition(from, a));
    }

    @Test
    public void hasTranssition_returns_false_for_difference_in_alphabet() throws Exception {
        State from = new State("q1");
        State to = new State("q2");
        Alphabet a = new Alphabet("A");
        Transition transition = new Transition(from, a, to);

        assertFalse(transition.hasTransition(from, new Alphabet("B")));
    }

    @Test
    public void hasTranssition_returns_false_for_difference_in_from_state() throws Exception {
        State from = new State("q1");
        State to = new State("q2");
        Alphabet a = new Alphabet("A");
        Transition transition = new Transition(from, a, to);

        assertFalse(transition.hasTransition(to, a));
    }

}