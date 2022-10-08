package jsontocsv.writer;

import jsontocsv.parser.JSONFlattener;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CSVWriterTest {

    @Test
    public void testGetCVS(){
        Map<String,String> map = new HashMap<>();
        map.put("name","Nopparat");
        List<Map<String,String>> flatJson = new ArrayList<>();
        flatJson.add(map);
        String actualOutput = CSVWriter.getCSV(flatJson);
        String expectOutput = "name\nNopparat\n";
        assertThat(actualOutput).isEqualTo(expectOutput);

        List<Map<String,String>> flatJsonNull = null;
        assertThatThrownBy(()-> CSVWriter.getCSV(null)).isInstanceOf(NullPointerException.class);

        List<Map<String,String>> flatJsonEmpty = new ArrayList<>();
        actualOutput = CSVWriter.getCSV(flatJsonEmpty);
        expectOutput = "\n";
        assertThat(actualOutput).isEqualTo(expectOutput);
    }

    @Test
    public void testGetCSVWithSeparator(){
        Map<String,String> map = new HashMap<>();
        map.put("name","Nopparat");
        List<Map<String,String>> flatJson = new ArrayList<>();
        flatJson.add(map);

        String actualOutput = CSVWriter.getCSV(flatJson,",");
        String expectOutput = "name\nNopparat\n";
        assertThat(actualOutput).isEqualTo(expectOutput);

        List<Map<String,String>> flatJsonEmpty = new ArrayList<>();
        actualOutput = CSVWriter.getCSV(flatJsonEmpty,";");
        expectOutput = "\n";
        assertThat(actualOutput).isEqualTo(expectOutput);

        actualOutput = CSVWriter.getCSV(flatJson,"\t");
        expectOutput = "name\nNopparat\n";
        assertThat(actualOutput).isEqualTo(expectOutput);

        actualOutput = CSVWriter.getCSV(flatJson,"-");
        expectOutput = "name\nNopparat\n";
        assertThat(actualOutput).isEqualTo(expectOutput);

        actualOutput = CSVWriter.getCSV(flatJsonEmpty,"\t");
        System.out.println(actualOutput.toString());
        expectOutput = "\n";
        assertThat(actualOutput).isEqualTo(expectOutput);

        actualOutput = CSVWriter.getCSV(flatJsonEmpty,"=");
        System.out.println(actualOutput.toString());
        expectOutput = "\n";
        assertThat(actualOutput).isEqualTo(expectOutput);

    }

    @Test
    public void testWriteToFile(){
        String jsonString = "[{\"name\":\"Nopparat\"}]";
        List<Map<String, String>> flatJson = JSONFlattener.parseJson(jsonString);
        String csvString = CSVWriter.getCSV(flatJson, ",");
        String outputFile = "files/t1.csv";
        CSVWriter.writeToFile(csvString,outputFile);
        File f = new File(outputFile);
        assertThat(f.exists()).isTrue();

        String jsonStringEmpty = "[{}]";
        flatJson = JSONFlattener.parseJson(jsonStringEmpty);
        csvString = CSVWriter.getCSV(flatJson, "\t");
        outputFile = "files/t2.csv";
        CSVWriter.writeToFile(csvString,outputFile);
        f = new File(outputFile);
        assertThat(f.exists()).isTrue();

        jsonString = "[{\"name\":\"Nopparat\"}]";
        flatJson = JSONFlattener.parseJson(jsonString);
        csvString = CSVWriter.getCSV(flatJson, "\t");
        outputFile = "files/t3.csv";
        CSVWriter.writeToFile(csvString,outputFile);
        f = new File(outputFile);
        assertThat(f.exists()).isTrue();

        jsonString = "[{\"name\":\"Nopparat\"}]";
        flatJson = JSONFlattener.parseJson(jsonString);
        csvString = CSVWriter.getCSV(flatJson, "-");
        outputFile = "files/t4.csv";
        CSVWriter.writeToFile(csvString,outputFile);
        f = new File(outputFile);
        assertThat(f.exists()).isTrue();

        flatJson = JSONFlattener.parseJson(jsonStringEmpty);
        csvString = CSVWriter.getCSV(flatJson, "\t");
        outputFile = "files/t6.csv";
        CSVWriter.writeToFile(csvString,outputFile);
        f = new File(outputFile);
        assertThat(f.exists()).isTrue();

        flatJson = JSONFlattener.parseJson(jsonStringEmpty);
        csvString = CSVWriter.getCSV(flatJson, "=");
        outputFile = "files/t7.csv";
        CSVWriter.writeToFile(csvString,outputFile);
        f = new File(outputFile);
        assertThat(f.exists()).isTrue();
    }
}
