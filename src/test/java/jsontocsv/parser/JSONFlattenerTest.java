package jsontocsv.parser;

import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;


public class JSONFlattenerTest {

    @Test
    public void testParseJson(){
        JSONObject obj = new JSONObject();

        obj.put("name","foo");
        obj.put("num",100);
        obj.put("balance",1000.21);
        obj.put("is_vip",true);

        StringWriter out = new StringWriter();
        obj.write(out);

        String jsonText = out.toString();
        List<Map<String, String>> flatJson = JSONFlattener.parseJson(jsonText);
        System.out.println(flatJson);
    }
}
