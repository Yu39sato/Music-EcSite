package jp.co.aforce.ProductAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.Item;
import jp.co.aforce.daos.PurchaseDAO;

public class PurchaseAction extends Action{
	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		HttpSession session=request.getSession();
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		if(name.isEmpty() || address.isEmpty()) {
			return "user/UserPurchase-error-empty.jsp";
		}
		
		PurchaseDAO dao=new PurchaseDAO();
		List<Item> cart=(List<Item>)session.getAttribute("cart");
		if(cart==null || !dao.insert(cart, name, address)) {
			return "user/UserPurchase-error-insert.jsp";
		}
		
		session.removeAttribute("cart");
		return "user/UserPurchase-out.jsp";
	}

}
