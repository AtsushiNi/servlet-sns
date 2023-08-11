package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Post;
import bean.User;
import dao.PostDAO;

public class CreatePostAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String text = request.getParameter("text");
		
		Post newPost = new Post();
		newPost.setText(text);
		newPost.setUser((User)request.getAttribute("currentUser"));
		
		PostDAO postDAO = new PostDAO();
		postDAO.create(newPost);
		
		return (new HomeAction()).execute(request, response);
	}
}
