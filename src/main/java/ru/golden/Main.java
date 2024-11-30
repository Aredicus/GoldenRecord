package ru.golden;

import ru.golden.adapter.impl.DataCsvAdapter;
import ru.golden.reader.impl.CsvCustomReader;
import ru.golden.vo.Data;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до файла");
        CsvCustomReader<Data> reader = new CsvCustomReader<>(new DataCsvAdapter(), scanner.next());
        reader.read();
        List<Data> dataList = reader.getDataList();
        for (Data data : dataList) {
            System.out.println(data.toCsvFormat());
        }
    }

}
