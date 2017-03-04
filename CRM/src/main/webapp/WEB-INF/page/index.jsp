<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/19
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/index.css">
    <link href="css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>
    <link href="css/iziToast.css" rel="stylesheet" type="text/css"/>
    <link href="css/notyf.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="header" style=" z-index: 999; width: 100%; position: fixed; top: 0px; left: 0px;">

</div>

<!--菜单展示-->
<div class="body" style="margin-top: 48px;overflow: hidden;">


    <div style="float: left;width:100%;"><!--右侧各业务内容-->
        <div id="rightdiv" class="body-right" style="margin-bottom: -1000px;padding-bottom: 1000px;">

        </div>
    </div>
    <div id="leftmenu" style="float: left;margin-left: -100%;">

    </div>
    <!--左侧菜单显示-->

    <div id="mainbotton" style="position: fixed;bottom:0px;overflow: hidden;width: 100%;
    min-width: 1024px;
    background-color: #3E5775;
    height: 48px; clear: both;">
        <div style="bottom: 10px;position: absolute;left: 40%;">
            <table style="width:100%;">

            </table>
            <div style="display: block;color: #FFF;font-size: 16px;">© 1998-2016 空中英语 版权所有 &nbsp;</div>
            <div style=" text-align: center;"><a style="color: #FFF;" href="http://www.miitbeian.gov.cn"
                                                 target="_blank"></a></div>
        </div>
    </div>

</div>
</body>
</html>
<script data-main="js/main" src="js/libs/require/require.js"></script>