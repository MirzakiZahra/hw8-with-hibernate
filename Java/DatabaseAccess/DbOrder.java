package DatabaseAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbOrder  extends Database{
    public DbOrder() throws SQLException, ClassNotFoundException {
    }
    public  void addOrder(int barcode) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select id from product where barcode ='"+barcode+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            int productId = 0;
            while (resultSet.next()) {
                productId = resultSet.getInt(1);
            }
            sql = "select max(id) from cart ";
            resultSet = statement.executeQuery(sql);
            int cartId = 0;
            while (resultSet.next()) {
                cartId = resultSet.getInt(1);
            }
            sql = "select count(idCart) from orders where id= '"+cartId+"'";
            resultSet = statement.executeQuery(sql);
            int number = 0;
            while (resultSet.next()) {
                number = resultSet.getInt(1);
            }
            if (number <= 5) {
                sql = "insert  into orders (idCart,productId) values ('" + cartId + "','" + productId + "')";
                statement.executeUpdate(sql);


            }
            else {
                System.out.println("your cart is full");
            }
        }
    }


}
