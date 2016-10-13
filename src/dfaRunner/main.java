package dfaRunner;

import dfaRunner.Runner;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        String jsonString = reader(args[0]);
        Runner runner = new Runner(jsonString);

        try {
            runner.run();
        } catch (ParseException e) {
            System.out.println("error in parsing the json");
        }
    }

    public static String reader(String fileName){
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                result += sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
