package renzo.work.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create connection variable
		String user = "springcustomer";
		String pwd = "springcustomer";
		String JDBCUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		try {

			PrintWriter out = response.getWriter();
			out.println("Connecting to database:"+JDBCUrl);
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(JDBCUrl,user,pwd);
			out.println("Connected successfully!");
			myCon.close();
			
		} catch(Exception exc) {
			
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

}
