package fr.formation.inti.controller;

import java.io.IOException;
import java.io.Writer;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;
import fr.formation.inti.utils.HibernateUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/checkuser")
public class UserServlet extends HttpServlet {
	
	private final static Log log = LogFactory.getLog(UserServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession();	
		User user = (User) httpSession.getAttribute("user");
		String login = user.getLogin();
		String password = user.getPassword();
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.getCurrentSession();

		String hql = "SELECT u FROM "+User.class.getName()+" u  "
				+ " WHERE u.login=:login "
				+ " AND u.password=:password";
		
		session.getTransaction().begin();

		Query<User> query = session.createQuery(hql);
		query.setParameter("login", login); 
		query.setParameter("password", password); 
		
		User u = null ;
		try {
			u = query.getSingleResult();
			log.info("----------------> " + u);
			Employee e = u.getEmp();
			request.setAttribute("employee", e);
			
			
		}	catch (NoResultException e) {
			Writer out = response.getWriter();
			log.debug("No result found ");
			out.append("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\"> ")
				.append("<div class=\"alert alert-danger alert-dismissible fade show\">")
				.append("<strong>Error!</strong> Login or Password is wrong! <a href=\"index.jsp\">Go back to login page</a></div>");
			
			return;
		} 
		

		session.getTransaction().commit();
		
		session.close();
		//sf.close();

		request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
