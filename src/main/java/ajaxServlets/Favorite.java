package ajaxServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.FavoriteDAO;

@WebServlet(urlPatterns = {"/ajaxEndpoint/favorite"})
public class Favorite extends HttpServlet {
    public Favorite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		User currentUser = (User)request.getAttribute("currentUser");
		
		FavoriteDAO favoriteDAO = new FavoriteDAO();
		boolean isFavorite;
		int favoritesCount = 0;
		try {
			isFavorite = favoriteDAO.getIsFavorite(currentUser.getId(), postId);
		
			if(isFavorite) {
				favoriteDAO.unFavorite(currentUser.getId(), postId);
			} else {
				favoriteDAO.favorite(currentUser.getId(), postId);
			}
			
			favoritesCount = favoriteDAO.getFavoritesCount(postId);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		PrintWriter out = response.getWriter();
		out.print(favoritesCount);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
