package DatabaseAccess;

import Products.Product;

import java.sql.*;


public class Database {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "54321");

    public Database() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public void increase(String tabelName,int barcode, int number ) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            int temp = 0;
            String sql ="select count from product where barcode='"+barcode+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                temp=resultSet.getInt("count");
            }
            temp=temp+number;
            sql = "update product  set count='" + temp + "' where barcode='"+barcode+"'";
            statement.executeUpdate(sql);
        }
    }
    public void decrease(String tabelName, int barcode , int number ) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            int temp = 0;
            String sql ="select count from "+tabelName+" where barcode='"+barcode+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                temp=resultSet.getInt("count");
            }
            temp=temp -number;
            sql = "update " + tabelName + "  set count='" + temp + "' where barcode='"+barcode+"'";
            statement.executeUpdate(sql);
        }
    }
    public void showProduct(String type) throws SQLException {
        if (connection != null){
            Statement statement = connection.createStatement();
            String sql = "select * from product where productType='"+type+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("name:"+" "+resultSet.getString("name"));
                System.out.println("barcode:"+" "+resultSet.getInt("barcode"));
                System.out.println("cost:"+" "+resultSet.getInt("cost"));
                System.out.println("*************************");
            }
        }
    }


}




