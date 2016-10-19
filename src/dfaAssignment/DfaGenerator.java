package dfaAssignment;
import dfaAssignment.tuple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Set;

public class DfaGenerator {

    public DFA fromJson(JSONObject tuple) throws InvalidTupleException {
        States states = parseStates((JSONArray) tuple.get("states"));

        Alphabets alphabets = new Alphabets();
        for (Object alphabet : (JSONArray) tuple.get("alphabets")) {
            alphabets.add(new Alphabet((String) alphabet));
        }
        State initialState = new State((String) tuple.get("start-state"));
        States finalStates = parseStates((JSONArray) tuple.get("final-states"));
        Transitions transitions = parseTransitions((JSONObject) tuple.get("delta"));

        return DFA.generateDFA(states, alphabets, transitions, initialState, finalStates);
    }

    private States parseStates(JSONArray jsonArray){
        States states = new States();
        for (Object state : jsonArray) {
            states.add(new State((String) state));
        }
        return states;
    }

    private Transitions parseTransitions(JSONObject jsonObject){
        Transitions transitions = new Transitions();
        Set set = jsonObject.keySet();
        for (Object from : set) {
            JSONObject o = (JSONObject) jsonObject.get(from);
            Set innerKeySet = o.keySet();
            for (Object alphabet : innerKeySet) {
                transitions.add(new Transition(new State((String) from), new Alphabet((String) alphabet), new State((String) o.get(alphabet))));
            }
        }
        return transitions;
    }

    public ArrayList<ArrayList<Alphabet>> parseCases(JSONArray jsonObject){
        ArrayList<ArrayList<Alphabet>> alphabetses = new ArrayList<>();
        for (Object string : jsonObject) {
            ArrayList<Alphabet> alphabets = new ArrayList<Alphabet>();
            if(!((String) string).isEmpty()) {
                String[] string1 = ((String) string).split("");
                for (String alphabet : string1) {
                    alphabets.add(new Alphabet(alphabet));
                }
            }
            alphabetses.add(alphabets);
        }
        return alphabetses;
    }
}
