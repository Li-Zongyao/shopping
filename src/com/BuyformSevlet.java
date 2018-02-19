package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Buy_bean;
import com.beans.Goods_bean;
import com.connect.ConnectMysql;

/**
 * Servlet implementation class BuyformSevlet
 */
@WebServlet("/BuyformSevlet")
public class BuyformSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyformSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		

		
		ResultSet rs = null;
		ConnectMysql conn = null;

		try {
			 List<Buy_bean> buylist = new ArrayList<Buy_bean>(); 
			
			 conn = new ConnectMysql();
			 
	         conn.getCon("jdbc:mysql://127.0.0.1:3366/test");
	         String select_sql = "select * from buy";  
	         rs = conn.select(select_sql);
	     	 System.out.println("ResultSet sql:"+rs);
	          
	            while(rs.next()){  
	                String date = rs.getString("date");  
	                String goods_name = rs.getString("goods_name"); 
	                int number = rs.getInt("number");
	                
	                Buy_bean buy_bean = new Buy_bean(date,goods_name,number); //新建bean实例
	                
	                buylist.add(buy_bean);  
	            }  
	            
	            for(Buy_bean  buy1 :  buylist ) 
	            	System.out.print("buy goods_name: "+(String) buy1.getGoods_name()+"  "); 
	            
	            request.setAttribute("buylist", buylist);  
	            request.getRequestDispatcher("admin_shopping.jsp").forward(request, response);  
	            
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace(); 
		}finally {
			try {  
                if(rs != null){  
                    rs.close();  
                }  
                 
                if(conn!=null){  
                    conn.closeCon();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
			
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
