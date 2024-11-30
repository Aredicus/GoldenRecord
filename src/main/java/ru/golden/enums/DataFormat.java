package ru.golden.enums;

import lombok.Getter;

@Getter
public enum DataFormat {
    BIRTH_DAY("yyyy-MM-dd"),
    FIN_DATE("yyyy-MM-dd"),
    CREATE_DATE("yyyy-MM-dd HH:mm:ss.SSS"),
    UPDATE_DATE("yyyy-MM-dd HH:mm:ss.SSS");

    private final String format;

    DataFormat(String format) {
        this.format = format;
    }
}
