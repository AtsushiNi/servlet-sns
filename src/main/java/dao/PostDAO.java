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
	public Post findById(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("SELECT * FROM post JOIN \"user\" ON post.user_id=\"user\".id WHERE post.id=?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		rs.next();

		User user = new User();
		user.setId(rs.getString("user.id"));
		user.setName(rs.getString("user.name"));
		user.setEmail(rs.getString("user.email"));
		user.setPassword(rs.getString("user.password"));
		user.setSelfDescription(rs.getString("user.selfDescription"));
		user.setAvatarFileName(rs.getString("user.avatarFileName"));
		user.setHomeImageFileName(rs.getString("user.homeImageFileName"));
		Post post = new Post();
		post.setId(rs.getInt("post.id"));
		post.setText(rs.getString("post.text"));
		post.setCreatedAt(rs.getTimestamp("post.created_at"));
		post.setUser(user);
		
		st.close();
		con.close();
		return post;
	}

	public List<Post> getReplies(int postId) throws Exception {
		List<Post> replies = new ArrayList<Post>();
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from post JOIN \"user\" ON post.user_id=\"user\".id where post.reply_to_id=?");
		st.setInt(1, postId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getString("user.id"));
			user.setName(rs.getString("user.name"));
			user.setEmail(rs.getString("user.email"));
			user.setPassword(rs.getString("user.password"));
			user.setSelfDescription(rs.getString("user.selfDescription"));
			user.setAvatarFileName(rs.getString("user.avatarFileName"));
			user.setHomeImageFileName(rs.getString("user.homeImageFileName"));
			Post post = new Post();
			post.setId(rs.getInt("post.id"));
			post.setText(rs.getString("post.text"));
			post.setCreatedAt(rs.getTimestamp("post.created_at"));
			post.setUser(user);
			replies.add(post);
		}
		
		st.close();
		con.close();
		return replies;
	}
	
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

		st.close();
		con.close();	
	}
}
