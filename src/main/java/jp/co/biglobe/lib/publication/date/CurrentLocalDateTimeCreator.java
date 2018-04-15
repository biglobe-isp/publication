package jp.co.biglobe.lib.publication.date;

import java.time.Clock;
import java.time.LocalDateTime;

/**
 * 現時刻をLocalDateTime型で取得するためのクラス
 * <p>
 * テスト時に現時刻を差し替えられるようにするために本クラスを提供する。
 * アプリケーションコードで現時刻を取得したい場合、LocalDateTime.now()ではなく、
 * 本クラスを使用することで、テスタブルなコーディングを可能にする。
 */
public final class CurrentLocalDateTimeCreator {

    /**
     * 現在の時点の日時へのアクセスを提供するクロック
     * <p>
     * テストクラス一個だとvolatileなしでも問題ないが、全テスト走らせるとvolatileなしだとテストこける
     * joda-timeを参照したトコロ、同様の機構にvolatileをつけて実装しているので、同じように実装している
     * 参考：https://github.com/JodaOrg/joda-time/blob/master/src/main/java/org/joda/time/DateTimeUtils.java
     */
    private static volatile Clock clock;

    /**
     * 現時刻を生成する
     *
     * @return 現時刻
     */
    public static LocalDateTime create() {
        if (clock == null) {
            setSystemClock();
        }
        return LocalDateTime.now(clock);
    }

    /**
     * テスト用のクロックをセット
     * <p>
     * テストコードからのみ呼び出されることを想定している。
     */
    public static void setTestClock(Clock clock) {
        CurrentLocalDateTimeCreator.clock = clock;
    }

    /**
     * システムクロックをセット
     */
    public static void setSystemClock() {
        CurrentLocalDateTimeCreator.clock = Clock.systemDefaultZone();
    }

    /**
     * コンストラクタ：インスタンス化不可
     */
    private CurrentLocalDateTimeCreator() {
        throw new RuntimeException("CurrentLocalDateTimeはインスタンス化して使用不可");
    }
}
