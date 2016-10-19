package finateAutomata.tuple;

public class Alphabet {
    private final String alphabet;

    public Alphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alphabet alphabet1 = (Alphabet) o;

        return alphabet != null ? alphabet.equals(alphabet1.alphabet) : alphabet1.alphabet == null;

    }

    @Override
    public int hashCode() {
        return alphabet != null ? alphabet.hashCode() : 0;
    }

    @Override
    public String toString() {
        return alphabet;
    }
}
