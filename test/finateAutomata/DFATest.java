package finateAutomata;

import finateAutomata.dfa.DFA;
import finateAutomata.tuple.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void it_gives_out_a_dfa() throws Exception, NoSuchTransitionException, InvalidTupleException {
        States states = new States();
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        states.add(q1);
        states.add(q2);
        states.add(q3);

        Alphabets alphabets = new Alphabets();
        Alphabet zero = new Alphabet("0");
        Alphabet one = new Alphabet("1");
        Alphabet two = new Alphabet("2");
        alphabets.add(zero);
        alphabets.add(one);
        alphabets.add(two);

        States finalStates = new States();
        finalStates.add(q1);

        Transitions transitions = new Transitions();
        transitions.add(new Transition(q1,two,q3));
        transitions.add(new Transition(q3,two,q2));
        transitions.add(new Transition(q2,two,q1));

        transitions.add(new Transition(q1,one,q2));
        transitions.add(new Transition(q2,one,q3));
        transitions.add(new Transition(q3,one,q1));

        transitions.add(new Transition(q1,zero,q1));
        transitions.add(new Transition(q2,zero,q2));
        transitions.add(new Transition(q3,zero,q3));

        DFA dfa = DFA.generateDFA(states, alphabets, transitions, q1, finalStates);

        ArrayList<Alphabet> testPassString = new ArrayList<>();
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("2"));
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("2"));
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("1"));

        ArrayList<Alphabet> testFailString = new ArrayList<>();
        testFailString.add(new Alphabet("1"));
        testFailString.add(new Alphabet("2"));
        testFailString.add(new Alphabet("1"));
        testFailString.add(new Alphabet("2"));
        testFailString.add(new Alphabet("1"));
        testFailString.add(new Alphabet("1"));

        assertTrue(dfa.check(testPassString));
        assertFalse(dfa.check(testFailString));
    }

    @Test
    public void stay_in_initial_state_if_null_string_is_passed() throws Exception, NoSuchTransitionException, InvalidTupleException {
        States states = new States();
        State q1 = new State("q1");
        State q2 = new State("q2");
        states.add(q1);
        states.add(q2);

        Alphabets alphabets = new Alphabets();
        Alphabet zero = new Alphabet("0");
        alphabets.add(zero);

        States finalStates = new States();
        finalStates.add(q1);

        Transitions transitions = new Transitions();
        transitions.add(new Transition(q1,zero,q2));
        transitions.add(new Transition(q2,zero,q1));

        DFA dfa = DFA.generateDFA(states, alphabets, transitions, q1, finalStates);

        ArrayList<Alphabet> testPassString = new ArrayList<>();

        assertTrue(dfa.check(testPassString));
    }
}