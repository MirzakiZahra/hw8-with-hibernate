package Enums;

public enum SourceEnergyType {
    BATTERY("b"),ELECTRIC("e"),HIBRID("h");
    private String abbr;

    public String getAbbr() {
        return abbr;
    }

    SourceEnergyType(String abbr) {
        this.abbr = abbr;
    }
}
