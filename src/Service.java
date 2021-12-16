import Model.Cart;
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

import java.util.Date;
import java.util.List;

public class Service {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

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

    public void addCartWithHibernate(int personaId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select id from customer where personalId= :personalId";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Cart.class);
        query.setParameter("personalId", personaId);
        Cart cart = (Cart) query.list().get(0);
        session.save(cart);
        transaction.commit();
        session.close();


    }

    public void addOrderWithHibernate() {

    }
}
