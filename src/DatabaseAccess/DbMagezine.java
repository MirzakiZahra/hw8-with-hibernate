package DatabaseAccess;

import Products.Magazine;
import Products.Radio;

import java.sql.SQLException;
import java.sql.Statement;

public class DbMagezine  extends Database{
    public DbMagezine() throws SQLException, ClassNotFoundException {
    }
    public void add(Magazine magazine) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "insert into product (barcode,name,cost,count,feature, " +
                    "typeCover,language,publisher,type,periodPublish,magazineType, productType)values  " + "('" +
                    magazine.getId() + "','" +magazine.getName() + "','" + magazine.getCost() + "','" +
                    magazine.  getCount() + "','" +magazine.getFeature() + "','" + magazine.getTypeCover() + "','" +
                   magazine.getLanguage() + "','" + magazine.getPublisher() +"','" +magazine.getType()+ "'," +
                    "'" +magazine.getPeriodPublish()+ "','" +magazine.getMagazineType()+"','magezine')";
            statement.executeUpdate(sql);


        }
    }
}
