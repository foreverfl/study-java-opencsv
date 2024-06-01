package study.java.opencsv;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class OpencsvExample {
    public static void main(String[] args) throws CsvValidationException {
        Path csvPath = Paths.get("C:\\bucket\\programming.csv");

        System.out.println("CSV File Path: " + csvPath.toAbsolutePath());
        try (CSVReader reader = new CSVReader(new FileReader(csvPath.toFile(), StandardCharsets.UTF_8))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                for (String value : line) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
