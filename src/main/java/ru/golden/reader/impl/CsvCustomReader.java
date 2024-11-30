package ru.golden.reader.impl;

import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.golden.adapter.CsvAdapter;
import ru.golden.reader.CustomReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvCustomReader<T> implements CustomReader {

    private final String input;
    @Getter
    private final List<T> dataList;
    private final CsvAdapter<T> csvAdapter;

    public CsvCustomReader(CsvAdapter<T> csvAdapter, String input) {
        this.input = input;
        this.csvAdapter = csvAdapter;
        this.dataList = new ArrayList<>();
    }

    @Override
    public void read() {
        try (FileReader fileReader = new FileReader(input)) {
            Iterable<CSVRecord> records = CSVFormat.Builder.create(CSVFormat.EXCEL)
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(fileReader);
            for (CSVRecord record : records) {
                var data = csvAdapter.readCsv(record);
                if (Objects.nonNull(data)) {
                    dataList.add(data);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
