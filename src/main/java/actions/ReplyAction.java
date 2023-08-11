package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Post;
import bean.User;
import dao.PostDAO;

public class ReplyAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String text = request.getParameter("text");
		int replyToId = Integer.parseInt(request.getParameter("id"));
		
		Post newPost = new Post();
		newPost.setText(text);
		newPost.setUser((User)request.getAttribute("currentUser"));
		newPost.setReplyToId(replyToId);
		
		PostDAO postDAO = new PostDAO();
		postDAO.create(newPost);
		
		request.setAttribute("postId", replyToId);

		return (new PostDetailAction()).execute(request, response);
	}

}
