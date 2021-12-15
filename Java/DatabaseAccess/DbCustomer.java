package DatabaseAccess;

import Model.Cart;
import Model.Customer;
import Products.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbCustomer extends Database {
    DbCart dbCart = new DbCart();
    DbOrder dbOrder = new DbOrder();

    public DbCustomer() throws SQLException, ClassNotFoundException {
    }

    public void addCustomer(Customer customer) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "insert into customer(name,personalId,balance,telephone) values" +
                    "( '" + customer.getName() + "','" + customer.getId() + "','" + customer.getBalance() + "'," +
                    "'" + customer.getTelephone() + "')";
            statement.executeUpdate(sql);

        }

    }

    public void addProductToOrder(Customer customer) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            dbCart.addCart(customer.getId());
            for (Product product : customer.getCart().getProductList()) {
                dbOrder.addOrder(product.getId());
            }
        }
    }

    public void deleteProduct(int barcode, int personalId) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select id from product where barcode ='" + barcode + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            int productId = 0;
            while (resultSet.next()) {
                productId = resultSet.getInt(1);
            }
            sql="select id from customer where personalId='"+personalId+"'";
            resultSet=statement.executeQuery(sql);
            int customerId=0;
            while (resultSet.next()){
                customerId=resultSet.getInt(1);
            }
            sql = "select max(id) from cart where customerId='" + customerId + "'  ";
            resultSet = statement.executeQuery(sql);
            int cartId = 0;
            while (resultSet.next()) {
                cartId = resultSet.getInt(1);
            }
            sql = "delete from orders where productId='" + productId + "' and idCart='" + cartId + "'";
            int indicator = statement.executeUpdate(sql);
            if (indicator == 0) {
                System.out.println("not found");
            }
            else {
                System.out.println("successfuly deleted");
            }

        }
    }
    public int findCustomer(int personalId) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql="select id from customer where personalId='"+personalId+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            int indicator=0;
            while (resultSet.next()){
            indicator++;
            }
            if (indicator==0){
                return 0;
            }
            else {
                return indicator;
            }
        }
        return 0;

    }
}
