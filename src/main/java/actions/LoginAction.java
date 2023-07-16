package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(!password.equals("a")) { // 認証失敗:とりあえず
			return "login.jsp";
		} else {
			session.setAttribute("user", "user"); // とりあえず
			String status = (String)session.getAttribute("status");
			if(status != null && status.equals("error")) {
				session.setAttribute("status", "login");
				return ((String)session.getAttribute("targetURI")).substring(16);
			} else {
				session.setAttribute("targetURI", "/ServletSNS/jsp/home.jsp");
				return "home.jsp";
			}
		}
	}
}
