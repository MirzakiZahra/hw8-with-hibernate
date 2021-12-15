package src;

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

    public List<Products.Product> findProductWithBarcode(int barcode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from product where barcode= :barcode";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Products.Product.class);
        query.setParameter("barcode", barcode);
        List<Products.Product> list = query.list();
        session.close();
        return list;
    }

    public void increaseWithHibernate(int barcode, int number) {
        Products.Product product = (Products.Product) findProductWithBarcode(barcode);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        product = session.load(Products.Product.class, product.getId());
        int temp = product.getCount() + number;
        product.setCount(temp);
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void decreaseWithHibernate(int barcode, int number) {
        Products.Product product = (Products.Product) findProductWithBarcode(barcode);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        product = session.load(Products.Product.class, product.getId());
        int temp = product.getCount() - number;
        product.setCount(temp);
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void addBook(int barcode, String name, int cost, int count, String feature,
                        String typeCover, String language,
                        String publisher, String format, int page) {
        Products.Book book = new Book(barcode, name, cost,
                count, feature, typeCover, language, publisher, format, page);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();

    }

    public void addMagezine(int barcode, String name, int cost, int count, String feature,
                            String typeCover, String language,
                            String publisher, String type,
                            String periodPublish,
                            Enums.MagazineType magazineType) {
        Products.Magazine magazine = new Magazine(barcode, name, cost,
                count, feature, typeCover, language, publisher, type,
                periodPublish, magazineType);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(magazine);
        transaction.commit();
        session.close();

    }

    public void addRadio(int barcode, String name, int cost, int count, String feature,
                         String brand, String radioWave, Enums.SourceEnergyType sourceEnergyType
    ) {
        Products.Radio radio = new Radio(barcode, name, cost,
                count, feature, brand, radioWave, sourceEnergyType);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(radio);
        transaction.commit();
        session.close();


    }
    public void addShoes(int barcode, String name, int cost, int count, String feature,
                         int size, String material, Enums.ShoesType shoesType
                         ) {
      Products.Shoes shoes = new Shoes(barcode, name, cost,
                count, feature, size, material);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(shoes);
        transaction.commit();
        session.close();


    }
    public void addTv(int barcode, String name, int cost, int count, String feature,
                    String  brand, int inch, String quality
    ) {
      Products.Television television = new Products.Television(barcode, name, cost,
                count, feature, brand, inch,quality);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(television);
        transaction.commit();
        session.close();


    }
    public void addCartWithHibernate(){

    }
}
