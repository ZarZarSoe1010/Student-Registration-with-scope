package user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.model.UserBean;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		UserBean userBean = new UserBean(id, name, null, null, null, null);
		@SuppressWarnings("unchecked")
		List<UserBean> userList = (List<UserBean>) request.getServletContext().getAttribute("userList");
		List<UserBean> updateUserList = new ArrayList<UserBean>();
		if (id.isEmpty() && name.isEmpty() ) {
			request.setAttribute("userList", userList);
		} else {
			Iterator<UserBean> itr = userList.iterator();
			while (itr.hasNext()) {
				UserBean userBean1 = itr.next();
				if (userBean1.getName().equals(name) || userBean1.getId().equals(id)) {
					updateUserList.add(userBean1);
				}
			}
			request.setAttribute("userList", updateUserList);
		}
		request.getRequestDispatcher("USR003.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
