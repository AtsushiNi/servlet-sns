package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
	
	public void create(Post post) throws Exception {
		post.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("insert into post(text, created_at, user_id) values (?,?,?)");
		st.setString(1, post.getText());
		st.setTimestamp(2, post.getCreatedAt());
		st.setString(3, post.getUser().getId());
		st.execute();
	}
}
