package jp.co.aforce.ProductAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.Item;

public class CartRemoveAction extends Action{
	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request,HttpServletResponse response
			)throws Exception{
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		
		List<Item> cart=(List<Item>)session.getAttribute("cart");
		
		for(Item i:cart) {
			if(i.getShoppingHead().getId()==id) {
				cart.remove(i);
				break;
			}
		}
		return "user/UserCart.jsp";
	}

}
