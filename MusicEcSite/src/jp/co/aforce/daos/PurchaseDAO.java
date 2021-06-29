package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.ShoppingHead;

public class PurchaseDAO extends DAO{
	public boolean insert(
			List<Item> cart, String name, String address
			)throws Exception{
		Connection con=getConnection();
		con.setAutoCommit(false);
		
		for(Item item:cart) {
			PreparedStatement pst=con.prepareStatement(
					"insert into purchase values(null, ?,?,?,?,?,?)");
			ShoppingHead sh=item.getShoppingHead();
			pst.setInt(1, sh.getId());
			pst.setString(2, sh.getItemName());
			pst.setInt(3, sh.getPrice());
			pst.setInt(4, item.getCount());
			pst.setString(5, name);
			pst.setString(6,address);
			int line=pst.executeUpdate();
			pst.close();
			
			if(line!=1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				
				return false;
			}
			
		}
		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;
	
	}

}
