<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加商品</title>
<%@ include file="/WEB-INF/public.jspf" %>>
</head>
<body>
	<!-- action就是配置提交到后台的地址，请注意在web项目中，所有的请求都需要添加工程名 -->
	<!-- *.mvc在web.xml中已经配置，只有Mvc后缀的请求才会交给Spring-mvc处理 -->
	<!-- request.getContextPath() 动态获取当前项目工程名 -->
	<form action="<%=request.getContextPath()%>/product/save.mvc"
		method="post">
		商品名称：<input type="text" name="name" /><br /> 商品价格：<input type="text"
			name="price" /><br /> 商品备注：<input type="text" name="remark" /><br />
		<button type="submit">保存</button>
	</form>
</body>
</html>