package DatabaseAccess;

import Products.Product;
import Products.Television;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTv extends Database {
    public DbTv() throws SQLException, ClassNotFoundException {

    }

    public void add(Television television) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "insert into product (barcode,name,cost,count,feature,brand,inch,quality,productTYPE)values  " + "('" +
                    television.getId() + "','" + television.getName() + "','" + television.getCost() + "','" +
                    television.getCount() + "','" + television.getFeature() + "','" + television.getBrand() + "','" +
                    television.getInch() + "','" + television.getQuality() + "','TV')";
            statement.executeUpdate(sql);


        }
    }
}
