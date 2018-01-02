<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/register.css" />
<title>login</title>
</head>
<body >

<div id="content" >

		<div>
		<img src="D:/Java WorkShop/shopping/WebContent/image/2.jpg" height="160" width="414"/>
		</div>
        <form action="login" method="post">
        <div class="login-input-box">
     	I  D：
     	<input type="text"  name="user_id"  value="请&nbsp;输&nbsp;入&nbsp;I&nbsp;D"/>
     	</div>
        
       <div class="login-input-box">
                        密码：
       <input type="password"  name="password" value=" " />
       </div>
        
        <div class="login-button-box">        
      <input type="submit" class="Submit_Button" value="登&nbsp;&nbsp;录" >
		</div>

        </form>
        
       <div class="button_alt"> 
       <input type="button" name="btnAdd" onclick="javascript:window.location.href='register.jsp'" value="注&nbsp;&nbsp;册" class="button_alt_1"/>
       </div>
</div>

</body>
</html>