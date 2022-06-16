package student.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SeeMoreServlet
 */
@WebServlet("/SeeMoreServlet")
public class SeeMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeeMoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String selectedStuId = request.getParameter("selectedStuId");
		StudentBean stuBean = new StudentBean();	
		List<StudentBean> stuList = (ArrayList<StudentBean>) request.getServletContext().getAttribute("stuList");
		List<StudentBean> seeMoreList = new ArrayList<StudentBean>();
			Iterator<StudentBean> itr = stuList.iterator();
			while (itr.hasNext()) {
				StudentBean stuBean1 = itr.next();
//				List<String>list=Arrays.asList(stuBean1.getAttend());
				if (  stuBean1.getId().equals(selectedStuId)) {
					seeMoreList.add(stuBean1);
				}
			
			request.setAttribute("stuList", seeMoreList);
		}
		request.getRequestDispatcher("STU002.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
