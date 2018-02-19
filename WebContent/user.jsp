<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>  
<%@page import="com.beans.Goods_bean"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/user.css" />

<title>welcom user</title>
</head>

<body>
	   
<div id="content" >
    	<div class="button_altdiv2"> 
       <input type="button" name="btnAdd" onclick="javascript:window.location.href='login'" value="退&nbsp;出" class="button_alt_2"/>
       </div>

<div class = "buyform">

<form action="BuyGoods" method="post">

<div class = "title">选择购买商品及数量</div>

        <div class="login-input-box">
     	商品名：
     	<input type="text"  name="goods_name"  value="请&nbsp;输&nbsp;入&nbsp;商&nbsp;品"/>
     	</div>
     	
     	<div class="login-input-box">
     	数量：
     	<input type="text"  name="number"  value="数&nbsp;&nbsp;量"/>
     	</div>
     	
     <div class= "select">
	 <input ID="testButton" type="submit" class="Button" value="购&nbsp;买" >
 	</div>

</form>
</div>

<div>
<form action="selectgoods" method="post">

	<div class= "select">
	 <input type="submit" class="Button" value="查询" >
 	</div>
 	
 	
	<table summary="book list">
            <caption>Book List</caption> <!-- caption 标签必须紧随 table 标签之后。您只能对每个表格定义一个标题。通常这个标题会被居中于表格之上。 -->
            <col></col><col></col><col></col><col class="price" align="right"></col><col></col>
            <thead>
                <tr>
                    <th width="279" >商品</th>
                    <th width="149" >价格</th>
                    <th width="176" >库存</th>
                </tr>
            </thead>    
            <tbody>
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