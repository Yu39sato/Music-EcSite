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
		Connection cons=getConnection();
		
		PreparedStatement str=cons.prepareStatement(
				"select * from item where categoryId=1");
		ResultSet rsr=str.executeQuery();
		
		int i=0;
		while(rsr.next()) {
			i++;
			ShoppingProduct spr=new ShoppingProduct();
			spr.setId(rsr.getInt("id"));
			spr.setItemName(rsr.getString("itemName"));
			spr.setPrice(rsr.getInt("price"));
			spr.setCategoryId(rsr.getInt("categoryId"));
			listHeadphone.add(spr);
			if(i==7) {
				break;
			}
		}
		str.close();
		cons.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listHeadphone;
	}
	
	//詳細ページ
//	public ArrayList<ShoppingProduct> getDetail(){
//		ArrayList<ShoppingProduct> listDetail=new ArrayList<>();
//		try {
//		Connection conDetail=getConnection();
//		
//		PreparedStatement stDetail=conDetail.prepareStatement(
//				"select * from item where id=?");
//		ResultSet rsDetail=stDetail.executeQuery();
//		
//		
//			ShoppingProduct spDetail=new ShoppingProduct();
//			spDetail.setId(rsDetail.getInt("id"));
//			spDetail.setItemName(rsDetail.getString("itemName"));
//			spDetail.setPrice(rsDetail.getInt("price"));
//			spDetail.setCategoryId(rsDetail.getInt("categoryId"));
//			listDetail.add(spDetail);
//		
//		stDetail.close();
//		conDetail.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return listDetail;
//	}
	
	public ShoppingProduct selectById(String id) {
		Connection con=null;
		java.sql.Statement smt=null;
		
		ShoppingProduct shoppingproduct=new ShoppingProduct();
		
		String sql="select* from item where id='"+id+"'";
		try {
			con=getConnection();
			smt=con.createStatement();
			ResultSet rsDetail=smt.executeQuery(sql);
			
			if(rsDetail.next()) {
				shoppingproduct.setId(rsDetail.getInt("id"));
				shoppingproduct.setItemName(rsDetail.getString("itemName"));
				shoppingproduct.setPrice(rsDetail.getInt("price"));	
			}
			con.close();
			smt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return shoppingproduct;
	}
}