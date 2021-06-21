package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.ItemDAO;
import jp.co.aforce.beans.ItemBean;

public class DeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("../views/adnimistration.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String transitScreen = "../views/delete.jsp";
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		
		if(request.getParameter("buttonName").equals("削除")) {
			ItemBean itemBean = new ItemBean();
			ItemDAO itemDao = new ItemDAO();
			
			if(itemDao.delete(id)) {
				itemBean.setCompleteMsg("削除しました");
				request.setAttribute("itemBean", itemBean);
			}
		}
		
		request.getRequestDispatcher(transitScreen).forward(request, resonse);
		
	
	}
}
