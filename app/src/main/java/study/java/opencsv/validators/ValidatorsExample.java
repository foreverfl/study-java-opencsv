package study.java.opencsv.validators;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.LineValidator;
import com.opencsv.validators.LineValidatorAggregator;

public class ValidatorsExample {
    public static void main(String[] args) throws CsvValidationException {
        Path csvPath = Paths.get("C:\\bucket\\programming.csv");

        try (CSVReader reader = new CSVReader(new FileReader(csvPath.toFile(), StandardCharsets.UTF_8))) {
            // LineValidator 구현
            LineValidator lineValidator = new LineValidator() {

                @Override
                public boolean isValid(String line) {
                    return line != null && !line.trim().isEmpty();
                }

                @Override
                public void validate(String line) throws CsvValidationException {
                    if (!isValid(line)) {
                        throw new CsvValidationException("Invalid line: " + line);
                    }
                }
            };

            LineValidatorAggregator lineValidatorAggregator = new LineValidatorAggregator();
            lineValidatorAggregator.addValidator(lineValidator);

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String line = String.join(",", nextLine);
                if (!lineValidatorAggregator.isValid(line)) {
                    System.out.println("Invalid line: " + line);
                } else {
                    System.out.println("Valid line: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class MyBean {
        private String name;
        private int age;
        private String country;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "MyBean{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}
