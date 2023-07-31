package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Post;
import bean.User;
import dao.PostDAO;
import dao.UserDAO;

public class ProfileAction  extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("user");

//		フォロー・フォロワー数
		UserDAO userDAO = new UserDAO();
		int followerCount = userDAO.getFollowerCount(currentUser.getId());
		int followedCount = userDAO.getFollowedCount(currentUser.getId());
		request.setAttribute("followerCount", followerCount);
		request.setAttribute("followedCount", followedCount);

//		自分の投稿一覧
		PostDAO postDAO = new PostDAO();
		List<Post> posts = postDAO.findAllByUser(currentUser);
		request.setAttribute("posts", posts);

		return "profile.jsp";
	}
}
