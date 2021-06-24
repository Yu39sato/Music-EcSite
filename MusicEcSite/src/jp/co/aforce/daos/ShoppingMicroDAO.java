package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.aforce.beans.ShoppingMicro;

public class ShoppingMicroDAO extends DAO{
	public int insert(ShoppingMicro shoppingMicro) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into item values(?,?,?,?)"
				);
		st.setInt(1,shoppingMicro.getId());
		st.setString(2, shoppingMicro.getItemName());
		st.setInt(3, shoppingMicro.getPrice());
		st.setInt(4, shoppingMicro.getCategoryId());
		
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
		}
	public ArrayList<ShoppingMicro> getMicrophone(){
		ArrayList<ShoppingMicro> listMicrophone=new ArrayList<>();
		try {
		Connection cons=getConnection();
		
		PreparedStatement str=cons.prepareStatement(
				"select * from item where categoryId=3");
		ResultSet rsr=str.executeQuery();
		
		int i=0;
		while(rsr.next()) {
			ShoppingMicro spm=new ShoppingMicro();
			spm.setId(rsr.getInt("id"));
			spm.setItemName(rsr.getString("itemName"));
			spm.setPrice(rsr.getInt("price"));
			spm.setCategoryId(rsr.getInt("categoryId"));
			listMicrophone.add(spm);

		}
		str.close();
		cons.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listMicrophone;
	}


}
