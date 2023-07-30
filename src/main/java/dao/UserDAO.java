package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO extends DAO {
	public User search(String email, String password) throws Exception {
		User user = null;
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from \"user\" where email=? and password=?");
		st.setString(1, email);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		System.out.println(st.toString());
		while(rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return user;
	}
	
	public List<User> findAll() throws Exception {
		List<User> users = new ArrayList<User>();
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from \"user\"");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			users.add(user);
		}

		st.close();
		con.close();
		return users;
	}
	
	public List<User> getFollowers(int id) throws Exception {
		List<User> users = new ArrayList<User>();

		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from \"user\" inner join follow where follow.followed_id = \"user\".id and follow.follower_id = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			users.add(user);
		}

		st.close();
		con.close();
		return users;
	}
}
