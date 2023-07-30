package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Post;

public class PostDAO extends DAO {
	public List<Post> findAllByUserId(int user_id) throws Exception {
		List<Post> posts = new ArrayList<Post>();
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from post where user_id=?");
		st.setInt(1, user_id);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Post post = new Post();
			post.setId(rs.getInt("id"));
			post.setText(rs.getString("text"));
			post.setCreatedAt(rs.getTimestamp("created_at"));
			post.setUserId(rs.getInt("user_id"));
			posts.add(post);
		}
		
		st.close();
		con.close();
		return posts;
	}
}
