package finateAutomata.tuple;

class DeltaFunction {
    private final Transitions transitions;

    public DeltaFunction(Transitions transitions) {
        this.transitions = transitions;
    }
//
//    public State somthing(State from, Alphabet alphabet) throws NoSuchTransitionException {
//        for (Transition transsition : transitions) {
//            if(transsition.hasTransition(from, alphabet)){
//                return transsition.transsition(from, alphabet);
//            }
//        }
//        throw new NoSuchTransitionException(from, alphabet);
//    }
}
