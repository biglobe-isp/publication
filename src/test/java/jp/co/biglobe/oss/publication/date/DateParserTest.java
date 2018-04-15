package jp.co.biglobe.oss.publication.date;

import jp.co.biglobe.oss.publication.date.DateParser;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.time.*;
import java.time.format.DateTimeParseException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class DateParserTest {

    public static class parse_yyyyMMddHHmmss {

        @Test
        public void _正常系_存在する日時の場合() throws Exception {
            LocalDateTime actual = DateParser.parse_yyyyMMddHHmmss("20140102123456");
            assertThat(actual, is(LocalDateTime.of(2014, 1, 2, 12, 34, 56)));
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_存在しない日時の場合() throws Exception {
            DateParser.parse_yyyyMMddHHmmss("20140229123456");
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_不正な文字列の場合() throws Exception {
            DateParser.parse_yyyyMMddHHmmss("invalid");
        }

        @Test(expected = NullPointerException.class)
        public void _異常系_nullの場合() throws Exception {
            DateParser.parse_yyyyMMddHHmmss(null);
        }
    }

    public static class parse_yyyyMMdd {

        @Test
        public void _正常系_存在する日時の場合() throws Exception {
            LocalDate actual = DateParser.parse_yyyyMMdd("20140102");
            assertThat(actual, is(LocalDate.of(2014, 1, 2)));
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_存在しない日時の場合() throws Exception {
            DateParser.parse_yyyyMMdd("20140229");
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_不正な文字列の場合() throws Exception {
            DateParser.parse_yyyyMMdd("invalid");
        }

        @Test(expected = NullPointerException.class)
        public void _異常系_nullの場合() throws Exception {
            DateParser.parse_yyyyMMdd(null);
        }
    }

    public static class parse_HHmmss {

        @Test
        public void _正常系_存在する日時の場合() throws Exception {
            LocalTime actual = DateParser.parse_HHmmss("123456");
            assertThat(actual, is(LocalTime.of(12, 34, 56)));
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_存在しない日時の場合() throws Exception {
            DateParser.parse_HHmmss("253456");
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_不正な文字列の場合() throws Exception {
            DateParser.parse_HHmmss("invalid");
        }

        @Test(expected = NullPointerException.class)
        public void _異常系_nullの場合() throws Exception {
            DateParser.parse_HHmmss(null);
        }
    }

    public static class parse_yyyyMM {

        @Test
        public void _正常系_存在する日時の場合() throws Exception {
            YearMonth actual = DateParser.parse_yyyyMM("201401");
            assertThat(actual, is(YearMonth.of(2014, 1)));
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_存在しない日時の場合() throws Exception {
            DateParser.parse_yyyyMM("201413");
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_不正な文字列の場合() throws Exception {
            DateParser.parse_yyyyMM("invalid");
        }

        @Test(expected = NullPointerException.class)
        public void _異常系_nullの場合() throws Exception {
            DateParser.parse_yyyyMM(null);
        }
    }

    public static class parse_MMdd {

        @Test
        public void _正常系_存在する日時の場合() throws Exception {
            MonthDay actual = DateParser.parse_MMdd("0212");
            assertThat(actual, is(MonthDay.of(2, 12)));
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_存在しない日時の場合() throws Exception {
            DateParser.parse_MMdd("0132");
        }

        @Test(expected = DateTimeParseException.class)
        public void _異常系_不正な文字列の場合() throws Exception {
            DateParser.parse_MMdd("invalid");
        }

        @Test(expected = NullPointerException.class)
        public void _異常系_nullの場合() throws Exception {
            DateParser.parse_MMdd(null);
        }
    }
}
