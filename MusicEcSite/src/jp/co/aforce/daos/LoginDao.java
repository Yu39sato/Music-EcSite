package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.LoginBean;

public class LoginDao extends DAO {
	
	public LoginBean getLogin(int id, String password) throws Exception {
	
	ResultSet rs = null;
	LoginBean loginbean = new LoginBean();
	
	Connection con = getConnection();
	String sql = "select * from login where id=? and password=?";
	
	PreparedStatement st = con.prepareStatement(sql);
	st.setInt(1, id);
	st.setString(2, password);
	rs = st.executeQuery();
	
	if (rs.next()) {
		loginbean.setId(rs.getInt("id"));
		loginbean.setPassword(rs.getString("password"));
		loginbean.setUserName(rs.getString("userName"));
	} else {
		return null;
	}
	st.close();
	con.close();
	return loginbean;
	
	}

}
