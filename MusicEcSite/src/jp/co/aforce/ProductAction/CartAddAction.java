package jp.co.aforce.ProductAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.ShoppingHead;
import jp.co.aforce.daos.ShoppingHeadDAO;

public class CartAddAction extends Action{
	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		HttpSession session=request.getSession();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		List<Item> cart=(List<Item>)session.getAttribute("cart");
		if(cart==null) {
			cart=new ArrayList<Item>();
		}
		
	
		
		for(Item i:cart) {
			if(i.getShoppingHead().getId()==id) {
				i.setCount(i.getCount()+1);
				session.setAttribute("cart", cart);
				return "user/UserCart.jsp";
			}
		}

		ShoppingHeadDAO shoppingHeadDao=new ShoppingHeadDAO();
		ShoppingHead lineHead=shoppingHeadDao.select(id);
		if(lineHead==null) {
			return "user/UserCart.jsp";
		}

		Item i=new Item();
		i.setShoppingHead(lineHead);
		i.setCount(1);
		cart.add(i);

		session.setAttribute("cart", cart);
		return "user/UserCart.jsp";
	}

}
