package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Post;
import dao.PostDAO;

public class PostDetailAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer postId = Integer.parseInt(request.getParameter("id"));
		
		PostDAO postDAO = new PostDAO();
		Post post = postDAO.findById(postId);
		System.out.println(post);
		List<Post> replies = postDAO.getReplies(postId); //postに対するリプライ一覧
//		List<Post> threadPosts = postDAO.getthreadPosts(postId); //postのこれまでのスレッド
		
		request.setAttribute("post", post);
		request.setAttribute("replies", replies);
//		request.setAttribute("threadPosts", threadPosts);
		
		return "postDetail.jsp";
	}
}
