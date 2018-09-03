package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateCalculation {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");

    private DateCalculation() {
    }

    public static LocalDate calculateTheFirstOfTheMonth(LocalDate date) {

        date = LocalDate.parse(date.toString(), formatter);

        return LocalDate.of(date.getYear(), date.getMonth(), 1);
    }

}
