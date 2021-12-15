package Model;

import DatabaseAccess.Database;
import Enums.MagazineType;
import Enums.SourceEnergyType;
import Products.*;
import Exception.NotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Store {
    List<Product> product = new ArrayList<Product>();
    List<Customer> customers = new ArrayList<Customer>();

    public List<Product> getProduct() {
        return product;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void decreaseCount(int id, int numberSale) {
        int counter=0;
        for (Product product : product) {
            if (product.getId() == id) {
                if (product.getCount() >= numberSale) {
                    int temp = product.getCount() - numberSale;
                    product.setCount(temp);
                    counter++;
                }
            }
        }
        if (counter == 0){
            throw new NotFoundException("Product Not Found");
        }


    }
    public void increaseCount(int id,int numberProduct){
        int counter=0;
        for (Product product: product){
            if (product.getId()==id){
               int temp= product.getCount()+numberProduct;
               product.setCount(temp);
               counter++;
            }
        }
        if (counter == 0){
            throw new NotFoundException("Product Not Found");
        }
    }
    public void addTv(int id, String name, int cost, int count, String feature, String brand, int inch, String quality){
        Television television=new Television(id,name,cost,count,feature,brand,inch,quality);
        product.add(television);

    }
    public void addRadio(int id, String name, int cost, int count, String feature, String brand, String radioWave, String sourceEnergyType){
        if (sourceEnergyType.equalsIgnoreCase(SourceEnergyType.BATTERY.getAbbr())){
            Radio radio=new Radio(id,name,cost,count,feature,brand,radioWave,SourceEnergyType.BATTERY);
            product.add(radio);
        }
        else if (sourceEnergyType.equalsIgnoreCase(SourceEnergyType.ELECTRIC.getAbbr())){
            Radio radio=new Radio(id,name,cost,count,feature,brand,radioWave,SourceEnergyType.ELECTRIC);
            product.add(radio);
        }
        else if (sourceEnergyType.equalsIgnoreCase(SourceEnergyType.HIBRID.getAbbr())){
            Radio radio=new Radio(id,name,cost,count,feature,brand,radioWave,SourceEnergyType.HIBRID);
            product.add(radio);
        }

    }
    public void addShoes(int id, String name, int cost, int count, String feature, int size, String material){
        Shoes shoes=new Shoes(id,name,cost,count,feature,size,material);
        product.add(shoes);

    }
    public void addBook(int id, String name, int cost, int count, String feature, String typeCover, String language, String publisher, String format, int page){
        Book book=new Book(id,name,cost,count,feature,typeCover,language,publisher,format,page);
        product.add(book);

    }

    public void addMagezine(int id, String name, int cost, int count, String feature, String typeCover, String language, String publisher, String type, String periodPublish, String magazineType){
        if (magazineType.equalsIgnoreCase(MagazineType.FOREIGN.getAbbr())){

            Magazine magazine=new Magazine(id,name,cost,count,feature,typeCover,language,publisher,type,periodPublish,MagazineType.FOREIGN);
            product.add(magazine);
        }
         else  if (magazineType.equalsIgnoreCase(MagazineType.INTERNAL.getAbbr())){

            Magazine magazine=new Magazine(id,name,cost,count,feature,typeCover,language,publisher,type,periodPublish,MagazineType.INTERNAL);
            product.add(magazine);
        }


    }
    public Product findProduct(int id){
        int counter=0;
        for (Product product: product){
            if (product.getId()== id){
                counter++;
                return product;
            }
        }
        if (counter == 0){
            throw new NotFoundException("Product Not Found");
        }
        return null;
    }
    public Customer findCustomer(int personalId){
        for (Customer customer: customers){
            if (customer.getId() == personalId){
                return customer;
            }
        }
        return null;
    }
    public void getDateFromServer() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "54321");
        Statement statement = connection.createStatement();
        Database database = new Database();
        String sql ="select * from product";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Product products = new Product();
            products.setCount(resultSet.getInt("count"));
            products.setId(resultSet.getInt("barcode"));
            products.setCost(resultSet.getInt("cost"));
            products.setName(resultSet.getString("name"));
            product.add(products);
        }
    }
    public void getCustomerDataFromServer() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "54321");
        Statement statement = connection.createStatement();
        Database database = new Database();
        String sql ="select * from customer";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Customer customer = new Customer();
            customer.setBalance(resultSet.getInt("balance"));
            customer.setId(resultSet.getInt("personalId"));
            customer.setTelephone(resultSet.getInt("telephone"));
            customer.setName(resultSet.getString("name"));
            customers.add(customer);
        }
    }

}
