package dao;
import model.*;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class NewsDao {
    //获取所有信息
    public ArrayList<News> getAllNews() {
        //创建集合建立数据库连接
        ArrayList<News> list = new ArrayList<News>();
        Connection connection = DBUtils.getConnection();
        //输入SQL语句获取数据
        String sql = "select * from news";
        //获取PreparedStatement对象
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            ps = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            //遍历结果集合，将数据添加到集合当中
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");
                News news = new News(id,title,content,time);
                list.add(news);
            }
            //释放资源
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return list;
        }
    }
    //通过id查新闻
    public News getNewsId(int id){
        //数据库连接并编写SQL语句
        Connection connection = DBUtils.getConnection();
        String sql = "select * from news where id=?";
        //新建News类对象存储数据
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        News news = null;
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");
               news = new News(id,title,content,time);
            }
            preparedStatement.close();
            resultSet.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return news;
        }
    }
}


