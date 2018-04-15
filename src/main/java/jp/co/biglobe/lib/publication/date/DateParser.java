package jp.co.biglobe.lib.publication.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public final class DateParser {

    public static LocalDateTime parse_yyyyMMddHHmmss(final String value) {
        return LocalDateTime.parse(value, createFormatter(DateDefaultPattern.yyyyMMddHHmmss));
    }

    public static LocalDate parse_yyyyMMdd(final String value) {
        return LocalDate.parse(value, createFormatter(DateDefaultPattern.yyyyMMdd));
    }

    public static LocalTime parse_HHmmss(final String value) {
        return LocalTime.parse(value, createFormatter(DateDefaultPattern.HHmmss));
    }

    public static YearMonth parse_yyyyMM(final String value) {
        return YearMonth.parse(value, createFormatter(DateDefaultPattern.yyyyMM));
    }

    public static MonthDay parse_MMdd(final String value) {
        return MonthDay.parse(value, createFormatter(DateDefaultPattern.MMdd));
    }

    /**
     * フォーマッターを作成
     * <p>
     * 存在しない日付に対し、フォーマットをかけようとすると、例外をスローするように指定
     * 参考）http://matsumana.info/blog/2014/06/17/jsr310-parse-from-string/
     */
    private static DateTimeFormatter createFormatter(final DateDefaultPattern dateDefaultPattern) {
        return DateTimeFormatter.ofPattern(dateDefaultPattern.getValue()).withResolverStyle(ResolverStyle.STRICT);
    }

    private DateParser() {
    }
}
