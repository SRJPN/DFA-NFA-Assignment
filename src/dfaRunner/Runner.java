package dfaRunner;

import dfaAssignment.DFA;
import dfaAssignment.DfaGenerator;
import dfaAssignment.InvalidTupleException;
import dfaAssignment.tuple.Alphabet;
import dfaAssignment.tuple.NoSuchTransitionException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

class Runner {
    private final String jsonFile;

    public Runner(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    public void run() throws ParseException {
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonFile);
        for ( Object o : jsonArray) {
            DfaGenerator dfaGenerator = new DfaGenerator();
            JSONObject jsonObject = (JSONObject) o;
            try {
                System.out.println("\n->\t"+jsonObject.get("name").toString()+" is being analysed.....");
                runSingleString(dfaGenerator, jsonObject);
                System.out.println("\t\tchecked.... OK ✓");
            }catch (InvalidTupleException invalidTuple){
                System.out.println(invalidTuple.getMessage()+"\n");
            }catch (InvalidStringException e){
                System.out.println("DFA breaks for the string :"+e.getMessage());
            }catch (NoSuchTransitionException e){
                System.out.println("Invalid DFA :"+e.getMessage());
            }
        }
    }

    private void check(Boolean expectation, ArrayList<Alphabet> alphabets, DFA dfa) throws InvalidStringException, NoSuchTransitionException {
        if(expectation != dfa.check(alphabets))
            throw new InvalidStringException(alphabets);
    }

    private void runSingleString(DfaGenerator dfaGenerator, JSONObject jsonObject) throws InvalidTupleException, NoSuchTransitionException, InvalidStringException {
        DFA dfa = dfaGenerator.fromJson((JSONObject) jsonObject.get("tuple"));
        ArrayList<ArrayList<Alphabet>> passCases = dfaGenerator.parseCases((JSONArray) jsonObject.get("pass-cases"));
        for (ArrayList<Alphabet> alphabets : passCases) {
            check(true, alphabets, dfa);
        }

        ArrayList<ArrayList<Alphabet>> failCases = dfaGenerator.parseCases((JSONArray) jsonObject.get("fail-cases"));
        for (ArrayList<Alphabet> alphabets : failCases) {
            check(false, alphabets, dfa);
        }
    }
}
