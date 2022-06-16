package student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentBean;

/**
 * Servlet implementation class UpdateStuServlet
 */
@WebServlet("/UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String education = request.getParameter("education");
		List<String> attend = new ArrayList<>();
		Collections.addAll(attend, request.getParameterValues("attend"));
		StudentBean stuBean = new StudentBean(id, name, dob, gender, phone, education, attend);

		if (name.equals("") || dob.equals("") || gender.equals("") || phone.equals("") || education.equals("")
				|| attend.equals("")) {
			request.setAttribute("error", " Fields can not be BLANK!!");
			request.setAttribute("stuBean", stuBean);
		} else {
			List<StudentBean> stuList = (List<StudentBean>) request.getServletContext().getAttribute("stuList");
			Iterator<StudentBean> itr = stuList.iterator();
			while (itr.hasNext()) {
				if (itr.next().getId().equals(id)) {
					itr.remove();
				}
			}
			stuList.add(stuBean);
			request.getServletContext().setAttribute("stuList", stuList);
			response.sendRedirect("STU003.jsp");

		}
	}
}
