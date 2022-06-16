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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		/*
		for (UserBean user : userList) {
			System.out.println(user.toString());
		}
			List<UserBean> searchUserList = new ArrayList<>();
		for(UserBean user : userList) {
			if(user.getId().equals(id) || user.getName().equals(name)) {
				searchUserList.add(user);
			}
		}
		for (UserBean user : searchUserList) {
			System.out.println(user.toString());
		}

		boolean b = false;
		if (id.isEmpty() && name.isEmpty()) {
			request.getSession().setAttribute("userList", userList);
		} else {
			for (UserBean user : userList) {
				if (user.getId().equals(id) || user.getName().equals(name)) {
					b = true;
					searchUserList.add(user);

				}

			}*/
//			Iterator <UserBean>itr=userList.iterator();
//			while(itr.hasNext()) {
//				if(itr.next().getId().equals(id) || itr.next().getName().equals(name)) {
//					b=true;				
//					searchUserList.add(itr.next());
//				}			
//			}
		/*
		 * if(searchUserList.size() == 0) {
		 * request.getServletContext().setAttribute("userList", userList);
		 * request.getRequestDispatcher("USR003.jsp").forward(request, response); } else
		 * { request.getServletContext().setAttribute("userList", searchUserList);
		 * request.getRequestDispatcher("USR003.jsp").forward(request, response); }
		 */
//			request.getServletContext().setAttribute("userList", searchUserList);
//			if (b == false) {
//				request.setAttribute("error", "User Not Found!!");
//			}
//		}
//		request.getRequestDispatcher("USR003.jsp").forward(request, response);
	/*
	 * } 
	 */
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpwd = request.getParameter("cpwd");
		String userRole = request.getParameter("userRole");
		UserBean userBean = new UserBean(id, name, email, password, cpwd, userRole);

		if (name.equals("") || email.equals("") || password.equals("") || cpwd.equals("") || userRole.equals("")) {
			request.setAttribute("error", "Field can not be BLANK!!");
			request.setAttribute("userBean", userBean);
		} else {
			List<UserBean> userList = (List<UserBean>) request.getServletContext().getAttribute("userList");
			Iterator<UserBean> itr = userList.iterator();
			while (itr.hasNext()) {
				if (itr.next().getId().equals(id)) {
					itr.remove();
				}
			}
			userList.add(userBean);
			request.setAttribute("error", "Update Successful!!");
			request.getServletContext().setAttribute("userList", userList);
		}
		request.getRequestDispatcher("USR002.jsp").forward(request, response);

	}

}
