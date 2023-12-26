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
                String id=rs.getString(1);
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


    public Product getProductbyId(String id) {
        Product product=null;
        Connection con=DBUtils.getConnection();
        String sql="select * from product where id=?";
        PreparedStatement prest=null;
        ResultSet rs=null;
        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, id);
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
}
