package study.java.opencsv.bean;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class BeanExample {
    public static void main(String[] args) throws IOException, CsvValidationException {
        String csvPath = "C:\\bucket\\programming.csv";
        System.out.println("CSV File Path: " + Paths.get(csvPath).toAbsolutePath());

        try (CSVReader reader = new CSVReader(new FileReader(csvPath, StandardCharsets.UTF_8))) {
            CsvToBean<Bean> csvToBean = new CsvToBeanBuilder<Bean>(reader)
                    .withType(Bean.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Bean> beans = csvToBean.parse();

            for (Bean bean : beans) {
                System.out.println(bean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}