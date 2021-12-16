package Products;

import Products.Product;

public class Electronic  extends Product {
    private String brand;
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Electronic(int id, String name, int cost, int count, String feature, String brand) {
        super(id, name, cost, count, feature);
        this.brand = brand;
    }

    public Electronic(String brand) {
        this.brand = brand;
    }
    public Electronic(){

    }
}
