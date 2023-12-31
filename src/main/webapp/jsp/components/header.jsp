<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark" style="z-index:10000;">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#" style="background-color: inherit;">Servlet SNS</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item dropdown">
      <a class="navbar-link" data-toggle="dropdown" id="dropdown-a" aria-haspopup="true" aria-expanded="false" style="color:white;">
		<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="white" class="bi bi-list" viewBox="0 0 16 16">
		  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
		</svg>
	  </a>
		<div class="dropdown-menu dropdown-menu-right" id="menu" aria-labelledby="dropdown-a">
			<a class="dropdown-item" href="Profile.action">
				Profile
			</a>
	      <a class="dropdown-item" href="Logout.action">
			Log out
		  </a>
		</div>
    </li>
  </ul>
</nav>