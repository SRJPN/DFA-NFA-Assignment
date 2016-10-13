package dfaAssignment.tuple;

import java.util.NoSuchElementException;

public class DeltaFunction {
    private final Transsitions transsitions;

    public DeltaFunction(Transsitions transsitions) {
        this.transsitions = transsitions;
    }
//
//    public State somthing(State from, Alphabet alphabet) throws NoSuchTrassitionException {
//        for (Transsition transsition : transsitions) {
//            if(transsition.hasTranssition(from, alphabet)){
//                return transsition.transsition(from, alphabet);
//            }
//        }
//        throw new NoSuchTrassitionException(from, alphabet);
//    }
}
