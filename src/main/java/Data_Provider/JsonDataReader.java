package Data_Provider;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public String Location;




    public void JsonReader() throws IOException, ParseException
    {
        String filePath = System.getProperty("user.dir")+"/src/main/java/Data_Provider/Data.json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));

        for(Object jsonObj : jarray)
        {
            JSONObject person = (JSONObject) jsonObj ;
            Location  = (String) person.get("Location");

        }

    }
}
