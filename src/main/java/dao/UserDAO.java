package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO extends DAO {
	public User search(String id, String password) throws Exception {
		User user = null;
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from \"user\" where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		System.out.println(st.toString());
		while(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
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
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			users.add(user);
		}

		st.close();
		con.close();
		return users;
	}
	
	public User findById(String id) throws Exception {
		User user = null;
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from \"user\" where id=?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		
		System.out.println(st.toString());
		while(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return user;
	}

	
	public List<User> getFollowers(String id) throws Exception {
		List<User> users = new ArrayList<User>();

		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from \"user\" inner join follow where follow.followed_id = \"user\".id and follow.follower_id = ?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			users.add(user);
		}

		st.close();
		con.close();
		return users;
	}
	
	public int getFollowerCount(String id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement("select count(*) as num from follow where follower_id = ?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		rs.next();
		int followerCount = rs.getInt("num");
		
		st.close();
		con.close();
		return followerCount;
	}

	public int getFollowedCount(String id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement("select count(*) as num from follow where followed_id = ?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		rs.next();
		int followedCount = rs.getInt("num");
		
		st.close();
		con.close();
		return followedCount;
	}
}
