package dao;
import model.*;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class NewsDao {
    //��ȡ������Ϣ
    public ArrayList<News> getAllNews() {
        //�������Ͻ������ݿ�����
        ArrayList<News> list = new ArrayList<News>();
        Connection connection = DBUtils.getConnection();
        //����SQL����ȡ����
        String sql = "select * from news";
        //��ȡPreparedStatement����
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            ps = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            //����������ϣ���������ӵ����ϵ���
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");
                News news = new News(id,title,content,time);
                list.add(news);
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
    //ͨ��id������
    public News getNewsId(int id){
        //���ݿ����Ӳ���дSQL���
        Connection connection = DBUtils.getConnection();
        String sql = "select * from news where id=?";
        //�½�News�����洢����
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
    //ͨ��idɾ��news
    public int deleteNews(int id){
        int count = 0;
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from news where id = ?";
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

    //�������
    public int addNews(News news){
        int count = 0;
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into news (title,content,time)values(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setString(3,news.getTime());
            count=preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(connection);
            return count;
        }
    }
    //ͨ��id�޸�news
    public int updateNews(News news){
        int count = 0;
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update news set title = ?,content = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,news.getTitle());
            preparedStatement.setString(2,news.getContent());
            preparedStatement.setInt(3,news.getId());
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


