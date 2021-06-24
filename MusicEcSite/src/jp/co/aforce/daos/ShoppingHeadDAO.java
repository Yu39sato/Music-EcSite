package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ShoppingHead;

public class ShoppingHeadDAO extends DAO {
	
	public List<ShoppingHead> search(String keyword) throws Exception{
	List<ShoppingHead> list=new ArrayList<>();
	
	Connection con=getConnection();
	
	PreparedStatement st=con.prepareStatement(
			"select * from item where itemName like ?");
	st.setString(1, "%"+keyword+"%");
	ResultSet rs=st.executeQuery();
	
	while(rs.next()) {
		ShoppingHead sp=new ShoppingHead();
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
	public int insert(ShoppingHead shoppingHead) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into item values(?,?,?,?)"
				);
		st.setInt(1,shoppingHead.getId());
		st.setString(2, shoppingHead.getItemName());
		st.setInt(3, shoppingHead.getPrice());
		st.setInt(4, shoppingHead.getCategoryId());
		
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
		}
	

	//商品一覧（ユーザ）
	public ArrayList<ShoppingHead> getHeadphone(){
		ArrayList<ShoppingHead> listHeadphone=new ArrayList<>();
		try {
		Connection cons=getConnection();
		
		PreparedStatement str=cons.prepareStatement(
				"select * from item where categoryId=1");
		ResultSet rsr=str.executeQuery();
		
		int i=0;
		while(rsr.next()) {
//			i++;
			ShoppingHead spr=new ShoppingHead();
			spr.setId(rsr.getInt("id"));
			spr.setItemName(rsr.getString("itemName"));
			spr.setPrice(rsr.getInt("price"));
			spr.setCategoryId(rsr.getInt("categoryId"));
			listHeadphone.add(spr);
//			if(i==7) {
//				break;
//			}
		}
		str.close();
		cons.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listHeadphone;
	}
	

	
	public ShoppingHead selectById(String id) {
		Connection con=null;
		java.sql.Statement smt=null;
		
		ShoppingHead shoppingHead=new ShoppingHead();
		
		String sql="select* from item where id='"+id+"'";
		try {
			con=getConnection();
			smt=con.createStatement();
			ResultSet rsDetail=smt.executeQuery(sql);
			
			if(rsDetail.next()) {
				shoppingHead.setId(rsDetail.getInt("id"));
				shoppingHead.setItemName(rsDetail.getString("itemName"));
				shoppingHead.setPrice(rsDetail.getInt("price"));	
			}
			con.close();
			smt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return shoppingHead;
	}
	
	public ArrayList<ShoppingHead> getAdd(){
		ArrayList<ShoppingHead> listCartAdd=new ArrayList<>();
		try {
		Connection cons=getConnection();
		
		PreparedStatement str=cons.prepareStatement(
				"select * from item where categoryId=id");
		ResultSet rsr=str.executeQuery();
		
		
		while(rsr.next()) {
//			i++;
			ShoppingHead spr=new ShoppingHead();
			spr.setId(rsr.getInt("id"));
			spr.setItemName(rsr.getString("itemName"));
			spr.setPrice(rsr.getInt("price"));
			spr.setCategoryId(rsr.getInt("categoryId"));
			listCartAdd.add(spr);
//			if(i==7) {
//				break;
//			}
		}
		str.close();
		cons.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listCartAdd;
	}
	
}