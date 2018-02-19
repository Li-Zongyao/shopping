package com;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connect.ConnectMysql;

/**
 * Servlet implementation class ChangeGoodsAdminservlet
 */

public class ChangeGoodsAdminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeGoodsAdminservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		ConnectMysql conn = null;
		String goods_name =  request.getParameter("goods_name");
		String pricee = request.getParameter("price");
		String stockk = request.getParameter("stock");
		float price = Float.valueOf(pricee);
		int stock = Integer.parseInt(stockk);

		try {
			 conn = new ConnectMysql();
			 
	         conn.getCon("jdbc:mysql://127.0.0.1:3366/test");
	         String select_sql = "insert into goods(goods_name,price,stock) values (?,?,?)";  
	         // 获取PreparedStatement
			java.sql.PreparedStatement ps = conn.prepareStatement(select_sql);
			ps.setString(1, goods_name);
			ps.setFloat(2, price);
			ps.setInt(3, stock);
			ps.executeUpdate();
			
	
			// 关闭PreparedStatement
			ps.close();
			conn.closeCon();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
	        dispatcher.forward(request,response);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
