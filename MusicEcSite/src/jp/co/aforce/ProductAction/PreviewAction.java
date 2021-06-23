package jp.co.aforce.ProductAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.Item;

public class PreviewAction extends Action{
	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		HttpSession session=request.getSession();
		
	if(session.getAttribute("loginbean")==null) {
		return "UserPreview-error-login.jsp";
	}
	
	List<Item> cart=(List<Item>)session.getAttribute("cart");
	if(cart==null || cart.size()==0) {
		return "UserPrevier-error-cart.jsp";
	}
	
	return "UserPurchase-in.jsp";

}
}