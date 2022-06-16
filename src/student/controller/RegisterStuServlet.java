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

import classes.controller.CourseBean;
import student.model.StudentBean;

/**
 * Servlet implementation class RegisterStuServlet
 */
@WebServlet("/RegisterStuServlet")
public class RegisterStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterStuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int lastStudentId = GetLatestStudentId(request);
		String id= "STU_"+String.format("%03d", lastStudentId + 1);
		request.getServletContext().setAttribute("newStuId", id);
		request.getRequestDispatcher("STU001.jsp").forward(request, response);

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
		List<String> attend=new ArrayList<>();	
		Collections.addAll(attend, request.getParameterValues("attend"));		
		StudentBean stuBean = new StudentBean(id, name, dob, gender, phone,education, attend);
		if (id.equals("") || name.equals("") || dob.equals("") || gender.equals("") || phone.equals("")
				|| education.equals("") || attend.equals("")) {
			request.setAttribute("error", " Fields can not be BLANK!!");
			request.setAttribute("stuBean", stuBean);
			request.getRequestDispatcher("STU001.jsp").forward(request, response);
		} else {
			List<StudentBean> stuList = (List<StudentBean>) request.getServletContext().getAttribute("stuList");
			if (stuList == null) {
				stuList = new ArrayList<StudentBean>();
			}
			stuList.add(stuBean);
			request.getServletContext().setAttribute("stuList", stuList);
			int lastStudentId = GetLatestStudentId(request);
			String newId= "STU_"+String.format("%03d", lastStudentId + 1);
			request.getServletContext().setAttribute("newStuId", newId);
			request.getRequestDispatcher("STU001.jsp").forward(request, response);
		} 
	}

	@SuppressWarnings("unchecked")
	private int GetLatestStudentId(HttpServletRequest request) {
		int lastStuId = 0;
		List<StudentBean> stuList=(List<StudentBean>) request.getServletContext().getAttribute("stuList");
		if(stuList!=null){
		Iterator <StudentBean>itr=stuList.iterator();
		while(itr.hasNext()) {
			String stuId = itr.next().getId() ;
			int count=Integer.parseInt(stuId.split("_")[1]);
					
			if(count> lastStuId) {
				lastStuId = count;
			}
		}
		}
		return lastStuId;			
	}

}
