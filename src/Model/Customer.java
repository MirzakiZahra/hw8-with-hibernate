package Model;

import DatabaseAccess.Database;
import Products.Product;
import hibernate.Service;


import javax.persistence.*;
import java.sql.SQLException;
import java.util.*;
@Entity
public class Customer {
    @Transient
    Service service = new Service();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    int personalId;
    private String name;
    private int balance;
    private long telephone;
    @OneToOne(cascade = CascadeType.ALL)
    Model.Cart cart = new Model.Cart();
    @ManyToMany
    List<Product> productList = new ArrayList<Product>();

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer(int personalId, String name, int balance, long telephone) {
        this.personalId = personalId;
        this.name = name;
        this.balance = balance;
        this.telephone = telephone;

    }

    public Customer() {
    }

    public void addProductToCart(int idProduct,Store store) {
        if (this.cart.productList.size() <= 5) {
            this.productList.add(store.findProduct(idProduct));
            this.cart.productList.add(store.findProduct(idProduct));
        }


    }

    public void deleteProductFromCart(int idProduct) {
        this.cart.productList.remove(this.findProductInCart(idProduct));

    }

    public Product findProductInCart(int id) {
        for (Product product : cart.productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;


    }

    public void showCart() {
        Set<Product> hashSet = new HashSet<>(this.cart.productList);
        for (Product product : this.cart.productList) {
            System.out.println(product.getName() + ": " +
                    Collections.frequency(this.cart.productList, product));
        }

    }

    public int showTotalCost() {
        int sum = 0;
        for (Product product : this.cart.productList) {
            sum = sum + product.getCost();
        }
        System.out.println("total cost is" + ":" + sum);
        return sum;
    }

    public void confirm( Database database) throws SQLException {
        if (this.getBalance() >= this.showTotalCost()) {
            int temp = this.getBalance() - this.showTotalCost();
            this.setBalance(temp);
            for (Product product : this.productList){
                service.decreaseWithHibernate(product.getId(),1);

            }
            this.cart.productList.clear();
        }
    }


}
