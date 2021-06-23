package jp.co.aforce.ProductAction;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.ShoppingHead;
import jp.co.aforce.daos.ShoppingHeadDAO;

@WebServlet()

public class HeadphoneAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		
//		HttpSession session=request.getSession();
		
//		String keyword=request.getParameter("keyword");
//		if(keyword==null) keyword="";
		
		ShoppingHeadDAO daos=new ShoppingHeadDAO();
//		List<ShoppingHead> listHeadphone=daos.search(keyword);
//		session.setAttribute("listHeadphones", listHeadphone);
		
		
//		if(request.getParameter("Headphone").equals("Headphone")){
			List<ShoppingHead> headphones=daos.getHeadphone();
			request.setAttribute("headphones",headphones);
//		}
		return "UserHeadphoneList.jsp";
	}

}