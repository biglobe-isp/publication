package jp.co.biglobe.lib.publication.date;

enum DateDefaultPattern {
    yyyyMMddHHmmss("uuuuMMddHHmmss"),
    yyyyMMdd("uuuuMMdd"),
    HHmmss("HHmmss"),
    yyyyMM("uuuuMM"),
    MMdd("MMdd");

    private final String value;

    private DateDefaultPattern(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
