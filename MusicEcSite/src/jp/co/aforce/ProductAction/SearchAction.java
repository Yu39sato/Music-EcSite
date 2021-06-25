package jp.co.aforce.ProductAction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.ShoppingProduct;
import jp.co.aforce.daos.ShoppingProductDAO;

@WebServlet()

public class SearchAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{

		HttpSession session=request.getSession();
		//検索用アクション
		String keyword=request.getParameter("keyword");
		if(keyword==null) keyword="";
//		
		ShoppingProductDAO dao=new ShoppingProductDAO();
		
		ShoppingProduct list=dao.search(keyword);
//
		session.setAttribute("list", list);
		
		
		return "user/UserSearch.jsp";
	}

}
