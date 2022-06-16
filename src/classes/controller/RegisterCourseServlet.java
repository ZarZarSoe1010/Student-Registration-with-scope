package classes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentBean;

/**
 * Servlet implementation class RegisterClassServlet
 */
@WebServlet("/RegisterCourseServlet")
public class RegisterCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lastCourseId = GetLatestCourseId(request);
		String id = "COU_" + String.format("%03d",lastCourseId + 1);
		request.getServletContext().setAttribute("newCourseId", id);
		request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		CourseBean courseBean=new CourseBean(cid, cname);
		
		if(cid.equals("")||cname.equals("")) {
			request.setAttribute("error", "Fields can not be BLANK!!");
			request.setAttribute("courseBean", courseBean);
		}else {
			List<CourseBean>courseList=(List<CourseBean>) request.getServletContext().getAttribute("courseList");
				if(courseList==null) {
					courseList=new ArrayList<CourseBean>();
				}
				courseList.add(courseBean);
					request.getServletContext().setAttribute("courseList", courseList);
					int lastCourseId = GetLatestCourseId(request);
					String id = "COU_" + String.format("%03d",lastCourseId + 1);
					request.getServletContext().setAttribute("newCourseId", id);
					request.getRequestDispatcher("BUD003.jsp").forward(request, response);							
		}
				
	}
	private int GetLatestCourseId(HttpServletRequest request) {
		int lastCourseId = 0;
		List<CourseBean> courseList = (List<CourseBean>) request.getServletContext().getAttribute("courseList");
		if (courseList != null) {
			Iterator<CourseBean> itr = courseList.iterator();
			while (itr.hasNext()) {
				String courseId = itr.next().getCid();
				int count = Integer.parseInt(courseId.split("_")[1].trim());

				if (count > lastCourseId) {
					lastCourseId = count;
				}
			}
		}
		return lastCourseId;
	}

}
