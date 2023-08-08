package bean;

public class User implements java.io.Serializable {
	private String id;
	private String name;
	private String email;
	private String password;
	private String selfDescription;
	private String avatarFileName;
	private String homeImageFileName;

	public String getSelfDescription() {
		return selfDescription;
	}
	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}
	public String getAvatarFileName() {
		return avatarFileName;
	}
	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}
	public String getHomeImageFileName() {
		return homeImageFileName;
	}
	public void setHomeImageFileName(String homeImageFileName) {
		this.homeImageFileName = homeImageFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSelfDescriptionHTML() {
	    if (selfDescription == null || "".equals(selfDescription)) {
	        return "";
	    }
	    return selfDescription.replaceAll("\\r\\n|\\n\\r|\\n|\r", "<br>");
	}
}
