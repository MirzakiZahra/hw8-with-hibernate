package DatabaseAccess;

import Products.Book;
import Products.Magazine;

import java.sql.SQLException;
import java.sql.Statement;

public class DbBook  extends Database{
    public DbBook() throws SQLException, ClassNotFoundException {
    }
    public void add(Book book) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "insert into product (barcode,name,cost,count,feature, typeCover,language," +
                    "publisher,format,page,productType)values  " + "('" +
                    book.getId() + "','" +book.getName() + "','" + book.getCost() + "','" +
                    book.  getCount() + "','" +book.getFeature() + "','" + book.getTypeCover() + "','" +
                    book.getLanguage() + "','" + book.getPublisher() +"','" +book.getFormat()+ "'," +
                    "'" +book.getPage()+"','book')";
            statement.executeUpdate(sql);


        }
    }
}
