package dao;

import model.Message;
import model.News;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDao {
    public boolean messageIsExist(int mid) {
        Connection conn = DBUtils.getConnection();
        String sql = "select * from message where mid = ?";
        try{
            //获取PreparedStatement对象
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, mid);//给用户对象属性赋值
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //数据库中存在此用户
                return true;
            }
            //释放资源
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(conn);
        }
        return false;
    }
    //新增留言
    public int addMessage(Message m ){

        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into message values(?,?,?,?,?,0)";
        int count = 0;
        int mid = m.getMid()+1;
        while(messageIsExist(mid)){
            mid=mid+1;
        }
        m.setMid(mid);
        try{
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setInt(1,m.getMid());
            preparedStatement.setString(2,m.getTitle());
            preparedStatement.setString(3,m.getContent());
            preparedStatement.setString(4,m.getName());
            preparedStatement.setString(5,m.getTime());
            count = preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return count;
        }
    }


    //查询所有留言
    public ArrayList<Message> getAllMessage() {
        //创建集合建立数据库连接
        ArrayList<Message> list = new ArrayList<Message>();
        Connection connection = DBUtils.getConnection();
        //输入SQL语句获取数据
        String sql = "select * from message";
        //获取PreparedStatement对象
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            ps = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            //遍历结果集合，将数据添加到集合当中
            while (resultSet.next()) {
                int id = resultSet.getInt("mid");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");
                String name = resultSet.getString("name");
                int count = resultSet.getInt("count");
                Message message = new Message(id,title,content,name,time,count);
                list.add(message);
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

    //根据ID号查看留言
    public Message getMessageId(int id) {
        //数据库连接并编写SQL语句
        Connection connection = DBUtils.getConnection();
        String sql = "select * from message where mid=?";
        //新建News类对象存储数据
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Message message = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");
                String name = resultSet.getString("name");
                int count = resultSet.getInt("count");
                message = new Message(id, title, content, name, time, count);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connection);
            return message;
        }
    }

}
