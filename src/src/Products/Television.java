package Products;

public class Television extends Electronic {
    private int inch;
    private String quality;

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Television(int id, String name, int cost, int count, String feature, String brand, int inch, String quality) {
        super(id, name, cost, count, feature, brand);
        this.inch = inch;
        this.quality = quality;
    }

    public Television(String brand, int inch, String quality) {
        super(brand);
        this.inch = inch;
        this.quality = quality;
    }

    public Television(int inch, String quality) {
        this.inch = inch;
        this.quality = quality;
    }

    public Television(){}
}
