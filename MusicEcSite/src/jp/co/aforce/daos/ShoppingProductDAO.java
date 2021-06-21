package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ShoppingProduct;

public class ShoppingProductDAO extends DAO {
	
	public List<ShoppingProduct> search(String keyword) throws Exception{
	List<ShoppingProduct> list=new ArrayList<>();
	
	Connection con=getConnection();
	
	PreparedStatement st=con.prepareStatement(
			"select * from item where itemName like ?");
	st.setString(1, "%"+keyword+"%");
	ResultSet rs=st.executeQuery();
	
	while(rs.next()) {
		ShoppingProduct sp=new ShoppingProduct();
		sp.setId(rs.getInt("id"));
		sp.setItemName(rs.getString("itemName"));
		sp.setPrice(rs.getInt("price"));
		sp.setCategoryId(rs.getInt("categoryId"));
		list.add(sp);
	}
	st.close();
	con.close();
	
	return list;
}
	public int insert(ShoppingProduct shoppingproduct) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into item values(?,?,?,?)"
				);
		st.setInt(1,shoppingproduct.getId());
		st.setString(2, shoppingproduct.getItemName());
		st.setInt(3, shoppingproduct.getPrice());
		st.setInt(4, shoppingproduct.getCategoryId());
		
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
		}
	
	//商品一覧表示DAO
	public ArrayList<ShoppingProduct> getItems(){
		ArrayList<ShoppingProduct> list=new ArrayList<>();
		try {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from item");
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			ShoppingProduct sp=new ShoppingProduct();
			sp.setId(rs.getInt("id"));
			sp.setItemName(rs.getString("itemName"));
			sp.setPrice(rs.getInt("price"));
			sp.setCategoryId(rs.getInt("categoryId"));
			list.add(sp);
		}
		st.close();
		con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//商品一覧（ユーザ）
	public ArrayList<ShoppingProduct> getHeadphone(){
		ArrayList<ShoppingProduct> listHeadphone=new ArrayList<>();
		try {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from item where categoryId=1");
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			ShoppingProduct spr=new ShoppingProduct();
			spr.setId(rs.getInt("id"));
			spr.setItemName(rs.getString("itemName"));
			spr.setPrice(rs.getInt("price"));
			spr.setCategoryId(rs.getInt("categoryId"));
			listHeadphone.add(spr);
		}
		st.close();
		con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listHeadphone;
	}
}