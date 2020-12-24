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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
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
	        int status=EmpDao.update(e);  
	        System.out.println("Status is "+status);
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	  }  

}
