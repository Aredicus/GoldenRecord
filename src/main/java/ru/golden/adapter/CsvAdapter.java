package ru.golden.adapter;

import org.apache.commons.csv.CSVRecord;

public interface CsvAdapter<T> {
    T readCsv(CSVRecord csvRecord);
}
