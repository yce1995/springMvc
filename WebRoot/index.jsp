<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  	<script type="text/javascript">
  		function checkSubmit(){
  			//校验不通过不提交
  			if（）{
  			
  			}
  		
  			doucument.froms[0].submit();
  		}
  	</script>
  <body>
   	<form action="<%=path%>/regs" method="post">
  		用户名：<input type="text" name="userName"/><br/>
  		密码：<input type="text" name="password"/><br/>
  		邮件：<input type="text" name="email"/><br/>
  		年龄：<input type="text" name="age"/><br/>
  		手机：<input type="text" name="phoen"/><br/>
  			<input type="button" value="注册"/>
  	</form>
  </body>
</html>
