
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
import user.model.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		UserBean userBean = new UserBean();
		userBean.setName(uname);
		userBean.setPassword(upwd);

		List<UserBean> userList = (List<UserBean>) request.getServletContext().getAttribute("userList");
		if (userList == null) {
			userList = new ArrayList<>();
			UserBean user = new UserBean("USR_001", "Admin", "admin@gmail.com", "admin123", "admin123", "admin");
			userList.add(user);
			request.getServletContext().setAttribute("userList", userList);
			
			for(UserBean userInfo : userList) {
				if(userInfo.getName().equals(uname)&& userInfo.getPassword().equals(upwd)) {
					request.getSession().setAttribute("userInfo", userInfo);
					request.getRequestDispatcher("MNU001.jsp").forward(request, response);				
				}else {
					request.setAttribute("error", "Email and password do not match");
					request.setAttribute("data", user);
					request.getRequestDispatcher("LGN001.jsp").include(request, response);					
				}
			}
			
			
	/*		Iterator<UserBean> itr = userList.iterator();
			while (itr.hasNext()) {
				if (itr.next().getName().equals(uname) && itr.next().getPassword().equals(upwd)) {
					String userName = itr.next().getName();
					request.getSession().setAttribute("loginUserName", userName);
					request.getRequestDispatcher("MNU001.jsp").forward(request, response);

				} else {
					request.setAttribute("error", "Email and password do not match");
					request.setAttribute("data", user);
					request.getRequestDispatcher("LGN001.jsp").include(request, response);

				}*/
			}

		}
	}


