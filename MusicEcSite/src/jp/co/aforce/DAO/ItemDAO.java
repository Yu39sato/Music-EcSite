package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import jp.co.aforce.beans.ItemBean;

public class ItemDAO extends DAO{
	
	public boolean check(ItemBean item) {
		if (item.getId() == 0 || item.getItemName().isEmpty() || item.getPrice() == 0 || item.getCategoryId() == 0) {
			return false;
		}
		return false;
	}
	
	/*
	public List<Item> selectItem() throws Exception{
		 List<Item> list = new ArrayList<>();
		 
		 Connection con = getConnection();
		 
		 PreparedStatement st = con.prepareStatement(
				"select * from product");
		 ResultSet rs = st.executeQuery();
		 
		 ItemDAO dao = new ItemDAO();
         // 現在の商品一覧を検索
         rs = dao.selectItem();
		 
		 while (rs.next()) {
			 int id = rs.getInt("id");
             
             String itemName = rs.getString("itemName");
            
             int price = rs.getInt("price");
            
             int categoryId = rs.getInt("categoryId");
		}
		 
		 st.close();
		 con.close();
			 
		 return list;
	}
	*/
	
	public ItemBean search(int keyword) {

		ItemBean item = new ItemBean();

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = getConnection();
			st = con.prepareStatement("select * from item where id = ?");
			st.setInt(1, keyword);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				item.setId(keyword);
				item.setItemName(rs.getString("itemName"));
				item.setPrice(rs.getInt("price"));
				item.setCategoryId(rs.getInt("categoryId"));
	
			} else {

				item = null;

			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}
	
	
	
	public boolean insert(ItemBean itemBean) {

		boolean result = false;
		Connection con = null;
		PreparedStatement st = null;

		try {

			con = getConnection();
			st = con.prepareStatement("insert into item values(?, ?, ?, ?)");

			
			Random rnd = new Random();
			
			int id  = rnd.nextInt(1-999);

			st.setInt(1, id);
			st.setString(2, itemBean.getItemName());
			st.setInt(3, Integer.valueOf(itemBean.getPrice()));
			st.setInt(4, Integer.valueOf(itemBean.getCategoryId()));
	

			int line = st.executeUpdate();

			if (line > 0) {
				result = true;
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public boolean update(ItemBean item) {

		boolean result = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = getConnection();
			st = con.prepareStatement(
					"update item set id = ?, itemName = ?, price = ?, categoryId = ? where id = ?");

			st.setInt(1, Integer.valueOf(item.getId()));
			st.setString(2, item.getItemName());
			st.setInt(3, Integer.valueOf(item.getPrice()));
			st.setInt(4, Integer.valueOf(item.getCategoryId()));
			st.setInt(5, Integer.valueOf(item.getId()));
			
			int line = st.executeUpdate();

			if (line > 0) {
				result = true;
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean delete(int id) {

		boolean result = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = getConnection();
			st = con.prepareStatement(
					"delete from item where id = ?");
			st.setInt(1, id);

			int line = st.executeUpdate();

			if (line > 0) {
				result = true;
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
}