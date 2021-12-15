package Products;

import Enums.ShoesType;

public class Shoes extends Product {
    private int size;
    private String material;
    ShoesType shoesType ;

    public ShoesType getShoesType() {
        return shoesType;
    }

    public void setShoesType(ShoesType shoesType) {
        this.shoesType = shoesType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Shoes(int id, String name, int cost, int count, String feature, int size, String material) {
        super(id, name, cost, count, feature);
        this.size = size;
        this.material = material;
    }

    public Shoes(int size, String material) {
        this.size = size;
        this.material = material;
    }
    public Shoes(){

    }
}
