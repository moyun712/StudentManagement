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
            //��ȡPreparedStatement����
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, mid);//���û��������Ը�ֵ
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //���ݿ��д��ڴ��û�
                return true;
            }
            //�ͷ���Դ
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(conn);
        }
        return false;
    }
    //��������
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


    //��ѯ��������
    public ArrayList<Message> getAllMessage() {
        //�������Ͻ������ݿ�����
        ArrayList<Message> list = new ArrayList<Message>();
        Connection connection = DBUtils.getConnection();
        //����SQL����ȡ����
        String sql = "select * from message";
        //��ȡPreparedStatement����
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            ps = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            //����������ϣ���������ӵ����ϵ���
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
            //�ͷ���Դ
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return list;
        }
    }

    //����ID�Ų鿴����
    public Message getMessageId(int id) {
        //���ݿ����Ӳ���дSQL���
        Connection connection = DBUtils.getConnection();
        String sql = "select * from message where mid=?";
        //�½�News�����洢����
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
