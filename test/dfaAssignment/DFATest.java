package dfaAssignment;

import dfaAssignment.tuple.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void it_gives_out_a_dfa() throws Exception, NoSuchTrassitionException, InvalidTupleException {
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

        Transsitions transsitions = new Transsitions();
        transsitions.add(new Transsition(q1,two,q3));
        transsitions.add(new Transsition(q3,two,q2));
        transsitions.add(new Transsition(q2,two,q1));

        transsitions.add(new Transsition(q1,one,q2));
        transsitions.add(new Transsition(q2,one,q3));
        transsitions.add(new Transsition(q3,one,q1));

        DFA dfa = DFA.generateDFA(states, alphabets, transsitions, q1, finalStates);

        Alphabets testPassString = new Alphabets();
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("2"));
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("2"));
        testPassString.add(new Alphabet("1"));
        testPassString.add(new Alphabet("1"));

        Alphabets testFailString = new Alphabets();
        testFailString.add(new Alphabet("1"));
        testFailString.add(new Alphabet("2"));
        testFailString.add(new Alphabet("1"));
        testFailString.add(new Alphabet("2"));
        testFailString.add(new Alphabet("1"));
        testFailString.add(new Alphabet("1"));

        assertTrue(dfa.check(testPassString));
        assertFalse(dfa.check(testFailString));

    }
}