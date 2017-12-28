<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<script type="text/javascript">
  		function checkSubmit(){
  			//校验不通过不提交
  			/*var userName=document.getElementsByName("userName")[0].value;
  			if(userName==null || userName==""){
  				alert("用户名不能为空");
  				return;
  			}
  			var password=document.getElementsByName("password")[0].value;
  			var repassword=document.getElementsByName("repassword")[0].value;
  			if(password!=repassword){
  				alert("两次密码不一致");
  				return;
  			}*/	
  			document.forms[0].submit();
  		}
  	</script>
  </head>
  <body>
   	<form action="<%=path %>/regs" method="post">
  		用户名：<input type="text" name="userName"/>
  			<font color="red"><form:errors path="regBean.userName"></form:errors></font>
  			<br/>
  		密码：<input type="text" name="password"/>
  			<font color="red"><form:errors path="regBean.password"></form:errors></font>
  			<br/>
  		确认密码：<input type="text" name="repassword"/>
  			<font color="red"><form:errors path="regBean.repassword"></form:errors></font>
  			<br/>
  		邮件：<input type="text" name="email"/>
  			<font color="red"><form:errors path="regBean.email"></form:errors></font>
  			<br/>
  		年龄：<input type="text" name="age"/>
  			<font color="red"><form:errors path="regBean.age"></form:errors></font>
  			<br/>
  		手机：<input type="text" name="phone"/>
  			<font color="red"><form:errors path="regBean.phone"></form:errors></font>
  			<br/>
  			<input type="button" onclick="checkSubmit()" value="注册" />
  	</form>
  </body>
</html>
