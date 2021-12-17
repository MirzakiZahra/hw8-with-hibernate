package Products;

import Model.Cart;
import Model.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int cost;
    private int count;
    private String feature;
    @ManyToMany(mappedBy = "productList")
    List<Cart> cartList = new ArrayList<>();
    @ManyToMany(mappedBy = "productList")
    List<Customer> customerList = new ArrayList<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Product(int id, String name, int cost, int count, String feature) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.feature = feature;
    }

    public Product() {
    }


}
