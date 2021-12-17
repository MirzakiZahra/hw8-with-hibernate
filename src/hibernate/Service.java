package hibernate;

import DatabaseAccess.DbOrder;
import Model.Cart;
import Model.Customer;
import Products.*;
import Products.Book;
import Products.Magazine;
import Products.Radio;
import Products.Shoes;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Service {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    DbOrder dbOrder;

    {
        try {
            dbOrder = new DbOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Service() {
    }

    public void increaseWithHibernate(int barcode, int number) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select count from product where barcode= :barcode";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Products.Product.class);
        query.setParameter("barcode", barcode);
        Product product = (Product) query.list().get(0);
        int temp = product.getCount() + number;
        product.setCount(temp);
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void decreaseWithHibernate(int barcode, int number) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select count from product where barcode= :barcode";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Products.Product.class);
        query.setParameter("barcode", barcode);
        Product product = (Product) query.list().get(0);
        int temp = product.getCount() - number;
        product.setCount(temp);
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void ShowProduct() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from product";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Products.Product.class);
        List<Product> products = query.list();
        products.stream().forEach(i -> System.out.println(i));
    }

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void addMagezine(Magazine magazine) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(magazine);
        transaction.commit();
        session.close();

    }

    public void addRadio(Radio radio) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(radio);
        transaction.commit();
        session.close();
    }

    public void addShoes(Shoes shoes) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(shoes);
        transaction.commit();
        session.close();


    }

    public void addTv(Television television) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(television);
        transaction.commit();
        session.close();
    }

    public void addCartWithHibernate( int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.load(Customer.class,id);
      /*  String sql = "select * from customer where personalId= :personalId";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Cart.class);
        query.setParameter("personalId", personaId);
        Customer customer = (Customer) query.list().get(0);*/
        Cart cart=new Cart();
        //cart.setCustomer(customer);
        session.save(cart);
        transaction.commit();
        session.close();


    }

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }
    public int findCustomerWithHibernate(int personalId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from customer where personalId= :personalId";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        query.setParameter("personalId", personalId);
        int output= query.list().size();
        transaction.commit();
        session.close();
        return output;

    }
    public void addProductToOrder(Customer customer) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        addCartWithHibernate(customer.getId());
        for (Product product : customer.getCart().getProductList()) {
            dbOrder.addOrder(product.getId());
        }
        transaction.commit();
        session.close();
    }
}
