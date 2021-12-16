package Enums;

public enum MagazineType {
    INTERNAL("in"),FOREIGN("f");
    private String abbr;

    public String getAbbr() {
        return abbr;
    }

    MagazineType(String abbr) {
        this.abbr = abbr;
    }
}
