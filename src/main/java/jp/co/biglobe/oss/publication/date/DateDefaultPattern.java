package jp.co.biglobe.oss.publication.date;

enum DateDefaultPattern {
    yyyyMMddHHmmss("uuuuMMddHHmmss"),
    yyyyMMdd("uuuuMMdd"),
    HHmmss("HHmmss"),
    yyyyMM("uuuuMM"),
    MMdd("MMdd"),
    SEPARATED_yyyyMMddHHmmss("uuuu/MM/dd HH:mm:ss"),
    ;

    private final String value;

    private DateDefaultPattern(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
