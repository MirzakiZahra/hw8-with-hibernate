package Model;

import DatabaseAccess.Database;
import Products.Product;

import java.sql.SQLException;
import java.util.*;

public class Customer {
    private int id;
    private String name;
    private int balance;
    private long telephone;
    Cart cart = new Cart();
    List<Product> productList = new ArrayList<Product>();


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

    public Customer(int id, String name, int balance, long telephone) {
        this.id = id;
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
                database.decrease("product",product.getId(),1);
            }
            this.cart.productList.clear();
        }
    }


}
