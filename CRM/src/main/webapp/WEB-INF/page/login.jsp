<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<head>
  <style>
    body{
      width: 96%;
      background-image: url("<%=basePath%>img/bg.png");
      min-width: 768px;
      min-height: 400px;
    }
    #loginDiv{
      width: 744px;
      height: 394px;
      background-image: url("<%=basePath%>img/login.png");
      margin:0 auto;
    }
  </style>
  <script src="jquery/jquery.js" type="text/javascript"></script>
  <script>
    var href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}";
  </script>
  <title>CRM 企业管理系统</title>
</head>
<body style="text-align: center;">
<div style="width: 100%; height: 200px;">

</div>
<div id="loginDiv">
  <div style="padding: 180px; color: #ffffff">
    <form action="login" method="post">
      <div>用户：<input id="username" name="username" type="text"></div>
      <div>密码：<input id="password" name="password" type="password"></div>
      <div style="padding: 10px;">
        <input id="login" type="submit" value="登陆">
      </div>
      <div id="loginMsg" style="padding: 100px 0 0 0 ;color: #ff0000;display: block;">
        <%= null != request.getAttribute("loginErr")?request.getAttribute("loginErr"):""%>
      </div>

    </form>
  </div>
</div>
<div style="height: 200px;line-height:50px; color: #cccccc"> ©2017 空中英语语言培训有限公司 版权所有</div>
</body>
<script>

</script>
</html>