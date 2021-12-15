package Enums;

public enum ShoesType {
    OFFICIAL("o"),SPORT("s");
    private String abbr;

    public String getAbbr() {
        return abbr;
    }

    ShoesType(String abbr) {
        this.abbr = abbr;
    }
}
