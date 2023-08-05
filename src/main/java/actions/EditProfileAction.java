package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProfileAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "profile.jsp";
	}
}
