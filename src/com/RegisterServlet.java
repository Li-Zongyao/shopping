package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.user.Customer_bean;
import com.connect.ConnectMysql;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO 自动生成的方法存根
		super.init(config);
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer_bean newuser = new Customer_bean();     
    	PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String user_id =  request.getParameter("user_id");
        String name =  request.getParameter("name");
        String password =  request.getParameter("password");
        if (user_id == null||user_id == "") {
        	out.println("<script>alert('user_id null');history.go(-1)</script>"); 
		} else if (name  == null||name == "") {
			out.println("<script>alert('name null');history.go(-1)</script>"); 
		}else if (password  == null||password == "") {
			out.println("<script>alert('password null');history.go(-1)</script>"); 
		}else {
			
		
        
			ConnectMysql mySql = new ConnectMysql();
			mySql.getCon("jdbc:mysql://127.0.0.1:3366/test");
        
			String insert_sql = "insert into account values('" + user_id + "','" + name   
        		+ "','" + password + "','" + 0 + "')";       
  
			if(mySql.sqlexecute(insert_sql))
			{
				mySql.closeCon();
				out.println("<script>alert('register success');history.go(-1)</script>"); 
				
			}
			else{
				out.println("<script>alert('register error');history.go(-1)</script>"); 
			}
        
		}
        
        
        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
