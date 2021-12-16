package DatabaseAccess;

import Products.Radio;
import Products.Shoes;

import java.sql.SQLException;
import java.sql.Statement;

public class DbShoes  extends Database{

    public DbShoes() throws SQLException, ClassNotFoundException {
    }
    public void add(Shoes shoes) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "insert into product (barcode,name,cost,count,feature,size,material,shoesType,productType)values  " + "('" +
                    shoes.getId() + "','" + shoes.getName() + "','" + shoes.getCost() + "','" +
                    shoes.getCount() + "','" + shoes.getFeature() + "','" + shoes.getSize() + "','" +
                    shoes.getMaterial() +  "','"+ shoes.getShoesType()+"', 'shoes')";
            statement.executeUpdate(sql);


        }
    }
}
