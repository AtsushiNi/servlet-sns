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
		
		PreparedStatement st = con.prepareStatement("""
				SELECT posts.*, users.*, COUNT(favorites.post_id) AS favs
				FROM posts
				JOIN users ON posts.user_id=users.id
				LEFT JOIN favorites ON posts.id=favorites.post_id
				WHERE posts.id=?
				GROUP BY posts.id
		""");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		rs.next();

		User user = new User();
		user.setId(rs.getString("users.id"));
		user.setName(rs.getString("users.name"));
		user.setEmail(rs.getString("users.email"));
		user.setPassword(rs.getString("users.password"));
		user.setSelfDescription(rs.getString("users.selfDescription"));
		user.setAvatarFileName(rs.getString("users.avatarFileName"));
		user.setHomeImageFileName(rs.getString("users.homeImageFileName"));
		Post post = new Post();
		post.setId(rs.getInt("posts.id"));
		post.setText(rs.getString("posts.text"));
		post.setCreatedAt(rs.getTimestamp("posts.created_at"));
		post.setFavoriteNumber(rs.getInt("favs"));
		post.setUser(user);
		
		st.close();
		con.close();
		return post;
	}

	public List<Post> getReplies(int postId) throws Exception {
		List<Post> replies = new ArrayList<Post>();
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from posts JOIN users ON posts.user_id=users.id where posts.reply_to_id=?");
		st.setInt(1, postId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getString("users.id"));
			user.setName(rs.getString("users.name"));
			user.setEmail(rs.getString("users.email"));
			user.setPassword(rs.getString("users.password"));
			user.setSelfDescription(rs.getString("users.selfDescription"));
			user.setAvatarFileName(rs.getString("users.avatarFileName"));
			user.setHomeImageFileName(rs.getString("users.homeImageFileName"));
			Post post = new Post();
			post.setId(rs.getInt("posts.id"));
			post.setText(rs.getString("posts.text"));
			post.setCreatedAt(rs.getTimestamp("posts.created_at"));
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
		st = con.prepareStatement("""
			SELECT posts.*, COUNT(favorites.post_id) AS favs 
			FROM posts
			LEFT JOIN favorites ON posts.id=favorites.post_id
			WHERE posts.user_id=?
			GROUP BY posts.id
		""");
		st.setString(1, user.getId());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Post post = new Post();
			post.setId(rs.getInt("posts.id"));
			post.setText(rs.getString("posts.text"));
			post.setCreatedAt(rs.getTimestamp("posts.created_at"));
			post.setFavoriteNumber(rs.getInt("favs"));
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
		
		PreparedStatement st = con.prepareStatement("insert into posts(text, created_at, user_id, reply_to_id) values (?,?,?,?)");
		st.setString(1, post.getText());
		st.setTimestamp(2, post.getCreatedAt());
		st.setString(3, post.getUser().getId());
		if(post.getReplyToId() != null) {
			st.setInt(4, post.getReplyToId());
		} else {
			st.setNull(4, java.sql.Types.INTEGER);
		}
		st.execute();

		st.close();
		con.close();	
	}
}
