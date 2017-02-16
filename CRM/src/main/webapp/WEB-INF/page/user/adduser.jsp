<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="jquery/jquery.js" type="text/javascript"></script>

<script language="JavaScript" type="text/javascript" src="easyui/jquery.easyui.min.js" charset="utf-8"></script>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   <!--引入CSS样式-->
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">   <!--Icon引入-->
<link rel="stylesheet" href="icon/dist/icono.min.css">
<link rel="stylesheet" href="css/index.css">
<script language="JavaScript" type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>

<script>
  var total = 0;
  var loadPage = 20;
  var maxPage = 0;
  var isload = true;
  var reqJson = {};
  var jsonstr = {};
  var getSchool = function(param,success,error){
    $.ajax({
      url: 'School/getSchool',
      dataType: 'json',
      method:'post',
      success: function(data){
        var bases = JSON.stringify(data);
        bases = JSON.parse(bases);
        success(bases);
      },
      error: function(){

      }
    });
  }

  var getSource = function(param,success,error){
    $.ajax({
      url: 'Source/getSource',
      dataType: 'json',
      method:'post',
      success: function(data){
        var bases = JSON.stringify(data);
        bases = JSON.parse(bases);
        success(bases);
      },
      error: function(){

      }
    });
  }

  var lookGuest = function(e){
    console.log($(e).attr("uid"));
  }

  var getHtmlStr = function(data){
    var htmlStr = "<div class='guestDiv'>";
    htmlStr += "<div style='width: 95%; height: 30px; margin: 15px 20px;'>";
    if("男" == data.attr9){
      htmlStr += "<span class='nanhaizi'>"+data.attr6+"</span>";
    }else{
      htmlStr += "<span class='nvhaizi'>"+data.attr6+"</span>";
    }
    htmlStr += "<span style='color: #b6b6b6; font-weight:bold; font-size: 14px;'> "+data.attr5+"</span>";
    htmlStr += "<span><button name='look' type='button' onclick='lookGuest(this)' class='btn green' uid='"+JSON.stringify(data)+"' style='float: right'>  查 看  </button></span></div>";
    htmlStr += "<div class='guestDivNeirong'>";
    htmlStr += "<div class='neirong'>状态："+data.attr20+"</div>";
    htmlStr += "<div class='neirong'>中心："+data.attr14+"</div>";
    htmlStr += "<div class='neirong'>渠道营销专员："+data.fullname+"</div>";
    htmlStr += "<div class='neirong'>推广员："+data.fullname+"</div>";
    htmlStr += "<div class='neirong'>当前CC："+data.fullname+"</div>";
    htmlStr += "<div class='neirong'>渠道："+data.attr15+"</div>";
    htmlStr += "<div class='neirong'>推广点："+data.attr16+"</div>";
    htmlStr += "<div class='neirong'>意向产品："+data.attr17+"</div>";
    htmlStr += "<div class='neirong'>推广时间："+data.attr18+"</div>";
    htmlStr += "<div class='neirong'>到访时间："+data.attr19+"</div>";
    htmlStr += "<div class='beizhu'>备注："+data.attr21+"</div></div></div>";

    return htmlStr;
  }

  var queryData = function(){

    reqJson = {
      data: JSON.stringify(jsonstr)
    }

    $.ajax({
      url: 'Guest/getGuestByOpt',
      dataType: 'json',
      method:'post',
      data:reqJson,
      success: function(data){
        console.log("data:"+JSON.stringify(data.data));
        console.log("total:"+JSON.stringify(data.total));
        $(".loadingPNG").remove();

        for(var json in data.data){
          $("#guestList").append(getHtmlStr(data.data[json]));
        }

        total += 20;
        if(total >= data.total.total){
          total = data.total.total;
        }else{
          $("#guestList").append("<div class='loadingPNG' style='text-align: center'>"+
                  "<span><i style='color: #1995dc' class='icono-spinner spin step'></i></span>"+
                  "</div>");
        }
        $("#curNum").html(total);
        $("#countNum").html(data.total.total);
        maxPage = data.total.total;


        isload = true;

      },
      error: function(){

      }
    });
  }

  $("#btn_query").click(function(){
    var school = $("#school").combobox('getValue');
    var source = $("#source").combobox('getValue');
    var date = $("#date").combobox('getValue');
    var startdate = $("#startdate").val();
    var enddate = $("#enddate").val();
    var cname = $("#cname").val();
    var ename = $("#ename").val();
    var sex = $("#sex").val();
    var phone = $("#phone").val();
    total = 0;

    jsonstr = {
      school:school,
      source:source,
      date:date,
      startdate:startdate,
      enddate:enddate,
      cname:cname,
      ename:ename,
      sex:sex,
      phone:phone,
      beginRow:total,
      pageSize:loadPage
    }


    $("#guestList").html("");
    queryData();

  });

  $('#guestList').on('scroll',function(){
    var $this =$(this),
        viewH =$(this).height(),//可见高度
        contentH =$(this).get(0).scrollHeight,//内容高度
        scrollTop =$(this).scrollTop();//滚动高度
    //if(contentH - viewH - scrollTop <= 100) { //到达底部100px时,加载新内容
    if(scrollTop/(contentH -viewH)>=0.99){
      if(isload && maxPage > total){
        isload = false;
        console.log("这里加载数据.."+total);
        jsonstr.beginRow = total;
        queryData();
      }
      // 这里加载数据..
    } //到达底部100px时,加载新内容


  });
