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

@WebFilter(urlPatterns = {"/jsp/*"})
public class AuthFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String targetURI = ((HttpServletRequest)request).getRequestURI();

		if(
			targetURI.equals("/ServletSNS/jsp/login.jsp")
			|| targetURI.equals("/ServletSNS/jsp/Login.action")
		) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = ((HttpServletRequest)request).getSession();
		
		if(session == null) {
			session = ((HttpServletRequest)request).getSession(true);
			session.setAttribute("targetURI", targetURI);
			session.setAttribute("status", "error");
			
			((HttpServletResponse)response).sendRedirect("login.jsp");
		} else {
			String user = (String)session.getAttribute("user");
			if(user == null) {
				session.setAttribute("targetURI", targetURI);
				session.setAttribute("status", "error");
				
				((HttpServletResponse)response).sendRedirect("login.jsp");
			}
		}

		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}
