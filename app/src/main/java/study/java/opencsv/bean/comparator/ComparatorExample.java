package study.java.opencsv.bean.comparator;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.ComparatorUtils;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import study.java.opencsv.bean.Bean;

public class ComparatorExample {
    public static void main(String[] args) throws CsvValidationException, IOException {
        String csvPath = "C:\\bucket\\programming.csv";
        System.out.println("CSV File Path: " + Paths.get(csvPath).toAbsolutePath());

        try (CSVReader reader = new CSVReader(new FileReader(csvPath, StandardCharsets.UTF_8))) {
            CsvToBean<Bean> csvToBean = new CsvToBeanBuilder<Bean>(reader)
                    .withType(Bean.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Bean> beans = csvToBean.parse();

            // Apache Commons Collections의 Comparator 사용
            Collections.sort(beans, ComparatorUtils.naturalComparator());

            for (Bean bean : beans) {
                System.out.println(bean);
            }
        }
    }
}
