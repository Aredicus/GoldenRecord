package ru.golden.adapter.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ru.golden.adapter.CsvAdapter;
import ru.golden.vo.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DataCsvAdapter implements CsvAdapter<Data> {
    private final Map<String, Method> fields;

    public DataCsvAdapter() {
        fields = Arrays.stream(Data.class.getDeclaredMethods())
                .filter(val -> val.getName().contains("set"))
                .collect(Collectors.toMap(
                        val -> val.getName().toLowerCase(Locale.ROOT).replace("set", ""),
                        val -> val));
        for (Map.Entry<String, Method> entry : fields.entrySet()) {
            entry.getValue().setAccessible(true);
        }
    }

    @Override
    public Data readCsv(CSVRecord csvRecord) {
        Data res = new Data();
        Map<String, String> dataFromCsv = csvRecord.toMap();
        for (Map.Entry<String, String> entry : dataFromCsv.entrySet()) {
            String field = entry.getKey().contains("_")
                    ? entry.getKey().replace("_", "").toLowerCase(Locale.ROOT)
                    : entry.getKey().toLowerCase(Locale.ROOT);
            try {
                fields.get(field).invoke(res, entry.getValue());
            } catch (InvocationTargetException | IllegalAccessException e) {
                System.out.println("Неудачное занесение данных в класс");
            } catch (IllegalArgumentException e) {
                System.out.println(entry);
            }
        }

        return res.isCorrect() ? res : null;
    }
}
