package jp.co.aforce.ProductAction;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.Tools.Action;
import jp.co.aforce.beans.ShoppingSpeaker;
import jp.co.aforce.daos.ShoppingSpeakerDAO;

@WebServlet()

public class SpeakerAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		ShoppingSpeakerDAO daoS=new ShoppingSpeakerDAO();
		
		List<ShoppingSpeaker> speakers=daoS.getSpeaker();
		request.setAttribute("speakers",speakers);
		return "user/UserSpeaker.jsp";
	}

}
