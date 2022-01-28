package fr.formation.inti.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.dao.UserDao;
import fr.formation.inti.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private final static Log log = LogFactory.getLog(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();	
		
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		
		if(session == null || login == null || password == null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else { 
			User user = new User();
			user.setLogin(login);
			user.setPassword(password);
			
			session.setAttribute("user", user);

			request.getRequestDispatcher("/checkuser").forward(request, response);
		}
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
