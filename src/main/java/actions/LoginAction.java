package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

public class LoginAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserDAO dao = new UserDAO();
		User user = dao.search(id, password);
		if(user == null) { // 認証失敗:とりあえず
			return "login.jsp";
		} else {
			session.setAttribute("currentUser", user); // とりあえず
			request.setAttribute("currentUser", user);
			String status = (String)session.getAttribute("status");
			if(status != null && status.equals("error")) {
				session.setAttribute("status", "login");
				return ((String)session.getAttribute("targetURI")).substring(16);
			} else {
				session.setAttribute("targetURI", "/ServletSNS/jsp/home.jsp");
				return "Home.action";
			}
		}
	}
}
