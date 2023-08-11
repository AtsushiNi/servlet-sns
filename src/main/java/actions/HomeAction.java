package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Post;
import bean.User;
import dao.PostDAO;
import dao.UserDAO;

public class HomeAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		User currentUser = (User)request.getAttribute("currentUser");
		
		UserDAO userDAO = new UserDAO();
		List<User> followers = userDAO.getFollowers(currentUser.getId());
		followers.add(currentUser);

		List<Post> posts = new ArrayList<Post>();
		PostDAO postDAO = new PostDAO();

		for(User follower : followers) {
			posts.addAll(postDAO.findAllByUser(follower));
		}

		// 投稿が最近の順にソート
		List<Post> sortedPosts = posts
			.stream()
			.sorted((a, b) -> (a.getCreatedAt().getTime() - b.getCreatedAt().getTime())<0 ? 1 : -1)
			.collect(Collectors.toList());

		request.setAttribute("posts", sortedPosts);
		return "home.jsp";
	}
}
