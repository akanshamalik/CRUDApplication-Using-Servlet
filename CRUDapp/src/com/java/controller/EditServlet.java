package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.Emp;
import com.java.model.EmpDao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 	response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	          
	        Emp e=EmpDao.getEmployeeById(id);  
	          
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td>Id:</td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
	        out.print("<tr><td>Salary:</td><td><input type='text' name='salary' value='"+e.getSalary()+"'/></td></tr>");   
	        out.print("</select>");  
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	  }  

	

	
	
}
