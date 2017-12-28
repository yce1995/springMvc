<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'List.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">

/*
	使用ajax
		尽量使用true 异步模式（防假死）
		尽量将获取数据之后的逻辑处理（页面渲染）放在回调函数中
*/


	function query() {
		//无刷新调用 http://localhost:8080/s/queryFood 获取数据 数据通过dom方式添加到 table()
		//ajax (异步的ajax)+json
		var xmlhttp=null;
		//	兼容多有浏览器创建这和对象 XHR对象
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//回调函数 当请求发送后 收到结果自动调用该方法
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//返回的是字符串的json
				var resu = xmlhttp.responseText;
				//转换为js对象
				var js = JSON.parse(resu);
				//获取表格对象
				var table = document.getElementById("myTable");
				//将名字为dataTr的全部删除
				var allDataTr = document.getElementsByName("dataTr");
				var length=allDataTr.length;
				for ( var i = 0; i < length; i++) {
					table.removeChild(allDataTr[0]);
				}
				for (var i = 0; i < js.length; i++) {
					var obj=js[i];
					var td=document.createElement("td");
					td.innerText=obj.foodname;
					var td1=document.createElement("td");
					td1.innerText=obj.price;
					var tr=document.createElement("tr");
					tr.setAttribute("name", "dataTr");
					tr.appendChild(td);
					tr.appendChild(td1);
					table.appendChild(tr);
				}
			}
		}
		var foodname = document.getElementsByName("foodName")[0].value;
		//open 方法表示 产生一个请求的关联（get 提交）
		//xmlhttp.open("GET", "${pageContext.request.contextPath}/queryFood?foodName="+foodname, true);
		//xmlhttp.send();
		//post提交
		/*
			一个ajax线程是否执行完成  可以通过回调函数xmlhttp.onreadystatechange  是否执行完成来判断
			异步 多个线程同时执行 无法判断 谁先执行 true
			同步 一次只允许一个线程执行 false 页面会假死
		
		*/
		
		
		
		
		xmlhttp.open("GET", "${pageContext.request.contextPath}/queryFood?foodName="+foodname, true);
		xmlhttp.send();
	}
</script>
	</head>

	<body>
		<input type="text" name="foodName" />
		<input type="button" value="查询" onclick="query()" />
		<table id="myTable">
			<tr><th>菜品</th><th>菜品价格</th></tr>
		</table>
	</body>
</html>
