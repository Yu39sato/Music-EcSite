package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.daos.LoginDao;

@WebServlet(urlPatterns = { "/servlet/loginAction" })
public class LoginAction extends HttpServlet {
	
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		request.getRequestDispatcher("../jsp/login.jsp").forward(request, response);
	}
	

	public void doPost(
			HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String url = "../jsp/login.jsp";
		LoginBean login = new LoginBean();

		if (request.getParameter("id") == null || request.getParameter("id").length() == 0 ||
				request.getParameter("password") == null || request.getParameter("password").length() == 0) {

			login.setError("無効です");

		} else {

			try {
				LoginDao dao = new LoginDao();

				int id = Integer.parseInt(request.getParameter("id"));
				String password = request.getParameter("password");

				login = dao.getLogin(id, password);
				if (login != null) {
					if(id == 0001) {
						url="../jsp/admin/AdominTop.jsp";
						
					}else {
						url = "../jsp/user/UserTopCategory.jsp";
					}
					
					HttpSession session=request.getSession();
					
					session.setAttribute("login", login);
				
				
				} else {
					login = new LoginBean();
					login.setId(id);
					login.setPassword(password);
					login.setError("IDまたはパスワードが違います。");
				}
				
				

				

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		request.setAttribute("login", login);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
