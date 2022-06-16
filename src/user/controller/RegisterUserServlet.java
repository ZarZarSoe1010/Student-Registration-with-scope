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
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// STU001
			int lastStudentId = GetLatestStudentId(request);
		String id= "USR_"+String.format("%03d", lastStudentId + 1);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cpwd=request.getParameter("cpwd");
		String userRole=request.getParameter("userRole");
		UserBean userBean=new UserBean(id,name, email, password, cpwd, userRole);
		
		if(name.equals("")||email.equals("")||password.equals("")||cpwd.equals("")||userRole.equals("")) {
			request.setAttribute("error", "Field can not be BLANK!!");
			request.setAttribute("userBean", userBean);			
			request.getRequestDispatcher("USR001.jsp").forward(request, response);
		}
		else {
			List<UserBean> userList=(List<UserBean>) request.getServletContext().getAttribute("userList");
			if(userList==null) {
					userList=new ArrayList<UserBean>();
			}			
			userList.add(userBean);
			request.getServletContext().setAttribute("userList", userList);
			request.getRequestDispatcher("USR001.jsp").forward(request, response);		
		}
			
	}
		private int GetLatestStudentId(HttpServletRequest request) {
			int lastUserId = 1;
			List<UserBean> userList=(List<UserBean>) request.getServletContext().getAttribute("userList");
			if(userList!=null){
			Iterator <UserBean>itr=userList.iterator();
			while(itr.hasNext()) {
				String userId = itr.next().getId() ;
				int count=Integer.parseInt(userId.split("_")[1]);
						
				if(count> lastUserId) {
					lastUserId = count;
				}
			}
			}
			return lastUserId;			
		}
}
