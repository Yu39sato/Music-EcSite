package jp.co.aforce.ProductAction;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.ShoppingProduct;
import jp.co.aforce.daos.ShoppingProductDAO;

@WebServlet()

public class ProductAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		
		HttpSession session=request.getSession();
		//検索用アクション・一時的なコメントアウト
		String keyword=request.getParameter("keyword");
		if(keyword==null) keyword="";
//		
		ShoppingProductDAO dao=new ShoppingProductDAO();
		List<ShoppingProduct> list=dao.search(keyword);
		session.setAttribute("list", list);
		
		//一覧表示のアクション
		if(request.getParameter("listOfGoods").equals("listOfGoods")) {
			List<ShoppingProduct> items=dao.getItems();
			request.setAttribute("shoppingproduct",items);
		}
		
	

		
		return "admin/AdminListOfGoods.jsp";
	}

}
