package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connect.ConnectMysql;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class BuyGoodsSevlet
 */

public class BuyGoodsSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyGoodsSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    
	public String Datetime(){
		Date dt = new Date();//获取当前系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		//然后把currentTime 插入数据库的datetime字段就可以了，取的时候也一样，取出来的
		return currentTime;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		ConnectMysql conn = null;
		

		
		try {
			conn = new ConnectMysql();
			conn.getCon("jdbc:mysql://127.0.0.1:3366/test");
			String goods_name =  request.getParameter("goods_name");
			String numberr = request.getParameter("number");
			int number = Integer.parseInt(numberr);
			String sql = "update goods set stock=stock- '"+number+"' where goods_name='"+goods_name+"'";

			if(goods_name == ""||goods_name == null)
			{
				
		        out.print("<script language='javascript'>alert('the goods_name doesnot exit')");
			}else if(number < 0 )
			{
				
		        out.print("<script language='javascript'>alert('the number < 0')");
		        
			}else 	if(conn.sqlexecute(sql))
			{
				out.println("<script>alert('buy success');history.go(-1)</script>");
				
				System.out.println("success buy wait for take notes");
				
				String time = Datetime();
				String insert_sql = "insert into buy values('" + time + "','" + goods_name   
		        		+ "','" + number + "')";  
				conn.sqlexecute(insert_sql);
				
			}
			else{
				out.println("<script>alert('buy error');history.go(-1)</script>"); 
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {

			
			conn.closeCon();
			RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
	        dispatcher.forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
	}

}
