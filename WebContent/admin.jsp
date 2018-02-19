<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>  
<%@page import="com.beans.Goods_bean"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/admin.css" />

<title>welcome Admin_goods</title>
</head>

<body>
	   

<div id="content" >
    	<div class="button_altdiv2"> 
       <input type="button" name="btnAdd" onclick="javascript:window.location.href='login'" value="退&nbsp;出" class="button_alt_2"/>
       </div>

	<div class="button_alt"> 
       <input type="button" name="btnAdd" onclick="javascript:window.location.href='admin_shopping.jsp'" value="购&nbsp;买&nbsp;表&nbsp;" class="button_alt_1"/>
       </div>
       

<div class="formchange" calss= "formchange">
<form action="changegoods" method="post">
        <div class="title">
		更改商品
		</div>

        <div class="login-input-box1">
商品名：<input type="text" name="goods_name" value="请输入商品名">
		</div>
		
        <div class="login-input-box">
价     格：<input type="text" name="price" value="请输入价&nbsp;&nbsp;格">
		</div>
		
        <div class="login-input-box">
库     存：<input type="text" name="stock" value="请输入库&nbsp;&nbsp;存">
		</div>
		
		<div style="margin:10px 10px;">
      <input type="submit" class="Submit_Button" value="修&nbsp;&nbsp;改" >
      </div>
</form>
</div >

<div class="formchange" calss= "formchange" >
<form action="delgoods" method="post">
        <div class="title">
		删除商品
		</div>

        <div class="login-input-box1">
商品名：<input type="text" name="goods_name" value="请输入商品名">
		</div>
		
		
		<div style="margin:10px 10px;">
      <input type="submit" class="Submit_Button" value="删&nbsp;&nbsp;除" >
      </div>
</form>

</div >


<div>
<form action="selectgoodsadmin" method="post" >

	<div class= "select" style="margin:10px 10px;">
	 <input type="submit" class="Button" value="查询" >
 	</div>
 	
 	
	<table summary="book list" class="table1">
            <caption>Book List</caption> <!-- caption 标签必须紧随 table 标签之后。您只能对每个表格定义一个标题。通常这个标题会被居中于表格之上。 -->
            <col></col><col></col><col></col><col class="price" align="right"></col><col></col>
            <thead>
                <tr>
                    <th width="279" >商品</th>
                    <th width="149" >价格</th>
                    <th width="176" >库存</th>
                </tr>
            </thead>    
            <tbody class="table_tbody">
	             <%  
		    
				    ArrayList<Goods_bean>  goodsList = (ArrayList<Goods_bean>)request.getAttribute("goodsList"); 
			
				    if(goodsList!=null){  
				        for(Goods_bean goods:goodsList){  
				            //String goodsinfo = goods.getGoods_name()+"---"+goods.getPrices()+"---"+goods.getStock(); 
				            String Goods_name = goods.getGoods_name();
				            float Prices = goods.getPrices();
				            int Stock = goods.getStock();
				            %>  
				            
				            <tr class="odd">
			                    <th><%=Goods_name%></th>
			                    <td><%=Prices%></td>
			                    <td><%=Stock%></td>
			                </tr>
				            
				            <%  
				       	 }  
				    }  
		    	%>  
	               
             </tbody>
	</table>


	</form>
	</div>
	

</div>
</body>
</html>