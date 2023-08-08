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
			user.setSelfDescription(rs.getString("selfDescription"));
			user.setAvatarFileName(rs.getString("avatarFileName"));
			user.setHomeImageFileName(rs.getString("homeImageFileName"));
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
			user.setSelfDescription(rs.getString("selfDescription"));
			user.setAvatarFileName(rs.getString("avatarFileName"));
			user.setHomeImageFileName(rs.getString("homeImageFileName"));
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
			user.setSelfDescription(rs.getString("selfDescription"));
			user.setAvatarFileName(rs.getString("avatarFileName"));
			user.setHomeImageFileName(rs.getString("homeImageFileName"));
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
			user.setSelfDescription(rs.getString("selfDescription"));
			user.setAvatarFileName(rs.getString("avatarFileName"));
			user.setHomeImageFileName(rs.getString("homeImageFileName"));
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
	
	public void update(User user) throws Exception {
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement("update \"user\" set name=?,email=?,password=?,selfDescription=?,avatarFileName=?,homeImageFileName=? where id=?");
		st.setString(1, user.getName());
		st.setString(2, user.getEmail());
		st.setString(3, user.getPassword());
		st.setString(4, user.getSelfDescription());
		st.setString(5, user.getAvatarFileName());
		st.setString(6, user.getHomeImageFileName());
		st.setString(7, user.getId());
		st.executeUpdate();
	}
}
