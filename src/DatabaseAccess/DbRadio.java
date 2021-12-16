package DatabaseAccess;

import Products.Radio;
import Products.Television;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbRadio  extends Database{

    public DbRadio() throws SQLException, ClassNotFoundException {
    }
    public void add(Radio radio) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "insert into product (barcode,name,cost,count,feature,brand,radioWave,sourceEnergyType,productType)values  " + "('" +
                    radio.getId() + "','" + radio.getName() + "','" + radio.getCost() + "','" +
                    radio.getCount() + "','" + radio.getFeature() + "','" + radio.getBrand() + "','" +
                    radio.getRadioWave() + "','" + radio.getSourceEnergyType() + "','radio')";
            statement.executeUpdate(sql);


        }
    }
}
