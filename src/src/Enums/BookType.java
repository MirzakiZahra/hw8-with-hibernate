package Enums;

public enum BookType {
    STORY("s"),ACADEMIC("a"),IMAGINARY("i");
    private String abbr;

    public String getAbbr() {
        return abbr;
    }

    BookType(String abbr) {
        this.abbr = abbr;
    }
}
