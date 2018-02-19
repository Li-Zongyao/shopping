<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>  
<%@page import="com.beans.Buy_bean"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/admin.css" />
<title>buy form</title>
</head>
<body>
<div id="content" >
    	<div class="button_altdiv2"> 
       <input type="button" name="btnAdd" onclick="javascript:window.location.href='login'" value="退&nbsp;出" class="button_alt_2"/>
       </div>
<div class="button_alt"> 
<input type="button" name="btnAdd" onclick="javascript:window.location.href='admin.jsp'" value="信&nbsp;息&nbsp;管&nbsp;理" class="button_alt_1"/>
</div>
<div>
<form action="selectgoodsbuyform" method="post" >

	<div class= "select" style="margin:10px 10px;">
	 <input type="submit" class="Button" value="查询" >
 	</div>
 	
 	
	<table summary="book list" class="table1">
            <caption>Book List</caption> <!-- caption 标签必须紧随 table 标签之后。您只能对每个表格定义一个标题。通常这个标题会被居中于表格之上。 -->
            <col></col><col></col><col></col><col class="price" align="right"></col><col></col>
            <thead>
                <tr>
                    <th width="279" >时间</th>
                    <th width="149" >商品</th>
                    <th width="176" >数量</th>
                </tr>
            </thead>    
            <tbody class="table_tbody">
	             <%  
		    
				    ArrayList<Buy_bean>  buysList = (ArrayList<Buy_bean>)request.getAttribute("buylist"); 
			
				    if(buysList!=null){  
				        for(Buy_bean buy : buysList){  
				            //String goodsinfo = goods.getGoods_name()+"---"+goods.getPrices()+"---"+goods.getStock(); 
				            String Time = buy.getTime();
				            String Goods_name = buy.getGoods_name();
				            int Number = buy.getNumber();
				            %>  
				            
				            <tr class="odd">
			                    <th><%=Time%></th>
			                    <td><%=Goods_name%></td>
			                    <td><%=Number%></td>
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