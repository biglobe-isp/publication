package jp.co.biglobe.oss.publication.date;

import jp.co.biglobe.oss.publication.date.DateFormatter;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.time.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class DateFormatterTest {

    public static class format_yyyyMMddHHmmss {
        @Test
        public void _正常系() throws Exception {
            String actual = DateFormatter.format_yyyyMMddHHmmss(LocalDateTime.of(2014, 1, 2, 12, 34, 56));
            assertThat(actual, is("20140102123456"));
        }

        @Test(expected = NullPointerException.class)
        public void _null() throws Exception {
            DateFormatter.format_yyyyMMddHHmmss(null);
        }
    }

    public static class format_yyyyMMdd {
        @Test
        public void _正常系() throws Exception {
            String actual = DateFormatter.format_yyyyMMdd(LocalDate.of(2014, 1, 2));
            assertThat(actual, is("20140102"));
        }

        @Test(expected = NullPointerException.class)
        public void _null() throws Exception {
            DateFormatter.format_yyyyMMdd(null);
        }
    }


    public static class format_HHmmss {
        @Test
        public void _正常系() throws Exception {
            String actual = DateFormatter.format_HHmmss(LocalTime.of(12, 34, 56));
            assertThat(actual, is("123456"));
        }

        @Test(expected = NullPointerException.class)
        public void _null() throws Exception {
            DateFormatter.format_HHmmss(null);
        }
    }

    public static class format_yyyyMM {
        @Test
        public void _正常系() throws Exception {
            String actual = DateFormatter.format_yyyyMM(YearMonth.of(2014, 1));
            assertThat(actual, is("201401"));
        }

        @Test(expected = NullPointerException.class)
        public void _null() throws Exception {
            DateFormatter.format_yyyyMM(null);
        }
    }

    public static class format_MMdd {
        @Test
        public void _正常系() throws Exception {
            String actual = DateFormatter.format_MMdd(MonthDay.of(1, 2));
            assertThat(actual, is("0102"));
        }

        @Test(expected = NullPointerException.class)
        public void _null() throws Exception {
            DateFormatter.format_MMdd(null);
        }
    }
}
