<%@ page import="java.util.Map" %>
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
            background-image: url("<%=basePath%>img/bg.png");
        }
    </style>

    <script src="<%=basePath%>jquery/jquery.js" type="text/javascript"></script>

    <script language="JavaScript" type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js" charset="utf-8"></script>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">   <!--引入CSS样式-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">   <!--Icon引入-->
    <link rel="stylesheet" href="<%=basePath%>icon/dist/icono.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/index.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/msg/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/msg/dist/notyf.min.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/input/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/input/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/input/css/component.css" />

    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/date2/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/date2/css/daterangepicker.css" />

    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/table/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/table/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/table/css/basictable.css" />

    <link rel="stylesheet" type="text/css" href="<%=basePath%>libs/alert2/dist/jquery.popuplayer.min.css">

    <%--<link rel='stylesheet' type='text/css' href='<%=basePath%>libs/alert3/css/app.css'/>--%>
    <%--<link rel='stylesheet' type='text/css' href='<%=basePath%>libs/alert3/css/ply.css'/>--%>

    <script>
        $(document).ready(function() {
            $('.inactive').click(function(){
                if($(this).siblings('ul').css('display')=='none'){
                    $(this).parent('li').siblings('li').removeClass('inactives');
                    $(this).addClass('inactives');
                    $(this).siblings('ul').slideDown(100).children('li');
                    if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
                        $(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
                        $(this).parents('li').siblings('li').children('ul').slideUp(100);

                    }
                }else{
                    //控制自身变成+号
                    $(this).removeClass('inactives');
                    //控制自身菜单下子菜单隐藏
                    $(this).siblings('ul').slideUp(100);
                    //控制自身子菜单变成+号
                    $(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
                    //控制自身菜单下子菜单隐藏
                    $(this).siblings('ul').children('li').children('ul').slideUp(100);
                    //控制同级菜单只保持一个是展开的（-号显示）
                    $(this).siblings('ul').children('li').children('a').removeClass('inactives');
                }
            })
        });

    </script>


    <title>CRM 企业管理系统</title>
</head>
<body>

<div class="topDiv"><img src="img/footlogo.png" style="height: 60px;"></div>
<div class="leftDiv">
    <div class="list">
        <ul class="yiji" id="mainMenu">
            <li><a href="javascript:void(0);" class="active">首页</a>

            </li>
            <li style="display: none;" name="khgl"><a href="javascript:void(0);" class="inactive">客户管理</a>
                <ul style="display: none;" id="khgl">

                </ul>
            </li>
            <li style="display: none;" name="xtsz"><a href="javascript:void(0);" class="inactive">系统设置</a>
                <ul style="display: none" id="xtsz">

                </ul>
            </li>
        </ul>
    </div>

</div>
<div class="rightDiv"></div>
<script src="<%=basePath%>libs/msg/dist/notyf.min.js" type="text/javascript"></script>
<script src="<%=basePath%>libs/input/js/classie.js" type="text/javascript"></script>

<script src="<%=basePath%>libs/date2/js/moment.min.js"></script>
<script src="<%=basePath%>libs/date2/js/jquery.daterangepicker.js"></script>

<script src="<%=basePath%>libs/alert2/dist/jquery.popuplayer.min.js"></script>

<script type="text/javascript" src="<%=basePath%>libs/alert3/js/Ply.js"></script>

<script language="JavaScript" type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>

<script>
    $(function(){
        $abb_temp1 = null;

        $.ajax({
            url: 'getMenu',
            dataType: 'json',
            method:'post',
            data:{menuid:"1"},
            success: function(data){
                if(data.isSucc == "true"){
                    console.log(data.data.length);
                    for(var i in data.data){
                        console.log(JSON.stringify(data.data[i]));
                        $("#khgl").append("<li><a href='javascript:void(0);' name='"+data.data[i].ename+"' url='"+data.data[i].url+"' class='active'>"+data.data[i].name+"</a></li>");
                    }
                    if(data.data.length > 0){
                        $("li[name='khgl']").show();
                        $("li[name='khgl'] .active").click(onActive);
                    }
                }
            },
            error: function(){

            }
        });

        $.ajax({
            url: 'getMenu',
            dataType: 'json',
            method:'post',
            data:{menuid:"2"},
            success: function(data){
                if(data.isSucc == "true"){
                    console.log(data.data.length);
                    for(var i in data.data){
                        console.log(JSON.stringify(data.data[i]));
                        $("#xtsz").append("<li><a href='javascript:void(0);' name='"+data.data[i].ename+"' url='"+data.data[i].url+"' class='active'>"+data.data[i].name+"</a></li>");
                    }
                    if(data.data.length > 0){
                        $("li[name='xtsz']").show();
                        $("li[name='xtsz'] .active").click(onActive);
                    }
                }
            },
            error: function(){

            }
        });

        $.ajax({
            url: 'getMenu',
            dataType: 'json',
            method:'post',
            data:{menuid:"3"},
            success: function(data){
                if(data.isSucc == "true"){
                    console.log(data.data.length);
                    for(var i in data.data){
                        console.log(JSON.stringify(data.data[i]));
                        $("#xtsz").append("<li><a href='javascript:void(0);' name='"+data.data[i].ename+"' url='"+data.data[i].url+"' class='active'>"+data.data[i].name+"</a></li>");
                    }
                    if(data.data.length > 0){
                        $("li[name='xtsz']").show();
                        $("li[name='xtsz'] .active").click(onActive);
                    }
                }
            },
            error: function(){

            }
        });

        $.ajax({
            url: 'getMenu',
            dataType: 'json',
            method:'post',
            data:{menuid:"4"},
            success: function(data){
                if(data.isSucc == "true"){
                    console.log(data.data.length);
                    for(var i in data.data){
                        console.log(JSON.stringify(data.data[i]));
                        $("#xtsz").append("<li><a href='javascript:void(0);' name='"+data.data[i].ename+"' url='"+data.data[i].url+"' class='active'>"+data.data[i].name+"</a></li>");
                    }
                    if(data.data.length > 0){
                        $("li[name='xtsz']").show();
                        $("li[name='xtsz'] .active").click(onActive);
                    }
                }
            },
            error: function(){

            }
        });

        var onActive = function(e){
            console.log($(e.target).attr("name"));
            $.ajax({
                url: $(e.target).attr("url"),
                type: "POST",
                success: function(data){
                    $(".rightDiv").html(data);
                }
            });
        }

        $(".leftDiv").height($(window).height()-60);
        $(".rightDiv").width($(window).width()-220);
        $(".rightDiv").height($(window).height()-60);
        $(window).resize(function(){
            $(".leftDiv").height($(window).height()-60);
            $(".rightDiv").width($(window).width()-220);
            $(".rightDiv").height($(window).height()-60);
        });

        //公共方法

        $.notNull = function(str){
            return str != null?str:""
        };

        dateContrast = function(dateTime){

            var cutDate = new Date(dateTime);
            var nowDate = new Date();

            var jsonstr = {
                attr1:"BHQ1"
            };

            $.ajax({
                url: 'Query/queryBhqByattr1',
                dataType: 'json',
                method: 'post',
                async: false,
                data:jsonstr,
                success: function (data) {
                    cutDate.setDate(cutDate.getDate()+parseInt(data[0].attr2));
                },
                error: function () {

                }
            });

            if(nowDate-cutDate > 0){
                return false;
            }else{
                return true;
            }
        };

        dateContrast1 = function(dateTime){

            var cutDate = new Date(dateTime);
            var nowDate = new Date();

            var jsonstr = {
                attr1:"BHQ2"
            };

            $.ajax({
                url: 'Query/queryBhqByattr1',
                dataType: 'json',
                method: 'post',
                async: false,
                data:jsonstr,
                success: function (data) {
                    cutDate.setDate(cutDate.getDate()+parseInt(data[0].attr2));
                },
                error: function () {

                }
            });

            if(nowDate-cutDate > 0){
                return false;
            }else{
                return true;
            }
        };

        dateContrast2 = function(dateTime){

            var cutDate = new Date(dateTime);
            var nowDate = new Date();

            var jsonstr = {
                attr1:"BHQ3"
            };

            $.ajax({
                url: 'Query/queryBhqByattr1',
                dataType: 'json',
                method: 'post',
                async: false,
                data:jsonstr,
                success: function (data) {
                    cutDate.setDate(cutDate.getDate()+parseInt(data[0].attr2));
                },
                error: function () {

                }
            });

            if(nowDate-cutDate > 0){
                return false;
            }else{
                return true;
            }
        };

        lookGuest0 = function(e){
            $abb_temp1 = $(e).attr("uid");
            $.ajax({
                url: "guestdetail0",
                type: "POST",
                success: function(data){
                    $(".rightDiv").html(data);
                }
            });
        }

        lookGuest = function(e){
            $abb_temp1 = $(e).attr("uid");
            $.ajax({
                url: "guestdetail",
                type: "POST",
                success: function(data){
                    $(".rightDiv").html(data);
                }
            });
        }

        lookGuest1 = function(e){
            $abb_temp1 = $(e).attr("uid");
            $.ajax({
                url: "guestdetail1",
                type: "POST",
                success: function(data){
                    $(".rightDiv").html(data);
                }
            });
        }

        getInput = function(opt){
            var inputHtml = "<span class='input input--isao'>";
            inputHtml+= "<input class='input__field input__field--isao' type='text' stype='"+opt.stype+"' id='input-query' />";
            inputHtml+= "<label class='input__label input__label--isao' for='input-28' data-content="+opt.title+">";
            inputHtml+= "<span class='input__label-content input__label-content--isao'>"+opt.title+"</span>";
            inputHtml+= "</label></span>";
            return inputHtml;
        }

        getButton = function(title,callBack){
            var button = $("<button type='button' class='btn green'> "+title+" </button>");
            button.click(callBack);
            return button;
        }

        var QueryBox = function QueryBox(elem, opt) {
            this.$elem = $(elem);

            this.$mainDiv = $("<div class='xWindows'></div>");
            this.$topDiv = $("<div class='queryDdiv21'></div>");
            this.$bottomDiv = $("<div class='queryDdiv22'></div>");

            this.defaults = {
                url:"Query/querySchoolByattr1",
                title: "搜索",
                queryCallBack: null
            }

            // 合并默认参数和自定义参数
            this.options = $.extend({}, this.defaults, opt);

            this.$span1 = $("<span class='input input--isao'></span>");
            this.$input1 = $("<input class='input__field input__field--isao' type='text' id='input-query' />");
            this.$label1 = $("<label class='input__label input__label--isao' for='input-28' data-content="+this.options.title+"></label>");
            this.$span2 = $("<span class='input__label-content input__label-content--isao'>"+this.options.title+"</span>");

        }

        QueryBox.prototype = {
            init: function init() {
                this.attachElems();
                this.bindEvents();
                this.queryMe();
            },
            attachElems: function attachElems() {
                //this.$elem.after(this.$mainDiv);
                this.$label1.append(this.$span2);
                this.$span1.append(this.$input1);
                this.$span1.append(this.$label1);

                this.$topDiv.append(this.$span1);
                this.$mainDiv.append(this.$topDiv);
                this.$mainDiv.append(this.$bottomDiv);
                this.$mainDiv.hide();
                this.$elem.after(this.$mainDiv);

            },
            bindEvents: function bindEvents() {
                var that = this;
                this.$elem.click(function () {
                    that.open();
                });

                this.$mainDiv.click(function () {
                    return false;
                });

                this.$input1.keyup(function(){
                    that.queryMe({attr1:that.$input1.val()});
                });

                $("body").click(function(e){
                    if($(e.target).attr('class') != that.$elem.attr('class')){
                        that.close();
                    }
                });
            },
            open: function open() {
                this.$mainDiv.show();
            },
            close: function close(){
                this.$mainDiv.hide();
            },
            queryMe: function(reqDate){
                var that = this;
                $.ajax({
                    url: that.options.url,
                    dataType: 'json',
                    method:'post',
                    data:reqDate,
                    success: function(data){
                        that.$bottomDiv.html("");
                        for(var temp in data){
                            var a = $("<a class='queryDdiv221a' href='javascript:void(0);' sname='"+data[temp].attr1+"' sid='"+data[temp].sid+"'>"+data[temp].attr1+"</a>");
                            var div41 = $("<div class='queryDdiv221' ></div>");
                            a.click(function(eve){
                                that.$elem.val($(eve.target).attr("sname"));
                                that.$elem.attr("sname",$(eve.target).attr("sname"));
                                that.$elem.attr("sid",$(eve.target).attr("sid"));
                                if(that.options.queryCallBack){
                                    that.options.queryCallBack();
                                }
                                that.close();
                            });
                            div41.html(a);
                            that.$bottomDiv.append(div41);
                        }
                    },
                    error: function(){

                    }
                });
            }
        }

        $.fn.QueryBox = function (options) {
            return this.each(function () {
                new QueryBox(this, options).init();
            });
        };

        var QueryUserBox = function QueryUserBox(elem, opt) {
            this.$elem = $(elem);

            this.$mainDiv = $("<div class='xWindows'></div>");
            this.$topDiv = $("<div class='queryDdiv21'></div>");
            this.$bottomDiv = $("<div class='queryDdiv22'></div>");

            this.defaults = {
                url:"Query/querySchoolByattr1",
                title: "搜索",
                queryCallBack: null
            }

            // 合并默认参数和自定义参数
            this.options = $.extend({}, this.defaults, opt);

            this.$span1 = $("<span class='input input--isao'></span>");
            this.$input1 = $("<input class='input__field input__field--isao' type='text' id='input-query' />");
            this.$label1 = $("<label class='input__label input__label--isao' for='input-28' data-content="+this.options.title+"></label>");
            this.$span2 = $("<span class='input__label-content input__label-content--isao'>"+this.options.title+"</span>");

        }

        QueryUserBox.prototype = {
            init: function init() {
                this.attachElems();
                this.bindEvents();
                this.queryMe();
            },
            attachElems: function attachElems() {
                //this.$elem.after(this.$mainDiv);
                this.$label1.append(this.$span2);
                this.$span1.append(this.$input1);
                this.$span1.append(this.$label1);

                this.$topDiv.append(this.$span1);
                this.$mainDiv.append(this.$topDiv);
                this.$mainDiv.append(this.$bottomDiv);
                this.$mainDiv.hide();
                this.$elem.after(this.$mainDiv);

            },
            bindEvents: function bindEvents() {
                var that = this;
                this.$elem.click(function () {
                    that.open();
                });

                this.$mainDiv.click(function () {
                    return false;
                });

                this.$input1.keyup(function(){
                    that.queryMe({attr1:that.$input1.val()});
                });

                $("body").click(function(e){
                    if($(e.target).attr('class') != that.$elem.attr('class')){
                        that.close();
                    }
                });
            },
            open: function open() {
                this.$mainDiv.show();
            },
            close: function close(){
                this.$mainDiv.hide();
            },
            queryMe: function(reqDate){
                var that = this;
                $.ajax({
                    url: that.options.url,
                    dataType: 'json',
                    method:'post',
                    data:reqDate,
                    success: function(data){
                        that.$bottomDiv.html("");
                        for(var temp in data){
                            var a = $("<a class='queryDdiv221a' href='javascript:void(0);' sname='"+data[temp].attr3+"' sid='"+data[temp].uid+"'>"+data[temp].attr3+"</a>");
                            var div41 = $("<div class='queryDdiv221' ></div>");
                            a.click(function(eve){
                                that.$elem.val($(eve.target).attr("sname"));
                                that.$elem.attr("sname",$(eve.target).attr("sname"));
                                that.$elem.attr("sid",$(eve.target).attr("sid"));
                                if(that.options.queryCallBack){
                                    that.options.queryCallBack();
                                }
                                that.close();
                            });
                            div41.html(a);
                            that.$bottomDiv.append(div41);
                        }
                    },
                    error: function(){

                    }
                });
            }
        };

        $.fn.QueryUserBox = function (options) {
            return this.each(function () {
                new QueryUserBox(this, options).init();
            });

        }

        telphone = function(num){
            return num.replace(/(\d{3})\d{4}(\d{4})/, '$1****$2');
        }

        getHtml01Str = function(data){
            var htmlStr = "<div class='portlet'>";
            htmlStr += "<div class='portlet-title'>";
            htmlStr += "<div class='portlet-title-name'>";
            if("男" == $.notNull(data.attr9)){
                htmlStr += "<span class='nanhaizi'>"+$.notNull(data.attr6)+"</span>";
            }else{
                htmlStr += "<span class='nvhaizi'>"+$.notNull(data.attr6)+"</span>";
            }
            htmlStr += "<span style='color: #b6b6b6; font-weight:bold; font-size: 14px;'> "+$.notNull(data.attr5)+"</span>";
            htmlStr += "</div>";
            htmlStr += "<div class='portlet-title-action'>";
            htmlStr += "<button name='look' type='button' onclick='lookGuest(this)' class='btn green' uid='"+data.uid+"'>  查 看  </button>";
            htmlStr += "</div></div>";
            htmlStr += "<div class='portlet-note'>";
            htmlStr += "<p><span >状态："+$.notNull(data.state)+"</span></p>";
            htmlStr += "<p><span >中心："+$.notNull(data.schoolName)+"</span></p>";
            htmlStr += "<p><span >电话专员："+$.notNull(data.tmk)+"</span></p>";
            htmlStr += "<p><span >推广员："+$.notNull(data.mk)+"</span></p>";
            htmlStr += "<p><span >当前CC："+$.notNull(data.cc)+"</span></p>";
            htmlStr += "<p><span >联系方式："+telphone($.notNull(data.attr10))+"</span></p>";
            htmlStr += "<p><span >渠道："+$.notNull(data.qudao)+"</span></p>";
            htmlStr += "<p><span >推广点："+$.notNull(data.tuiguangdian)+"</span></p>";
            htmlStr += "<p><span >意向产品："+$.notNull(data.yixiangchanpin)+"</span></p>";
            htmlStr += "<p><span >推广时间："+$.notNull(data.attr22)+"</span></p>";
            htmlStr += "<p><span >到访时间："+$.notNull(data.attr23)+"</span></p>";
            if(dateContrast(data.attr22)){
                htmlStr += "<p><span style='color: #c9302c;'>保护期内</span></p>";
            }else{
                htmlStr += "<p><span style='color: #2cc930;'>保护期外</span></p>";
            }

            htmlStr += "<span>备注："+$.notNull(data.attr18)+"</span>"
            htmlStr += "</div>";
            htmlStr += "</div>";

            return htmlStr;
        }

        getHtml02Str = function(data){
            var htmlStr = "<div class='portlet'>";
                htmlStr += "<div class='portlet-title'>";
                    htmlStr += "<div class='portlet-title-name'>";
                        if("男" == $.notNull(data.attr9)){
                            htmlStr += "<span class='nanhaizi'>"+$.notNull(data.attr6)+"</span>";
                        }else{
                            htmlStr += "<span class='nvhaizi'>"+$.notNull(data.attr6)+"</span>";
                        }
                        htmlStr += "<span style='color: #b6b6b6; font-weight:bold; font-size: 14px;'> "+$.notNull(data.attr5)+"</span>";
                    htmlStr += "</div>";
                    htmlStr += "<div class='portlet-title-action'>";
                        htmlStr += "<button name='look' type='button' onclick='lookGuest0(this)' class='btn green' uid='"+data.uid+"'>  查 看  </button>";
                    htmlStr += "</div></div>";
            htmlStr += "<div class='portlet-note'>";
            htmlStr += "<p><span >状态："+$.notNull(data.state)+"</span></p>";
            htmlStr += "<p><span >中心："+$.notNull(data.schoolName)+"</span></p>";
            htmlStr += "<p><span >电话专员："+$.notNull(data.tmk)+"</span></p>";
            htmlStr += "<p><span >推广员："+$.notNull(data.mk)+"</span></p>";
            htmlStr += "<p><span >当前CC："+$.notNull(data.cc)+"</span></p>";
            htmlStr += "<p><span >联系方式："+$.notNull(data.attr10)+"</span></p>";
            htmlStr += "<p><span >渠道："+$.notNull(data.qudao)+"</span></p>";
            htmlStr += "<p><span >推广点："+$.notNull(data.tuiguangdian)+"</span></p>";
            htmlStr += "<p><span >意向产品："+$.notNull(data.yixiangchanpin)+"</span></p>";
            htmlStr += "<p><span >推广时间："+$.notNull(data.attr22)+"</span></p>";
            htmlStr += "<p><span >到访时间："+$.notNull(data.attr23)+"</span></p>";
            if(dateContrast(data.attr22)){
                htmlStr += "<p><span style='color: #c9302c;'>保护期内</span></p>";
            }else{
                htmlStr += "<p><span style='color: #2cc930;'>保护期外</span></p>";
            }

            htmlStr += "<span>备注："+$.notNull(data.attr18)+"</span>"
            htmlStr += "</div>";
            htmlStr += "</div>";

            return htmlStr;
        }

        getHtml11Str = function(data){
            var htmlStr = "<div class='portlet'>";
            htmlStr += "<div class='portlet-title'>";
            htmlStr += "<div class='portlet-title-name'>";
            if("男" == $.notNull(data.attr9)){
                htmlStr += "<span class='nanhaizi'>"+$.notNull(data.attr6)+"</span>";
            }else{
                htmlStr += "<span class='nvhaizi'>"+$.notNull(data.attr6)+"</span>";
            }
            htmlStr += "<span style='color: #b6b6b6; font-weight:bold; font-size: 14px;'> "+$.notNull(data.attr5)+"</span>";
            htmlStr += "</div>";
            htmlStr += "<div class='portlet-title-action'>";
            htmlStr += "</div></div>";
            htmlStr += "<div class='portlet-note'>";
            htmlStr += "<p><span >状态："+$.notNull(data.state)+"</span></p>";
            htmlStr += "<p><span >中心："+$.notNull(data.schoolName)+"</span></p>";
            htmlStr += "<p><span >电话专员："+$.notNull(data.tmk)+"</span></p>";
            htmlStr += "<p><span >推广员："+$.notNull(data.mk)+"</span></p>";
            htmlStr += "<p><span >当前CC："+$.notNull(data.cc)+"</span></p>";
            htmlStr += "<p><span >联系方式："+telphone($.notNull(data.attr10))+"</span></p>";
            htmlStr += "<p><span >渠道："+$.notNull(data.qudao)+"</span></p>";
            htmlStr += "<p><span >推广点："+$.notNull(data.tuiguangdian)+"</span></p>";
            htmlStr += "<p><span >意向产品："+$.notNull(data.yixiangchanpin)+"</span></p>";
            htmlStr += "<p><span >推广时间："+$.notNull(data.attr22)+"</span></p>";
            htmlStr += "<p><span >到访时间："+$.notNull(data.attr23)+"</span></p>";
            if(dateContrast(data.attr22)){
                htmlStr += "<p><span style='color: #c9302c;'>保护期内</span></p>";
            }else{
                htmlStr += "<p><span style='color: #2cc930;'>保护期外</span></p>";
            }

            htmlStr += "<span>备注："+$.notNull(data.attr18)+"</span>"
            htmlStr += "</div>";
            htmlStr += "</div>";

            return htmlStr;
        }

        getHtml12Str = function(data){
            var htmlStr = "<div class='portlet'>";
            htmlStr += "<div class='portlet-title'>";
            htmlStr += "<div class='portlet-title-name'>";
            if("男" == $.notNull(data.attr9)){
                htmlStr += "<span class='nanhaizi'>"+$.notNull(data.attr6)+"</span>";
            }else{
                htmlStr += "<span class='nvhaizi'>"+$.notNull(data.attr6)+"</span>";
            }
            htmlStr += "<span style='color: #b6b6b6; font-weight:bold; font-size: 14px;'> "+$.notNull(data.attr5)+"</span>";
            htmlStr += "</div>";
            htmlStr += "<div class='portlet-title-action'>";
            htmlStr += "</div></div>";
            htmlStr += "<div class='portlet-note'>";
            htmlStr += "<p><span >状态："+$.notNull(data.state)+"</span></p>";
            htmlStr += "<p><span >中心："+$.notNull(data.schoolName)+"</span></p>";
            htmlStr += "<p><span >电话专员："+$.notNull(data.tmk)+"</span></p>";
            htmlStr += "<p><span >推广员："+$.notNull(data.mk)+"</span></p>";
            htmlStr += "<p><span >当前CC："+$.notNull(data.cc)+"</span></p>";
            htmlStr += "<p><span >联系方式："+$.notNull(data.attr10)+"</span></p>";
            htmlStr += "<p><span >渠道："+$.notNull(data.qudao)+"</span></p>";
            htmlStr += "<p><span >推广点："+$.notNull(data.tuiguangdian)+"</span></p>";
            htmlStr += "<p><span >意向产品："+$.notNull(data.yixiangchanpin)+"</span></p>";
            htmlStr += "<p><span >推广时间："+$.notNull(data.attr22)+"</span></p>";
            htmlStr += "<p><span >到访时间："+$.notNull(data.attr23)+"</span></p>";
            if(dateContrast(data.attr22)){
                htmlStr += "<p><span style='color: #c9302c;'>保护期内</span></p>";
            }else{
                htmlStr += "<p><span style='color: #2cc930;'>保护期外</span></p>";
            }

            htmlStr += "<span>备注："+$.notNull(data.attr18)+"</span>"
            htmlStr += "</div>";
            htmlStr += "</div>";

            return htmlStr;
        }

        getHtml2Str = function(data){
            var htmlStr = "<div class='portlet'>";
            htmlStr += "<div class='portlet-title'>";
            htmlStr += "<div class='portlet-title-name'>";
            if("男" == $.notNull(data.attr9)){
                htmlStr += "<span class='nanhaizi'>"+$.notNull(data.attr6)+"</span>";
            }else{
                htmlStr += "<span class='nvhaizi'>"+$.notNull(data.attr6)+"</span>";
            }
            htmlStr += "<span style='color: #b6b6b6; font-weight:bold; font-size: 14px;'> "+$.notNull(data.attr5)+"</span>";
            htmlStr += "</div>";
            htmlStr += "<div class='portlet-title-action'>";
            htmlStr += "</div></div>";
            htmlStr += "<div class='portlet-note'>";
            htmlStr += "<p><span >状态："+$.notNull(data.state)+"</span></p>";
            htmlStr += "<p><span >中心："+$.notNull(data.schoolName)+"</span></p>";
            htmlStr += "<p><span >电话专员："+$.notNull(data.tmk)+"</span></p>";
            htmlStr += "<p><span >推广员："+$.notNull(data.mk)+"</span></p>";
            htmlStr += "<p><span >当前CC："+$.notNull(data.cc)+"</span></p>";
            htmlStr += "<p><span >联系方式："+$.notNull(data.attr10)+"</span></p>";
            htmlStr += "<p><span >渠道："+$.notNull(data.qudao)+"</span></p>";
            htmlStr += "<p><span >推广点："+$.notNull(data.tuiguangdian)+"</span></p>";
            htmlStr += "<p><span >意向产品："+$.notNull(data.yixiangchanpin)+"</span></p>";
            htmlStr += "<p><span >推广时间："+$.notNull(data.attr22)+"</span></p>";
            htmlStr += "<p><span >到访时间："+$.notNull(data.attr23)+"</span></p>";
            if(dateContrast(data.attr22)){
                htmlStr += "<p><span style='color: #c9302c;'>保护期内</span></p>";
            }else{
                htmlStr += "<p><span style='color: #2cc930;'>保护期外</span></p>";
            }

            htmlStr += "<span>备注："+$.notNull(data.attr18)+"</span>"
            htmlStr += "</div>";
            htmlStr += "</div>";

            return htmlStr;
        }
    });
</script>

</body>
</html>