package jp.co.aforce.ProductAction;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.ShoppingMicro;
import jp.co.aforce.daos.ShoppingMicroDAO;

@WebServlet()

public class MicrophoneAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		ShoppingMicroDAO daoM=new ShoppingMicroDAO();
		
		List<ShoppingMicro> microphones=daoM.getMicrophone();
		request.setAttribute("microphones",microphones);
		return "user/UserMicrophone.jsp";
	}

}
