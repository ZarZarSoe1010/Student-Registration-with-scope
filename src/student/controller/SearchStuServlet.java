package student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentBean;

/**
 * Servlet implementation class SearchStuServlet
 */
@WebServlet("/SearchStuServlet")
public class SearchStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStuServlet() {
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
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String scourse = request.getParameter("scourse");

		List<StudentBean> stuList = (List<StudentBean>) request.getServletContext().getAttribute("stuList");
		List<StudentBean> updateStuList = new ArrayList<StudentBean>();
		if (sid.isEmpty() && sname.isEmpty() && scourse.isEmpty()) {
			request.setAttribute("stuList", stuList);
			request.getRequestDispatcher("STU003.jsp").forward(request, response);

		} else {
			Iterator<StudentBean> itr = stuList.iterator();
			while (itr.hasNext()) {
				StudentBean stuBean1 = itr.next();
//				List<String>list=Arrays.asList(stuBean1.getAttend());
				if (stuBean1.getName().equals(sname) || stuBean1.getId().equals(sid)
						|| stuBean1.getAttend().contains(scourse)) {
					updateStuList.add(stuBean1);
				}
			}
			request.setAttribute("stuList", updateStuList);
		}
		request.getRequestDispatcher("STU003.jsp").forward(request, response);
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
