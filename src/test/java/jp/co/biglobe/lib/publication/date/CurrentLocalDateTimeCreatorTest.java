package jp.co.biglobe.lib.publication.date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class CurrentLocalDateTimeCreatorTest {

    @Before
    public void setup() {
        CurrentLocalDateTimeCreator.setSystemClock();
    }

    @After
    public void tearDown() {
        CurrentLocalDateTimeCreator.setSystemClock();
    }

    @Test
    public void all() throws Exception {
        // 実行：現時刻の取得
        LocalDateTime current = CurrentLocalDateTimeCreator.create();

        // 実行：過去の日付セット
        LocalDateTime fixed = LocalDateTime.of(2014, 1, 1, 0, 0, 0);
        Clock pastClock = Clock.fixed(ZonedDateTime.of(fixed, ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        CurrentLocalDateTimeCreator.setTestClock(pastClock);

        // 実行：セットした値を現時刻として取得
        LocalDateTime past = CurrentLocalDateTimeCreator.create();

        // 実行：現時刻をシステム日付にリセット
        CurrentLocalDateTimeCreator.setSystemClock();
        LocalDateTime reset = CurrentLocalDateTimeCreator.create();

        // 確認：セットした値と取得した現時刻が等しい
        assertThat(past, is(fixed));

        // 確認：システムの現時刻と、過去の日付をセットした現時刻の比較
        assertThat(current, is(greaterThan(past)));

        // 確認：リセットしたシステムの現時刻と、過去の日付をセットした現時刻の比較
        assertThat(reset, is(greaterThan(past)));

        // 確認：一回目と二回目に取得したシステム日付の比較
        assertThat(reset, is(greaterThanOrEqualTo(current)));
    }
}
