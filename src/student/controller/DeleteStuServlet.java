package student.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentBean;
import user.model.UserBean;

/**
 * Servlet implementation class DeleteStuServlet
 */
@WebServlet("/DeleteStuServlet")
public class DeleteStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedStuId=request.getParameter("selectedStuId");
		List<StudentBean> stuList=(List<StudentBean>) request.getServletContext().getAttribute("stuList");
		Iterator <StudentBean>itr=stuList.iterator();
		while(itr.hasNext()) {
			if(itr.next().getId().equals(selectedStuId)) {
				itr.remove();
			}
		}
		request.getServletContext().setAttribute("stuList", stuList);
		response.sendRedirect("STU003.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
