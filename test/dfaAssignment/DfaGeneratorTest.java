package dfaAssignment;

import dfaAssignment.tuple.Alphabets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DfaGeneratorTest {
    @Test
    public void fromJson() throws Exception, InvalidTupleException {
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
        ArrayList<Alphabets> passCases = dfaGenerator.parseCases((JSONArray) jsonObject.get("pass-cases"));
        for (Alphabets alphabets : passCases) {
            assertTrue(dfa.check(alphabets));
        }

        ArrayList<Alphabets> failCases = dfaGenerator.parseCases((JSONArray) jsonObject.get("fail-cases"));
        for (Alphabets alphabets : failCases) {
            assertFalse(dfa.check(alphabets));
        }

    }

}