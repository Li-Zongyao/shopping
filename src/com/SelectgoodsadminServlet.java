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
import javax.servlet.http.HttpSession;

import com.beans.Goods_bean;
import com.connect.ConnectMysql;

/**
 * Servlet implementation class SelectgoodsServlet
 */
public class SelectgoodsadminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectgoodsadminServlet() {
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
			 List<Goods_bean> goodslist = new ArrayList<Goods_bean>(); 
			 //request.setAttribute("goodslist", goodslist);
			 conn = new ConnectMysql();
			 
	         conn.getCon("jdbc:mysql://127.0.0.1:3366/test");
	         String select_sql = "select * from goods";  
	         rs = conn.select(select_sql);
	     	 System.out.println("ResultSet sql:"+rs);
	          
	            while(rs.next()){  
	                String goods_name = rs.getString("goods_name");  
	                float prices = rs.getFloat("price");
	                int stock = rs.getInt("stock");
	                
	                Goods_bean goods_bean = new Goods_bean(goods_name,prices,stock); //新建bean实例
	                
	                goodslist.add(goods_bean);  
	            }  
	            
	            for(Goods_bean  goods1 :  goodslist ) 
	            	System.out.print("goods_name: "+(String) goods1.getGoods_name()+"  "); 
	            
	            request.setAttribute("goodsList", goodslist);  
	            request.getRequestDispatcher("admin.jsp").forward(request, response);  
	            
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
