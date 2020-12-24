package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.Emp;
import com.java.model.EmpDao;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		response.setContentType("text/html");  
//		PrintWriter out = response.getWriter();
//		int status=0;
//		String ids = request.getParameter("id");
//		int id= Integer.parseInt(ids);
//		String name= request.getParameter("name");
//		String sals= request.getParameter("salary");
//		int sal= Integer.parseInt(sals);
//		Emp e = new Emp(id, name, sal);
//		try {
//			//whenever we use connnectivity always handle it 
//		Class.forName("com.mysql.jdbc.Driver");//this is for different types of drivers
//		//Driver  manager is the class from where you are getting this .getConnection. It'a a class which manages the driver(com.mysql.jdb)
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","123456");//it's an interface which i present in java sql 
//		//using prepared statement for saving data in the database
//		//We are prepared statement bcoz it compile once and run and we used this question becuase in runtime the value is inserted.
//		PreparedStatement preparedStatement= con.prepareStatement("insert into employee values(?,?,?)");
//		preparedStatement.setInt(1,e.getId());//(parameter, value)
//		preparedStatement.setString(2,e.getName());
//		preparedStatement.setInt(3,e.getSalary());
//		//returns a intergral value 
//		status= preparedStatement.executeUpdate();
//		if(status>0) {
//			out.println("<h1>"+"data inserted successfully"+"<h1>");
////			System.out.println("data inserted success");
//			request.getRequestDispatcher("index.html").include(request, response);  
//        }else{  
//            out.println("Sorry! unable to save record");  
//       
//		}
//		out.close(); 
//		}catch(Exception ex) {
//			
//		}
		
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);    
	        String name=request.getParameter("name");  
	        String salary = request.getParameter("salary");
	        int sal=Integer.parseInt(salary);  
	          
	        Emp e=new Emp();  
	        e.setId(id);
	        e.setName(name);  
	        e.setSalary(sal);
	         
	          
	        int status=EmpDao.save(e);  
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	}

}


