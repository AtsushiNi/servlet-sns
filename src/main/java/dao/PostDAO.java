package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Post;
import bean.User;

public class PostDAO extends DAO {
	public List<Post> findAllByUser(User user) throws Exception {
		List<Post> posts = new ArrayList<Post>();
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from post where user_id=?");
		st.setString(1, user.getId());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Post post = new Post();
			post.setId(rs.getInt("id"));
			post.setText(rs.getString("text"));
			post.setCreatedAt(rs.getTimestamp("created_at"));
			post.setUser(user);
			posts.add(post);
		}
		
		st.close();
		con.close();
		return posts;
	}
}
