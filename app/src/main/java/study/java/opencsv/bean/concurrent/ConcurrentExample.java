package study.java.opencsv.bean.concurrent;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.opencsv.CSVReader;
import com.opencsv.bean.BeanVerifier;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.concurrent.CompleteFileReader;
import com.opencsv.bean.concurrent.LineExecutor;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import study.java.opencsv.bean.Bean;

public class ConcurrentExample {
    public static void main(String[] args) throws CsvValidationException, IOException, InterruptedException {
        String csvPath = "C:\\bucket\\programming.csv";
        System.out.println("CSV File Path: " + Paths.get(csvPath).toAbsolutePath());

        // 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        LinkedBlockingQueue<Bean> beanQueue = new LinkedBlockingQueue<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvPath, StandardCharsets.UTF_8))) {
            // 매핑 전략 정의
            ColumnPositionMappingStrategy<Bean> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Bean.class);
            strategy.setColumnMapping("name", "language");

            // 모든 라인을 허용하는 간단한 필터 정의
            CsvToBeanFilter filter = line -> true;

            // 예외 처리기 정의
            CsvExceptionHandler exceptionHandler = new CsvExceptionHandler() {
                @Override
                public CsvException handleException(CsvException e) throws CsvException {
                    e.printStackTrace();
                    return e;
                }

            };

            // 빈 검증기 리스트 정의
            List<BeanVerifier<Bean>> verifiers = new ArrayList<>();

            // CompleteFileReader 생성
            CompleteFileReader<Bean> completeFileReader = new CompleteFileReader<>(
                    reader,
                    filter,
                    true,
                    strategy,
                    exceptionHandler,
                    verifiers);

            // LineExecutor 생성
            LineExecutor<Bean> lineExecutor = new LineExecutor<>(true, Locale.getDefault(), completeFileReader);
            lineExecutor.submitLine(0, strategy, filter, verifiers, args, exceptionHandler);

            // CompleteFileReader에 LineExecutor 설정
            completeFileReader.setExecutor(lineExecutor);

            // 파일 읽기 및 처리 시작
            Thread readerThread = new Thread(completeFileReader);
            readerThread.start();
            readerThread.join(); // Reader 스레드가 완료될 때까지 대기

            // 처리된 Bean 객체 출력
            Bean bean;
            while ((bean = beanQueue.poll()) != null) {
                System.out.println(bean);
            }

            // 스레드 풀 종료
            executorService.shutdown();
        }
    }
}
