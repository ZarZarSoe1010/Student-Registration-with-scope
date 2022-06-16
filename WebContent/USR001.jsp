<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	        <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="test.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
	<script type ="text/javascript">
	var elem = document.getElementById('exampleModal');
	document.getElementById('btnAdd').addEventListener('click',function(){
	Alert("TEST");
	});
	</script>

<title>User Registration</title>
</head>

<body>
	<div id="testheader">
		<div class="container">
			<div class=row>
				<div class="col-md-5 ">
					<a href="MNU001.jsp"><h3>Student Registration</h3></a>
				</div>
				<div class="col-md-6">
					<p>User: ${userInfo.name}</p>
					<p>Current Date : 
						
            		<%@page import="java.util.Date" %>
                  	 		<%=new Date() %>
					
					</p>
				</div>
				<div class="col-md-1">
					<input type="button" class="btn-basic" id="lgnout-button"
						value="Log Out" onclick="location.href='LGN001.jsp'">
				</div>
			</div>
		</div>

	</div>

	<div class="container">
		<div class="sidenav">

			<button class="dropdown-btn">
				Class Management <i class="fa fa-caret-down"></i>
			</button>

			<div class="dropdown-container">
				<a href="BUD003.jsp">Course Registration </a> <a href="STU001.jsp">Student
					Registration </a> <a href="STU003.jsp">Student Search </a>
			</div>
			<a href="USR003.jsp">Users Management</a>
		</div>
		<div class="main_contents">
			<div id="sub_content">
			<div style="color: red;">${error }</div>			
				<form action="RegisterUserServlet" method="post">
					<h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Registration</h2>
					
			<%-- 				<div class="row mb-4">
								<div class="col-md-2"></div>
								<label for="id" class="col-md-2 col-form-label">Id</label>
								<div class="col-md-4">
									<input type="text" class="form-control" id="id" name="id" value="${userBean.id }">
								</div>
							</div> --%>
							<div class="row mb-4">
								<div class="col-md-2"></div>
								<label for="name" class="col-md-2 col-form-label">Name</label>
								<div class="col-md-4">
									<input type="text" class="form-control" id="name" name="name" value="${userBean.name}">
								</div>
							</div>
							<div class="row mb-4">
								<div class="col-md-2"></div>
								<label for="email" class="col-md-2 col-form-label">Email</label>
								<div class="col-md-4">
									<input type="email" class="form-control" id="email" name="email"  value="${userBean.email}">
								</div>
							</div>
							<div class="row mb-4">
								<div class="col-md-2"></div>
								<label for="Password" class="col-md-2 col-form-label">Password</label>
								<div class="col-md-4">
									<input type="password" class="form-control" id="Password" name="password" value="${userBean.password}">
								</div>
							</div>
							<div class="row mb-4">
								<div class="col-md-2"></div>
								<label for="confirmPassword" class="col-md-2 col-form-label">Confirm
									Password</label>
								<div class="col-md-4">
									<input type="password" class="form-control" id="confirmPassword" name="cpwd" value="${userBean.cpwd}">
								</div>
							</div>
							<div class="row mb-4">
								<div class="col-md-2"></div>
								<label for="userRole" class="col-md-2 col-form-label">User
									Role</label>
								<div class="col-md-4">
									<select class="form-select" aria-label="Education" id="userRole" name="userRole" value="${userBean.userRole}">
										<option selected>Admin</option>
										<option value="1">User</option>
									</select>
								</div>
							</div>							
							<div class="row mb-4">
								<div class="col-md-4"></div>
								<div class="col-md-6">
									<button type="submit" class="btn btn-secondary col-md-2" id="btnAdd"
										data-bs-toggle="modal" data-bs-target="#exampleModal">Add</button>
										

										
							<div class="modal fade" id="exampleModal" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header">										
											<h5 class="modal-title" id="exampleModalLabel">Student
												Registration</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">

											<h5 style="color: rgb(127, 209, 131);">Registered
												Successfully !</h5>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-success col-md-2"
												data-bs-dismiss="modal">Ok</button>

										</div>
									</div>
								</div>
							</div>

						</div>
				</form>
			</div>
		</div>
	</div>
	<div id="testfooter">
		<span>Copyright &#169; ACE Inspiration 2022</span>
	</div>
	<script>
		/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}
	</script>
</body>

</html>




