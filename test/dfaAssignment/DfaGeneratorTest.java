package dfaAssignment;

import dfaAssignment.tuple.Alphabet;
import dfaAssignment.tuple.Alphabets;
import dfaAssignment.tuple.NoSuchTransitionException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DfaGeneratorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void fromJson() throws Exception, InvalidTupleException, NoSuchTransitionException {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse("{\n" +
                "    \"name\": \"odd number of zeroes\",\n" +
                "    \"type\": \"dfa\",\n" +
                "    \"tuple\": {\n" +
                "        \"states\": [\"q1\", \"q2\"],\n" +
                "        \"alphabets\": [\"1\", \"0\"],\n" +
                "        \"delta\": {\n" +
                "            \"q1\": {\n" +
                "                \"0\": \"q2\",\n" +
                "                \"1\": \"q1\"\n" +
                "            },\n" +
                "            \"q2\": {\n" +
                "                \"0\": \"q1\",\n" +
                "                \"1\": \"q2\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"start-state\": \"q1\",\n" +
                "        \"final-states\": [\"q2\"]\n" +
                "    },\n" +
                "    \"pass-cases\": [\"0\", \"000\", \"00000\", \"10\", \"101010\", \"010101\"],\n" +
                "    \"fail-cases\": [\"00\", \"0000\", \"1001\", \"1010\", \"001100\"]\n" +
                "}");
        DfaGenerator dfaGenerator = new DfaGenerator();
        DFA dfa = dfaGenerator.fromJson((JSONObject) jsonObject.get("tuple"));
        ArrayList<ArrayList<Alphabet>> passCases = dfaGenerator.parseCases((JSONArray) jsonObject.get("pass-cases"));
        for (ArrayList<Alphabet> alphabets : passCases) {
            assertTrue(dfa.check(alphabets));
        }

        ArrayList<ArrayList<Alphabet>> failCases = dfaGenerator.parseCases((JSONArray) jsonObject.get("fail-cases"));
        for (ArrayList<Alphabet> alphabets : failCases) {
            assertFalse(dfa.check(alphabets));
        }
    }

    @Test
    public void it_throws_InvalidTupleException_if_the_final_state_is_not_a_sub_set_of_states() throws ParseException, InvalidTupleException {
        exception.expect(InvalidTupleException.class);
        exception.expectMessage("Error in Tuple");

        JSONObject jsonObject = (JSONObject) new JSONParser().parse("{\n" +
                "    \"tuple\": {\n" +
                "        \"states\": [\"q1\", \"q2\"],\n" +
                "        \"alphabets\": [\"1\", \"0\"],\n" +
                "        \"delta\": {\n" +
                "            \"q1\": {\n" +
                "                \"0\": \"q2\",\n" +
                "                \"1\": \"q1\"\n" +
                "            },\n" +
                "            \"q2\": {\n" +
                "                \"0\": \"q1\",\n" +
                "                \"1\": \"q2\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"start-state\": \"q1\",\n" +
                "        \"final-states\": [\"q5\"]\n" +
                "    }\n" +
                "}");
        DfaGenerator dfaGenerator = new DfaGenerator();
        dfaGenerator.fromJson((JSONObject) jsonObject.get("tuple"));
    }

    @Test
    public void it_throws_InvalidTupleException_if_the_initial_state_does_not_belong_to_states() throws ParseException, InvalidTupleException {
        exception.expect(InvalidTupleException.class);
        exception.expectMessage("Error in Tuple");

        JSONObject jsonObject = (JSONObject) new JSONParser().parse("{\n" +
                "    \"tuple\": {\n" +
                "        \"states\": [\"q1\", \"q2\"],\n" +
                "        \"alphabets\": [\"1\", \"0\"],\n" +
                "        \"delta\": {\n" +
                "            \"q1\": {\n" +
                "                \"0\": \"q2\",\n" +
                "                \"1\": \"q1\"\n" +
                "            },\n" +
                "            \"q2\": {\n" +
                "                \"0\": \"q1\",\n" +
                "                \"1\": \"q2\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"start-state\": \"q5\",\n" +
                "        \"final-states\": [\"q1\"]\n" +
                "    }\n" +
                "}");
        DfaGenerator dfaGenerator = new DfaGenerator();
        dfaGenerator.fromJson((JSONObject) jsonObject.get("tuple"));
    }

    @Test
    public void it_throws_InvalidTupleException_if_it_has_less_number_of_transsitions() throws ParseException, InvalidTupleException {
        exception.expect(InvalidTupleException.class);
        exception.expectMessage("Error in Tuple");

        JSONObject jsonObject = (JSONObject) new JSONParser().parse("{\n" +
                "    \"tuple\": {\n" +
                "        \"states\": [\"q1\", \"q2\"],\n" +
                "        \"alphabets\": [\"1\", \"0\"],\n" +
                "        \"delta\": {\n" +
                "            \"q1\": {\n" +
                "                \"0\": \"q2\",\n" +
                "                \"1\": \"q1\"\n" +
                "            },\n" +
                "            \"q2\": {\n" +
                "                \"0\": \"q1\",\n" +
                "            }\n" +
                "        },\n" +
                "        \"start-state\": \"q2\",\n" +
                "        \"final-states\": [\"q1\"]\n" +
                "    }\n" +
                "}");
        DfaGenerator dfaGenerator = new DfaGenerator();
        dfaGenerator.fromJson((JSONObject) jsonObject.get("tuple"));
    }

}