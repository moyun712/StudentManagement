package dao;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MssageDao {
    //��������
    public int insert_message(){
        int count;
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into message (mid,title,content,name,time,count) values(?,?,?,?,?,?)";

        preparedStatement = connection.prepareStatement();
    }


    //��ѯ��������

    //����ID�Ų鿴����

}
