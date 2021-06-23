package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jp.co.aforce.servlet/deleteOrChangeServlet")
public class DeleteOrChangeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("./jsp/admin/deleteOrChange.jsp").forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		String transitScreen = "./jsp/admin/deleteOrChange.jsp";
		
		
		if(request.getParameter("buttonName").equals("DeleteItem")) {
			transitScreen = "./jsp/admin/delete.jsp";
		} else if(request.getParameter("buttonName").equals("ChangeItem")) {
			transitScreen = "./jsp/admin/change.jsp";
		}
		
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}
}

