package jp.co.aforce.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;

public class ItemDAO extends DAO{
	
	public boolean check(ItemBean item) {
		if (item.getId() == 0 || item.getItemName().isEmpty() || item.getPrice() == 0 || item.getCategoryId() == 0) {
			return false;
		}
		return true;
	}
	
	
	public List<ItemBean> search(String keyword)  throws Exception{
		List<ItemBean> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement st = null;


			con = getConnection();
			st = con.prepareStatement("select * from item where itemName like ?");
			st.setString(1, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ItemBean ib = new ItemBean();
				
				//ib.setId(keyword);
				ib.setId(rs.getInt("id"));
				ib.setItemName(rs.getString("itemName"));
				ib.setPrice(rs.getInt("price"));
				ib.setCategoryId(rs.getInt("categoryId"));
				list.add(ib);
			}
			
			st.close();
			con.close();

			return list;
	}
	
	public ItemBean searchId(int keyId) {

		ItemBean item = new ItemBean();

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = getConnection();
			st = con.prepareStatement("select * from item where id = ?");
			st.setInt(1, keyId);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				item.setId(keyId);
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
	
	
	public List<ItemBean> searchItem()  throws Exception{
		List<ItemBean> list = new ArrayList<>();
		
		try {
			
		Connection con = getConnection();
		PreparedStatement st = null;
		
			st = con.prepareStatement("select * from item");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ItemBean ib = new ItemBean();
				
				ib.setId(rs.getInt("id"));
				ib.setItemName(rs.getString("itemName"));
				ib.setPrice(rs.getInt("price"));
				ib.setCategoryId(rs.getInt("categoryId"));
				list.add(ib);
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return list;
	}
	
	
	
	public boolean insert(ItemBean itemBean) {

		boolean result = false;
		Connection con = null;
		PreparedStatement st = null;

		try {

			con = getConnection();
			st = con.prepareStatement("insert into item values(?, ?, ?, ?)");


			st.setInt(1, itemBean.getId());
			st.setString(2, itemBean.getItemName());
			st.setInt(3, itemBean.getPrice());
			st.setInt(4, itemBean.getCategoryId());
	

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