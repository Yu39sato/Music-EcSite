package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.tool.Page;

//@WebServlet(urlPatterns={"/jp.co.aforce.servlets/item"})
public class Item extends HttpServlet{
	public void doGet(
		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		Page.header(out);
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
				"java:/comp/env/jdbc/shoppingsite");
			Connection con = ds.getConnection();
			
			PreparedStatement st = con.prepareStatement(
				"select * from item");
			
			
			
			ResultSet rs = st.executeQuery();
			
			//st.setInt(1, 0001);
			
			
			ArrayList<ItemBean> list = new ArrayList<>();
			
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
			HttpSession session = request.getSession();
			
			session.setAttribute("list", list);
			
			request.getRequestDispatcher("../views/itemList.jsp")
					.forward(request, response); 
		}catch (Exception e) {
			e.printStackTrace(out);
		}
		
		
		Page.footer(out);
	}
}
