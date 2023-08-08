package actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.User;
import dao.UserDAO;

public class EditProfileAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String selfDescription = request.getParameter("self-description");
		Part avatarImage = request.getPart("avatar-image");
		Part homeImage = request.getPart("home-image");

		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();

		Date now = new Date();
		String timeString = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(now);
		User currentUser = (User)request.getAttribute("currentUser");
		String userId = currentUser.getId();
		
		if(avatarImage.getSize() != 0) {
			String avatarFolderPath = context.getRealPath("assets/avatars");
			String fileName = avatarImage.getSubmittedFileName();
			String extension = "." + fileName.split("\\.")[fileName.split("\\.").length-1];
			String saveFileName = userId + "_" + timeString + extension;
			
			avatarImage.write(avatarFolderPath + "/" + saveFileName);
			currentUser.setAvatarFileName(saveFileName);
		}

		if(homeImage.getSize() != 0) {
			String homeFolderPath = context.getRealPath("assets/homeImages");
			String fileName = homeImage.getSubmittedFileName();
			String extension = "." + fileName.split("\\.")[fileName.split("\\.").length-1];
			String saveFileName = userId + "_" + timeString + extension;

			homeImage.write(homeFolderPath + "/" + saveFileName);
			currentUser.setHomeImageFileName(saveFileName);
		}
		
		currentUser.setName(name);
		currentUser.setSelfDescription(selfDescription);
		
		UserDAO userDAO = new UserDAO();
		userDAO.update(currentUser);
		
		request.setAttribute("currentUser", currentUser);

		return (new ProfileAction()).execute(request, response);
	}
}
