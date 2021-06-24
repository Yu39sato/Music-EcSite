package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.aforce.beans.ShoppingSpeaker;

public class ShoppingSpeakerDAO extends DAO{
	public int insert(ShoppingSpeaker shoppingSpeaker) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into item values(?,?,?,?)"
				);
		st.setInt(1,shoppingSpeaker.getId());
		st.setString(2, shoppingSpeaker.getItemName());
		st.setInt(3, shoppingSpeaker.getPrice());
		st.setInt(4, shoppingSpeaker.getCategoryId());
		
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
		}
	public ArrayList<ShoppingSpeaker> getSpeaker(){
		ArrayList<ShoppingSpeaker> listSpeaker=new ArrayList<>();
		try {
		Connection cons=getConnection();
		
		PreparedStatement str=cons.prepareStatement(
				"select * from item where categoryId=4");
		ResultSet rsr=str.executeQuery();
		
		int i=0;
		while(rsr.next()) {
			ShoppingSpeaker sps=new ShoppingSpeaker();
			sps.setId(rsr.getInt("id"));
			sps.setItemName(rsr.getString("itemName"));
			sps.setPrice(rsr.getInt("price"));
			sps.setCategoryId(rsr.getInt("categoryId"));
			listSpeaker.add(sps);

		}
		str.close();
		cons.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listSpeaker;
	}


}
