package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jp.co.aforce.servlet/administrationServlet")
public class AdministrationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("./jsp/admin/AdominTop.jsp").forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		String transitScreen = "./jsp/admin/AdominTop.jsp";
		
		/*
		if(request.getParameter("listOfGoods").equals("listOfGoods")) {
			transitScreen = "../jsp/ListOfGoods.jsp";
		} else */ 
		if(request.getParameter("buttonName").equals("Registration")) {
			transitScreen = "./jsp/admin/regist.jsp";
		} else if(request.getParameter("buttonName").equals("DeleteOrChange")) {
			transitScreen = "./jsp/admin/deleteOrChange.jsp";
		}
		
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}
	
	
}
