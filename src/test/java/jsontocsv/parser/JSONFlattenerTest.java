package jsontocsv.parser;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jsontocsv.parser.JSONFlattener.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JSONFlattenerTest {

    @Test
    public void testParseStringJson(){
        String t4 = "[{}]";
        List<Map<String, String>> actualJson = JSONFlattener.parseJson(t4);
        String expectJson = "[{}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);


        String t5 = "[{\"name\":\"Nopparat\"}]";
        actualJson = JSONFlattener.parseJson(t5);
        expectJson = "[{name=Nopparat}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);

        String t6 = "[{\"Nopparat\"}]";
        actualJson = JSONFlattener.parseJson(t6);
        assertThat(actualJson).isNull();

    }

    @Test
    public void testParseFileJson(){
        List<Map<String, String>> actualJson = JSONFlattener.parseJson(
                new File("files/testParseFileJson_t1.json"));
        String expectJson = "[{}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);

        actualJson = JSONFlattener.parseJson(
                new File("files/testParseFileJson_t2.json"));
        expectJson = "[{name=Nopparat}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);

    }

    @Test
    public void testParseFileJsonWithEncoding(){
        List<Map<String, String>> actualJson = JSONFlattener.parseJson(
                new File("files/testParseFileJsonWithEncoder_t1.json"),"UTF-8");
        String expectJson = "[{name=Nopparat}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);

        actualJson = JSONFlattener.parseJson(
                new File("files/testParseFileJsonWithEncoder_t2.txt"),"UTF-8");
        assertThat(actualJson).isNull();
    }

    @Test
    public void testParseURIJson() throws URISyntaxException {

        List<Map<String, String>> actualJson = JSONFlattener.parseJson(
                new URI("http://google.com/"));
        assertThat(actualJson).isNull();
        actualJson = JSONFlattener.parseJson(
                new URI("http://echo.jsontest.com/name/Nopparat/?"));
        String expectJson = "[{name=Nopparat}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);
        actualJson = JSONFlattener.parseJson(
                new URI("http://echo.jsontest.com/"));
        expectJson = "[{=}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);
    }

    @Test
    public void testParseURIJsonWithEncoder() throws URISyntaxException {
        List<Map<String, String>> actualJson = JSONFlattener.parseJson(
                new URI("http://google.com/"),"UTF-8");
        assertThat(actualJson).isNull();
        actualJson = JSONFlattener.parseJson(
                new URI("http://echo.jsontest.com/name/Nopparat/?"),"UTF-8");
        String expectJson = "[{name=Nopparat}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);
        actualJson = JSONFlattener.parseJson(
                new URI("http://echo.jsontest.com/"),"UTF-8");
        expectJson = "[{=}]";
        assertThat(actualJson.toString()).isEqualTo(expectJson);
    }
}
