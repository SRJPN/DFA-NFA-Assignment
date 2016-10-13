package dfaAssignment.tuple;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetsTest {
    private Alphabets alphabets;

    @Before
    public void setUp() throws Exception {
        this.alphabets = new Alphabets();
        alphabets.add(new Alphabet("A"));
        alphabets.add(new Alphabet("B"));
        alphabets.add(new Alphabet("C"));
    }

    @Test
    public void hasAlphabet_returns_true_if_it_has_the_given_alphabet_in_it() throws Exception {
        assertTrue(alphabets.hasAlphabet(new Alphabet("A")));
    }

    @Test
    public void hasAlphabet_returns_false_if_it_does_not_have_the_given_alphabet_in_it() throws Exception {
        assertFalse(alphabets.hasAlphabet(new Alphabet("D")));
    }
}