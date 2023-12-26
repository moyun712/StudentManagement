package dao;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MssageDao {
    //新增留言
    public int insert_message(){
        int count;
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into message (mid,title,content,name,time,count) values(?,?,?,?,?,?)";

        preparedStatement = connection.prepareStatement();
    }


    //查询所有留言

    //根据ID号查看留言

}
