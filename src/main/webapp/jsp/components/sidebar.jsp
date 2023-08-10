<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	public static String createClassName(String item, javax.servlet.http.HttpServletRequest request) {
 		String path = request.getParameter("page");
 		if(item.equals(path)) return "nav-link active";
		else return "nav-link";
 	}
%>
<% String className = ""; %>

 <nav class="col-md-2 d-none d-md-block bg-light sidebar" style="padding-top: 70px;">
  <div class="sidebar-sticky">
    <ul class="nav flex-column">
      <li class="nav-item">
      	<% className = createClassName("home", request); %>
        <a class="<%= className %>" href="Home.action">
          <span data-feather="home"></span>
          Home <span class="sr-only">(current)</span>
        </a>
      </li>
      <li class="nav-item">
      	<% className = createClassName("userIndex", request); %>
        <a class="<%= className %>" href="UserIndex.action">
          <span data-feather="users"></span>
          Users
        </a>
      </li>
      <li class="nav-item">
      	<% className = createClassName("profile", request); %>
        <a class="<%= className %>" href="Profile.action">
          <span data-feather="user"></span>
          Profile
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span data-feather="file"></span>
          #######
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span data-feather="bar-chart-2"></span>
          #######
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span data-feather="layers"></span>
          #######
        </a>
      </li>
    </ul>

    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
      <span>Saved reports</span>
      <a class="d-flex align-items-center text-muted" href="#">
        <span data-feather="plus-circle"></span>
      </a>
    </h6>
    <ul class="nav flex-column mb-2">
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span data-feather="file-text"></span>
          #######
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span data-feather="file-text"></span>
          #######
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span data-feather="file-text"></span>
          #######
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span data-feather="file-text"></span>
          #######
        </a>
      </li>
    </ul>
  </div>
</nav>
