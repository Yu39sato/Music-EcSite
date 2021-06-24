package jp.co.aforce.ProductAction;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.ShoppingEar;
import jp.co.aforce.daos.ShoppingEarDAO;

@WebServlet()

public class EarphoneAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		ShoppingEarDAO daoE=new ShoppingEarDAO();
		
		List<ShoppingEar> earphones=daoE.getEarphone();
		request.setAttribute("earphones",earphones);
		return "user/UserEarphone.jsp";
	}

}
