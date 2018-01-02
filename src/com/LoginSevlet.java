package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.user.Customer_bean;
import com.connect.ConnectMysql;
import com.sun.javafx.scene.layout.region.SliceSequenceConverter;
import com.sun.scenario.effect.LinearConvolveCoreEffect;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/LoginSevlet")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		 ConnectMysql mySql = new ConnectMysql();
	     mySql.getCon("jdbc:mysql://127.0.0.1:3366/test");
	     Customer_bean userlogin = new Customer_bean() ;
		 String user_id =  request.getParameter("user_id");
	     String password =  request.getParameter("password");
	     if( user_id.equals("")&& !password.equals("") ){
	    	 
	    	 try {
	    	 String select_sql = "select * from account where user_id = '" +user_id+"'  ";
	    	 ResultSet rs = mySql.select(select_sql);
	    	 
	    	 	while(rs.next()){  															//?????
	    	 		userlogin = new Customer_bean(rs.getString("user_id"),rs.getString("name"),
	    	 				rs.getString("password"),Integer.parseInt(rs.getString("lv")));
	    	 	}
	    	 	System.out.print(rs);
	    	 	if (userlogin != null) {
	    	 		if (userlogin.getName() != null) {	
	                    if (userlogin.getUser_id().equals(user_id) == true) {
	    	 				if(userlogin.getPassword().equals(password) == true)
	    	 				{
	    	 					if(userlogin.getLv() == 0)
	    	 					{
	                                HttpSession session = request.getSession();
	                                session.setAttribute("account",userlogin);
	                                RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
	                                dispatcher.forward(request,response);
	                                mySql.closeCon();
	    	 					}else if (userlogin.getLv() == 1) {
	    	 						HttpSession session = request.getSession();
	                                session.setAttribute("account",userlogin);
	                                RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
	                                dispatcher.forward(request,response);
	                                mySql.closeCon();	
								}
	    	 					else {//权限错误
		    	 					out.print("<script language='javascript'>alert('wrong lv')</script>");
		    	 					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		    	                    dispatcher.forward(request,response);	
		    	                    mySql.closeCon();
								}
	    	 				
	    	 				
	    	 				}
	    	 				else {//错密码
	    	 					out.print("<script language='javascript'>alert('the password error')</script>");
	    	 					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	    	                    dispatcher.forward(request,response);	
	    	                    mySql.closeCon();
							}
	    	 			}
	    	 		}
	    	 		else {//无此人
	    	 			out.print("<script language='javascript'>alert('the name doesnot exit')</script>");
	    	 			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	                    dispatcher.forward(request,response);	
	                    mySql.closeCon();
					}
	    	 		
					
				} else {//错误
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request,response);
                    mySql.closeCon();
				}
	    	 
	    	 } 
	    	 
	    	 catch (Exception e) {
					// TODO: handle exception
	    		 e.printStackTrace();
			}
	     
	     
	     }else{
	    	 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	         dispatcher.forward(request,response);
	         mySql.closeCon();
	    	 
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
