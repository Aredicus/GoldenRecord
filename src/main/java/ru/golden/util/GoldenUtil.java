package ru.golden.util;

import ru.golden.enums.DataFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GoldenUtil {
    private static final String TG_REGEX = "^@[a-zA-Z0-9_]{5,32}$";
    private static final String EMAIL_REGEX = "^[\\w\\-._+]+@[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,10}$";
    private static final String PHONE_REGEX = "^\\+7[0-9]{10}$";
    private static final char ZERO = '0';

    private static final int[] INN_CONTROL_11 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] INN_CONTROL_12 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    public static LocalDateTime parseDate(String dateString, DataFormat format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getFormat());
        if (dateString == null || dateString.isBlank()) {
            return null;
        }
        try {
            var date = LocalDateTime.parse(dateString, formatter);
            return isCorrect(date) ? date : null;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean isInnCorrect(String clientInn) {
        try {
            char[] inn = clientInn.toCharArray();
            if (inn.length != 12) {
                return false;
            }
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 10; i++) {
                sum1 += (inn[i] - ZERO) * INN_CONTROL_11[i];
            }
            for (int i = 0; i < 11; i++) {
                sum2 += (inn[i] - ZERO) * INN_CONTROL_12[i];
            }
            sum1 = sum1 % 11 % 10;
            sum2 = sum2 % 11 % 10;
            if (sum1 == inn[10] - ZERO && sum2 == inn[11] - ZERO)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    private static boolean isCorrect(LocalDateTime date) {
        return date.isBefore(LocalDateTime.now()) && date.isAfter(LocalDateTime.now().minusYears(100));
    }

    public static boolean isSnilsCorrect(String clientSnils) {
        try {
            if (clientSnils.length() != 11) {
                return false;
            }
            char[] snils = clientSnils.toCharArray();
            int sum = 0;
            for (int i = 1; i <= 9; i++) {
                sum += snils[9 - i] * i;
            }
            sum = sum > 101 ? sum % 101 : sum;
            if (sum < 100) {
                char[] controlSum = Integer.toString(sum).toCharArray();
                boolean res = true;
                for (int i = 0; i < 2; i++) {
                    res = res && controlSum[i] == snils[9 + i];
                }
                return res;
            } else {
                return snils[9] == ZERO && snils[10] == ZERO;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isTgCorrect(String clientTg) {
        return clientTg.matches(TG_REGEX);
    }

    public static boolean isEmailCorrect(String clientEmail) {
        return clientEmail.matches(EMAIL_REGEX);
    }

    public static boolean isPhoneCorrect(String contactPhone) {
        return contactPhone.matches(PHONE_REGEX);
    }
}
