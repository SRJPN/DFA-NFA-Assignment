package dfaAssignment.tuple;

import org.junit.Test;

import static org.junit.Assert.*;

public class TranssitionTest {
    @Test
    public void hasTranssition_returns_true_for_valied_transition() throws Exception {
        State from = new State("q1");
        State to = new State("q2");
        Alphabet a = new Alphabet("A");
        Transsition transsition = new Transsition(from, a, to);

        assertTrue(transsition.hasTranssition(from, a));
    }

    @Test
    public void hasTranssition_returns_false_for_difference_in_alphabet() throws Exception {
        State from = new State("q1");
        State to = new State("q2");
        Alphabet a = new Alphabet("A");
        Transsition transsition = new Transsition(from, a, to);

        assertFalse(transsition.hasTranssition(from, new Alphabet("B")));
    }

    @Test
    public void hasTranssition_returns_false_for_difference_in_from_state() throws Exception {
        State from = new State("q1");
        State to = new State("q2");
        Alphabet a = new Alphabet("A");
        Transsition transsition = new Transsition(from, a, to);

        assertFalse(transsition.hasTranssition(to, a));
    }

}