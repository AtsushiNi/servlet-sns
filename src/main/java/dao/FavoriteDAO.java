package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FavoriteDAO extends DAO {
	public boolean getIsFavorite(String userId, int postId) throws Exception {
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement("""
			SELECT COUNT(*) AS num
			FROM favorites
			WHERE favorites.user_id=? AND favorites.post_id=?
		""");
		st.setString(1, userId);
		st.setInt(2, postId);
		ResultSet rs = st.executeQuery();
		rs.next();
		int favoriteCount = rs.getInt("num");
		
		st.close();
		con.close();
		if (favoriteCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getFavoritesCount(int postId) throws Exception {
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement("""
			SELECT COUNT(*) AS num
			FROM favorites
			WHERE favorites.post_id=?
		""");
		st.setInt(1, postId);
		ResultSet rs = st.executeQuery();
		rs.next();
		int favoriteCount = rs.getInt("num");
		
		st.close();
		con.close();
		
		return favoriteCount;
	}
	
	public void favorite(String userId, int postId) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("""
			INSERT INTO favorites(user_id, post_id) VALUES (?,?)
		""");
		st.setString(1, userId);
		st.setInt(2, postId);
		st.execute();
		st.close();
		con.close();
	}

	public void unFavorite(String userId, int postId) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("""
			DELETE FROM favorites
			WHERE user_id=? AND post_id=?
		""");
		st.setString(1, userId);
		st.setInt(2, postId);
		st.execute();
		st.close();
		con.close();
	}
}
