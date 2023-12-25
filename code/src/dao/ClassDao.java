package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.DBUtils;
import model.Class;

public class ClassDao {
	// 获取所有班级的信息，用ArrayList返回
	public ArrayList<Class> query_all_class() {
		Connection conn = DBUtils.getConnection();
		String sql = "select * from Class order by Clno;";
		ArrayList<Class> results = new ArrayList<Class>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Class temp = new Class();
				temp.setClno(rs.getString("Clno"));
				temp.setClname(rs.getString("Clname"));
				temp.setDno(rs.getString("Dno"));
				results.add(temp);
			}
			// 关闭资源
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return results;
	}
	// 插入班级信息，返回一个int值表示状态,1：成功，0失败
	public int insert_class(String clno, String clname, String dno) {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into Class values(?,?,?);";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, clno);
			ps.setString(2, clname);
			ps.setString(3, dno);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	// 删除班级信息，返回一个int值表示状态,1：成功，0失败
	public int delete_class(String clno) {
		Connection conn = DBUtils.getConnection();
		String sql = "delete from Class where Clno = ?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, clno);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	// 修改班级信息，返回一个int值表示状态,1：成功，0失败
	public int alter_class(String clno, String after_clno, String after_clname, String after_dno) {
		Connection conn = DBUtils.getConnection();
		String sql = "update Class set Clno = ?,Clname = ?,Dno = ? where Clno = ?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, after_clno);
			ps.setString(2, after_clname);
			ps.setString(3, after_dno);
			ps.setString(4, clno);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

}
