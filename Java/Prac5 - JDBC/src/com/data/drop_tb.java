package com.data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/drop_tb")
public class drop_tb extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       
   
    public drop_tb() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String dbname = request.getParameter("dbname");
		String table = request.getParameter("table");
		try {	
		Class.forName("com.mysql.jdbc.Driver");
		
			 Connection  con1=DriverManager.getConnection
                     ("jdbc:mysql://localhost:3306/"+dbname +"","root","");
        	 Statement sd1 = con1.createStatement();
        	 String query = "drop table "+table;
        	 sd1.executeUpdate(query);
        	 out.println("<html><body><script>alert(\"Database Table Drop Successfully\");</script>");
        	 out.println("<meta http-equiv=\"refresh\" content=\"0; url=OP.html\"></body></html>");
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
