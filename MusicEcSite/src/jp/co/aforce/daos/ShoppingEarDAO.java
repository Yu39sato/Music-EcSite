package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.aforce.beans.ShoppingEar;

public class ShoppingEarDAO extends DAO{
	public int insert(ShoppingEar shoppingEar) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into item values(?,?,?,?)"
				);
		st.setInt(1,shoppingEar.getId());
		st.setString(2, shoppingEar.getItemName());
		st.setInt(3, shoppingEar.getPrice());
		st.setInt(4, shoppingEar.getCategoryId());
		
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
		}
	public ArrayList<ShoppingEar> getEarphone(){
		ArrayList<ShoppingEar> listEarphone=new ArrayList<>();
		try {
		Connection cons=getConnection();
		
		PreparedStatement str=cons.prepareStatement(
				"select * from item where categoryId=2");
		ResultSet rsr=str.executeQuery();
		
		int i=0;
		while(rsr.next()) {
			ShoppingEar spe=new ShoppingEar();
			spe.setId(rsr.getInt("id"));
			spe.setItemName(rsr.getString("itemName"));
			spe.setPrice(rsr.getInt("price"));
			spe.setCategoryId(rsr.getInt("categoryId"));
			listEarphone.add(spe);

		}
		str.close();
		cons.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listEarphone;
	}

}
