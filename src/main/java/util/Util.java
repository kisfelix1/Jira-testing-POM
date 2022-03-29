package util;


import org.openqa.selenium.NotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
    private static List<List<String>> getCSVData(String filePath) throws IOException {
        List<List<String>> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        br.readLine();
        String line = "";
        while((line = br.readLine()) != null) {
            result.add(List.of(line.split(",")));
        }
        br.close();
        return result;
    }

    public static List<String> getTestData(String key, String filePath) throws IOException {
        List<List<String>> data = getCSVData(filePath);
        for (List<String> row : data) {
            if(row.get(0).equals(key)){
                return row;
            }
        }
        throw new NotFoundException("Given key not found! File path: " + filePath);
    }
}
