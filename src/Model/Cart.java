package Model;

import Products.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    List<Product> productList = new ArrayList<Product>();





    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
