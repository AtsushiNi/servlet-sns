package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class EditProfileAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String selfDescription = request.getParameter("self-description");
		Part avatarImage = request.getPart("avatar");
		Part homeImage = request.getPart("home-image");

		System.out.println(avatarImage);
		
		return "profile.jsp";
	}
}
