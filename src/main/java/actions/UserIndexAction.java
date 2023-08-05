package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class UserIndexAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User currentUser = (User)request.getAttribute("currentUser");
		
		UserDAO dao = new UserDAO();
		List<User> users = dao.getFollowers(currentUser.getId());
		request.setAttribute("users", users);
		
		return "userIndex.jsp";
	}
}
