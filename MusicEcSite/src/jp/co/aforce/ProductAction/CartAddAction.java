package jp.co.aforce.ProductAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.ShoppingHead;

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
			session.setAttribute("cart", cart);
		}
		
		for(Item i:cart) {
			if(i.getShoppingHead().getId()==id) {
				i.setCount(i.getCount()+1);
				return "cart.jsp";
			}
		}
//		ShoppingHeadDAO daos=new ShoppingHeadDAO();
//		List<ShoppingHead> listHeadphone=daos.search("");
		List<ShoppingHead> listHeadphone=(List<ShoppingHead>)session.getAttribute("listHeadphones");
		if(listHeadphone==null) {
			return "cart.jsp";
		}
		for(ShoppingHead sph:listHeadphone) {
			if(sph.getId()==id) {
				Item i=new Item();
				i.setShoppingHead(sph);
				i.setCount(1);
				cart.add(i);
			}
		}
		return "cart.jsp";
	}

}