</script>

<div class="" style="margin: 15px;">
  <h2 style="color: #66666a">
    客户查询
  </h2>
  <div class="box">
    <div style="height: 40px; width: 100%; background: #44b6ae; color: #ffffff;line-height:40px;">
      <h3 style="margin: 0 20px;">搜索</h3>
    </div>
    <div style="background: #ffffff; padding: 20px 60px;">
      <div class="neirong1">
        <div class="ddiv">中心：</div>
        <input id="school" class="easyui-combobox"
               name="language"
               data-options="
					loader: getSchool,
					method:'post',
					valueField:'attr1',
					textField:'attr1',
					panelHeight:'auto'
			">
      </div>
      <div class="neirong1">
        <div class="ddiv">推广点：</div>
        <input id="source" class="easyui-combobox"
               name="language"
               data-options="
                    loader: getSource,
					method:'post',
					valueField:'attr1',
					textField:'attr1',
					panelHeight:'auto'
			">
      </div>
      <div class="neirong1">
        <div class="ddiv">创建日期：</div>
        <input id="startdate" class="easyui-datebox" data-options="sharedCalendar:'#cc'">
      </div>
      <div class="neirong1">
        <div class="ddiv">结束日期：</div>
        <input id="enddate" class="easyui-datebox" data-options="sharedCalendar:'#cc'">
      </div>
      <div class="neirong1">
        <div class="ddiv">中文名：</div>
        <input id="cname" class="easyui-textbox" style="">
      </div>
      <div class="neirong1">
        <div class="ddiv">英文名：</div>
        <input id="ename" class="easyui-textbox" style="">
      </div>
      <div class="neirong1">
        <div class="ddiv">出生日期：</div>
        <input id="date" class="easyui-datebox" data-options="sharedCalendar:'#cc'">
      </div>
      <div class="neirong1">
        <div class="ddiv">性别：</div>
        <input id="sex" class="easyui-textbox" style="">
      </div>
      <div class="neirong1">
        <div class="ddiv">联系方式：</div>
        <input id="phone" class="easyui-textbox" style="">
      </div>
      <div class="neirong1">
        <div class="ddiv">学校：</div>
        <input class="easyui-textbox" style="">
      </div>
      <div class="neirong1">
        <div class="ddiv">小区：</div>
        <input class="easyui-textbox" style="">
      </div>
      <div class="neirong1">
        <div class="ddiv">年级：</div>
        <input class="easyui-textbox" style="">
      </div>
      <div class="neirong1"></div>
      <table style="width: 100%">
        <tr>
          <td style="text-align: center"> <button type="button" id="btn_query" onclick="" class="btn green">  搜 索  </button> </td>
          <td style="text-align: center"> <button type="button"  onclick="" class="btn green">  重 置  </button> </td>
        </tr>
      </table>
    </div>
  </div>
  <div class="box">
    <div style="height: 55px; width: 100%; background: #44b6ae; color: #ffffff;line-height:55px;">
      <h3 style="margin: 0 20px;">客户列表 当前<span id="curNum" style="font-size: 14px;">0</span>条,共<span id="countNum" style="font-size: 14px;">0</span>条</h3>
    </div>
    <div id="guestList" style="background: #ffffff; padding: 10px; max-height: 440px; overflow: scroll; width: 100%;">

    </div>
  </div>
</div>
<div id="cc" class="easyui-calendar"></div>
<script>

</script>

