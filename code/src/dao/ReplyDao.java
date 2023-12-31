package dao;

import model.Reply;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDao {
    //新增回复
    public int addReply(Reply reply){
        Connection connection = DBUtils.getConnection();
        String sql = "insert into reply(name,content,time,mid) value(?,?,?,?)";
        PreparedStatement preparedStatement = null;
        int count=0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,reply.getName());
            preparedStatement.setString(2,reply.getContent());
            preparedStatement.setString(3,reply.getTime());
            preparedStatement.setInt(4,reply.getMid());
            count=preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return count;
        }

    }
    //查询所有回复
    public ArrayList<Reply> getAllReply(int mid){
        Connection connection = DBUtils.getConnection();
        ArrayList<Reply> list =new ArrayList<Reply>();
        String sql = "select * from reply where mid = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,mid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int rid = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");
                Reply reply = new Reply(rid,content,name,time,mid);
                list.add(reply);
            }
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.closeConnection(connection);
            return list;
        }
    }
    //更新回复数

}
