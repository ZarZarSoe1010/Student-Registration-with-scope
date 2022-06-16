<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<title>Student Details</title>
</head>

<body>
	<div id="testheader">
		<div class="container">
			<div class=row>
				<div class="col-md-5 ">
					<a href="MNU001.jsp"><h3>Student Registration</h3></a>
				</div>
				<div class="col-md-6">
					<p>User:${userInfo.name}</p>
					<p>
						Current Date :
						<%@page import="java.util.Date"%>
						<%=new Date()%>
					</p>
				</div>
				<div class="col-md-1">
					<input type="button" class="btn-basic" id="lgnout-button"
						value="Log Out" onclick="location.href='LGN001.jsp'">
				</div>
			</div>
		</div>

	</div>
	<!-- <div id="testsidebar">Hello World </div> -->
	<div class="container">
		<div class="sidenav">

			<button class="dropdown-btn">
				Class Management <i class="fa fa-caret-down"></i>
			</button>

			<div class="dropdown-container">
				<a href="RegisterCourseServlet">Course Registration </a> <a
					href="RegisterStuServlet">Student Registration </a> <a
					href="STU003.jsp">Student Search </a>
			</div>
			<a href="USR003.jsp">Users Management</a>
		</div>
		<div class="main_contents">
			<div id="sub_content">
				<div style="color: red;">${error }</div>

				<form action="UpdateStuServlet" method="post">
					<c:forEach items="${stuList}" var="seeMoreList">
						<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Details</h2>
						<div class="row mb-4">
							<div class="col-md-2"></div>
							<label for="studentID" class="col-md-2 col-form-label">Student
								ID</label>
							<div class="col-md-4">
								<input type="text" class="form-control" id="studentID" name="id"
									value="${seeMoreList.id}">

							</div>
						</div>
						<div class="row mb-4">
							<div class="col-md-2"></div>
							<label for="name" class="col-md-2 col-form-label">Name</label>
							<div class="col-md-4">
								<input type="text" class="form-control" id="name" name="name"
									value="${seeMoreList.name }">
							</div>
						</div>
						<div class="row mb-4">
							<div class="col-md-2"></div>
							<label for="dob" class="col-md-2 col-form-label">DOB</label>
							<div class="col-md-4">
								<input type="date" class="form-control" id="dob" name="dob"
									value="${seeMoreList.dob}">
							</div>
						</div>
					 <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Gender</legend>
                <div class="col-md-4">
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio"  id="gridRadios1" value="Male" name = "gender"
                            checked>
                        <label class="form-check-label" for="gridRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio"  id="gridRadios2" value="Female" name = "gender">
                        <label class="form-check-label" for="gridRadios2">
                            Female
                        </label>
                    </div>
                </div>
            </fieldset>
						<div class="row mb-4">
							<div class="col-md-2"></div>
							<label for="phone" class="col-md-2 col-form-label">Phone</label>
							<div class="col-md-4">
								<input type="text" class="form-control" id="phone" name="phone"
									value=" ${seeMoreList.phone}">
							</div>
						</div>
						
						 <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="education" class="col-md-2 col-form-label">Education</label>
                <div class="col-md-4">
                    <select class="form-select" aria-label="Education" id="education" name = "education">
                        <option  value="Bachelor of Information Technology" ${seeMoreList.education.equals("Bachelor of Information Technology") ? 'selected' : '' }>Bachelor of Information Technology</option>
                        <option value="Diploma in IT" ${seeMoreList.education.equals("Diploma in IT") ? 'selected' : '' }>Diploma in IT</option>
                        <option value="Bachelor of Computer Science" ${seeMoreList.education.equals("Bachelor of Computer Science") ? 'selected' : '' } >Bachelor of Computer Science</option>
    
                    </select>
                </div>
            </div>
						
						<fieldset class="row mb-4">
							<div class="col-md-2"></div>
							<legend class="col-form-label col-md-2 pt-0">Attend</legend>
							<div class="col-md-4">
								<c:forEach items="${applicationScope.courseList}" var="data">
									<div class="form-check-inline col-md-2">
										<input class="form-check-input" type="checkbox" name="attend"
											id=" ${data.cid}" value=" ${data.cname}"
											${seeMoreList.attend.contains(data.cname)? 'checked' : '' } />
										<label class="form-check-label" for="gridRadios1">
											${data.cname} </label>
									</div>
								</c:forEach>
							</div>
						</fieldset>
						<!-- <div class="row mb-4">
							<div class="col-md-2"></div>
							<label for="name" class="col-md-2 col-form-label">Photo</label>
							<div class="col-md-4">
								<input type="file" class="form-control" id="name">
							</div>
						</div> -->

						<div class="row mb-4">
							<div class="col-md-4"></div>

							<div class="col-md-4">

							<button type="submit" class="btn btn-secondary mb-2">Update</button>
									
									<a href="DeleteStuServlet?selectedStuId=${seeMoreList.id }">									
									<button type="button" class="btn btn-danger"
										data-bs-toggle="modal" data-bs-target="#exampleModal">
										<span>Delete</span>
									</button>
								</a>

								<!-- Modal -->
								<div class="modal fade" id="exampleModal" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-dialog modal-dialog-centered">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Student
													Deletion</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">Are you sure you want to
												delete?</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Ok</button>
												<button type="button" class="btn btn-danger">Cancel</button>
											</div>
										</div> 
									</div>
								</div> 
							</div>

						</div>
					</c:forEach>
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

