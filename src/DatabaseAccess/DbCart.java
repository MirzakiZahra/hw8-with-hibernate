package DatabaseAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCart  extends Database{
    public DbCart() throws SQLException, ClassNotFoundException {
    }
    public  void addCart(int personalId) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select id from customer where personalId= '"+personalId+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            int idCustomer=0;
            while (resultSet.next()){
                idCustomer=resultSet.getInt(1);
            }
            sql="insert into cart (customerId) values ('"+idCustomer+"')";
            statement.executeUpdate(sql);
        }


        }
    }