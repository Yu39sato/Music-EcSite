package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.ItemDAO;
import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.tool.Page;

//@WebServlet("/jp.co.aforce.servlets/registServlet")
public class RegistServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		Page.header(out);
		
		String transitScreen = "../views/regist.jsp";
		
		String button = request.getParameter("buttonName");
		
		if(button.equals("")) {
			transitScreen = "../views/regist.jsp";
		} else {
		//	if (request.getParameter("buttonName")).equals(""戻る")){
			ItemBean itemBean = new ItemBean();
			itemBean.setItemName(request.getParameter("itemName"));
			itemBean.setPrice(Integer.parseInt(request.getParameter("price")));
			itemBean.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			
			ItemDAO itemDao = new ItemDAO();
			
			if(itemDao.check(itemBean)) {
				if (itemDao.insert(itemBean)) {
					itemBean.setCompleteMsg("登録しました");
					request.setAttribute("itemBean", itemBean);
				} else {
					itemBean.setErrorMsg("入力されていない項目があります");
					request.setAttribute("itemBean", itemBean);
				}
			} else {
				itemBean.setErrorMsg("入力されていない項目があります");
				request.setAttribute("itemBean", itemBean);
			}
		}
		
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}
}
