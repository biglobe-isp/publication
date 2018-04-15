package jp.co.biglobe.lib.publication.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public final class DateFormatter {

    public static String format_yyyyMMddHHmmss(final LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DateDefaultPattern.yyyyMMddHHmmss.getValue()));
    }

    public static String format_yyyyMMdd(final LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(DateDefaultPattern.yyyyMMdd.getValue()));
    }

    public static String format_HHmmss(final LocalTime localTime) {
        return localTime.format(DateTimeFormatter.ofPattern(DateDefaultPattern.HHmmss.getValue()));
    }

    public static String format_yyyyMM(final YearMonth yearMonth) {
        return yearMonth.format(DateTimeFormatter.ofPattern(DateDefaultPattern.yyyyMM.getValue()));
    }

    public static String format_MMdd(final MonthDay monthDay) {
        return monthDay.format(DateTimeFormatter.ofPattern(DateDefaultPattern.MMdd.getValue()));
    }

    private DateFormatter() {
    }
}
