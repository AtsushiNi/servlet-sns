package bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Post implements java.io.Serializable {
	private int id;
	private String text;
	private Timestamp createdAt;
	private User user;
	private Integer replyToId = null;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getReplyToId() {
		return replyToId;
	}
	public void setReplyToId(Integer replyToId) {
		this.replyToId = replyToId;
	}
	
	public String createdAtText() {
		Calendar now = Calendar.getInstance();
		Calendar created = Calendar.getInstance();
		created.setTimeInMillis(createdAt.getTime());

		if(now.get(Calendar.DATE) == created.get(Calendar.DATE)){
			SimpleDateFormat format = new SimpleDateFormat("hh:mm");
			return format.format(created.getTime());
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			return format.format(created.getTime());
		}
		
	}
}
