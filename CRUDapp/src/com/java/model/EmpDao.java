package com.java.model;
//import Model.Emp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	  public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "123456"); 
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement preparedStatement=con.prepareStatement("insert into employee values(?,?,?)");  
	            preparedStatement.setInt(1,e.getId());//(parameter, value)
	    		preparedStatement.setString(2,e.getName());
	    		preparedStatement.setInt(3,e.getSalary()); 
	              
	            status=preparedStatement.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("update employee set name=?,salary=? where id=?");  
  
	            ps.setInt(1,e.getId());//(parameter, value)
	    		ps.setString(2,e.getName());
	    		ps.setInt(3,e.getSalary());  
	           
	              
	            status=ps.executeUpdate();  
	            System.out.println("status in try is "+ status); 
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from employee where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static Emp getEmployeeById(int id){  
	        Emp e=new Emp();  
	          
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setSalary(rs.getInt(3));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<Emp> getAllEmployees(){  
	        List<Emp> list=new ArrayList<Emp>();  
	          
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Emp e=new Emp();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setSalary(rs.getInt(3));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
