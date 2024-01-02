package dao;
import utils.DBUtils;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class ProductDao {
    public ArrayList<Product> getAllProducts(){
        ArrayList<Product>list=new ArrayList<Product>();
        Connection con= DBUtils.getConnection();
        String sql="select*from product ";
        PreparedStatement prest=null;
        ResultSet rs=null;

        try {
            prest=con.prepareStatement(sql);
            rs=prest.executeQuery();
            while(rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString("name");
                String type=rs.getString("type");
                int price=rs.getInt("price");
                String brand=rs.getString("brand");
                String content=rs.getString("content");
                String picture=rs.getString("picture");
                Product product=new Product(id,name,brand,type,price,content,picture);
                list.add(product);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtils.closeConnection(con);
        return list;
    }


    public Product getProductbyId(int id) {
        Product product=null;
        Connection con=DBUtils.getConnection();
        String sql="select * from product where id=?";
        PreparedStatement prest=null;
        ResultSet rs=null;
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(1, id);
            rs = prest.executeQuery();
            if(rs.next()) {
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String picture = rs.getString("picture");
                String content=rs.getString("content");

                product=new Product(id, name, brand,  type,  price, content, picture);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtils.closeConnection(con);
        return product;
    }

    public int addProduct(Product p){
        int count=0;
        Connection con=DBUtils.getConnection();
        PreparedStatement prest=null;
        String sq1="insert into product values(?,?,?,?,?,?,?)";
        try {
            prest = con. prepareStatement(sq1);
            prest. setInt(1, p.getId());
            prest. setString(2,p. getName());
            prest.setString(3,p.getBrand());
            prest.setString(4, p.getType());
            prest. setInt(5, p.getPrice());
            prest.setString(6, p.getContent());
            prest. setString(7, p. getPicture());
            count=prest.executeUpdate();
        } catch (SQLException e) {
    // TODO Auto- generated catch block
            e.printStackTrace();
        }
        finally {
            DBUtils.closeConnection(con);
            return count;
        }
    }
    //ÐÞ¸Ä
    public int updateProduct(Product product){
        int count = 0;
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update product set name = ?,brand = ?,type = ?,price = ?,content = ?,picture=? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getBrand());
            preparedStatement.setString(3,product.getType());
            preparedStatement.setInt(4,product.getPrice());
            preparedStatement.setString(5,product.getContent());
            preparedStatement.setString(6,product.getPicture());
            preparedStatement.setInt(7,product.getId());
            count=preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return count;
        }
    }
    //É¾³ý
    public int deleteProduct(int id){
        int count = 0;
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from product where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            count=preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return count;
        }
    }
}
