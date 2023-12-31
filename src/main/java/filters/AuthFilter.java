package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

@WebFilter(urlPatterns = {"/jsp/*", "/ajaxEndpoint/*"})
public class AuthFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String targetURI = httpRequest.getRequestURI();

		if(
			targetURI.equals("/ServletSNS/jsp/pages/login.jsp")
			|| targetURI.equals("/ServletSNS/jsp/pages/Login.action")
		) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = httpRequest.getSession();
		
		if(session == null) {
			session = httpRequest.getSession(true);
			session.setAttribute("targetURI", targetURI);
			session.setAttribute("status", "error");
			
			httpResponse.sendRedirect("login.jsp");
		} else {
			String userId = (String)session.getAttribute("userId");
			if(userId == null) {
				session.setAttribute("targetURI", targetURI);
				session.setAttribute("status", "error");
				
				httpResponse.sendRedirect("login.jsp");
			} else {
				UserDAO dao = new UserDAO();
				User currentUser = null;
				try {
					currentUser = dao.findById(userId);
				} catch(Exception e) {
					System.out.println(e);
				}
				
				request.setAttribute("currentUser", currentUser);
			}
		}
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}
