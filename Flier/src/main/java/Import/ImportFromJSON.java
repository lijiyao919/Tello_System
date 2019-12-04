package Import;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ImportFromJSON implements ImportStrategy {
    @Override
    public void load(ArrayList missions) throws Exception {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\a02231961\\IdeaProjects\\Tello_System\\Flier\\input\\missions"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting missions
        JSONArray ja = (JSONArray) jo.get("MISSIONS");

        // iterating missions
        Iterator itr = ja.iterator();

        while (itr.hasNext())
        {
            Long number = (Long) itr.next();
            missions.add(number);
        }
    }
}
