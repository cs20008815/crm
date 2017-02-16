<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/21
  Time: 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="" style="margin: 15px;">
  <h2 style="color: #66666a">
    客户详情
  </h2>
  <div class="box">
    <div id="action" style="background: #ffffff; padding: 10px; max-height: 840px; width: 100%;">
      <button type="button" id="genjin" onclick="" class="btn blue">  跟 进  </button>
      <button type="button" id="yuyue" onclick="" class="btn blue">  预 约  </button>
      <button type="button" id="wuxiao" onclick="" class="btn blue">  无 效  </button>
    </div>
  </div>
  <div class="left-box">
    <div class="box">
      <div style="height: 40px; width: 100%; background: #44b6ae; color: #ffffff;line-height:40px;">
        <h3 style="margin: 0 20px;">基本信息</h3>
      </div>
      <div id="jibenxinxi" style="background: #ffffff; padding: 10px; max-height: 840px; width: 100%;">

      </div>
    </div>
    <div class="box">
      <div style="height: 40px; width: 100%; background: #44b6ae; color: #ffffff;line-height:40px;">
        <h3 style="margin: 0 20px;">跟进信息</h3>
      </div>
      <div id="goutonglist" style="background: #ffffff; padding: 10px; max-height: 380px; overflow: auto; width: 100%;">

      </div>
    </div>
  </div>
  <div class="right-box">
    <div class="box">
      <div style="height: 40px; width: 100%; background: #44b6ae; color: #ffffff;line-height:40px;">
        <h3 style="margin: 0 20px;">预约信息</h3>
      </div>
      <div style="background: #ffffff; padding: 10px; width: 100%;">

        <div id="genjinxinxi" style="max-height: 350px; overflow: auto;margin: 5px 0 0 0;background: #ffffff;">

        </div>
      </div>
    </div>
  </div>
</div>
<script>
  $(function() {
    $.ajax({
      url: "addguestfollow",
      type: "POST",
      success: function(data){
        $('#yuyue').PopupLayer({
          content: data,
          to: 'left',
          closeBtn:$("#addyuyue1"),
          closeCallback:queryGuest2Data,
          blur: true
        });
      }
    });

    $.ajax({
      url: "addguestfollow1",
      type: "POST",
      success: function(data){
        $('#genjin').PopupLayer({
          content: data,
          to: 'bottom',
          closeBtn:$("#addgoutong1"),
          closeCallback:queryGuest1Data,
          blur: true
        });
      }
    });

    var queryData = function(){

      var jsonstr = {
        uid:$abb_temp1,
        beginRow:0,
        pageSize:20
      };

      var reqJson = {
        data: JSON.stringify(jsonstr)
      }

      $.ajax({
        url: 'Guest/getGuestByOpt',
        dataType: 'json',
        method:'post',
        data:reqJson,
        success: function(data){
          $("#jibenxinxi").html(getHtml2Str(data.data[0]));
        },
        error: function(){

        }
      });
    };

    var queryGuest1Data = function(){
      var jsonstr = {
        attr5:$abb_temp1,
        attr11:"1"
      };

      var reqJson = {
        data: JSON.stringify(jsonstr)
      }
      console.log(JSON.stringify(jsonstr));
      $.ajax({
        url: 'Guest1/getGuest1ByOpt',
        dataType: 'json',
        method:'post',
        data:reqJson,
        success: function(data){
          console.log(data);
          $("#goutonglist").html("");
          for(var guest1 in data.data){
            console.log(JSON.stringify(data.data[guest1]));
            var tempDiv = $("<div class='portlet'>" +
                    "<div class='portlet-note'>" +
                    "<span>"+data.data[guest1].username+"</span>" +
                    "<span>"+data.data[guest1].schoolName+"</span>" +
                    "<span>"+data.data[guest1].attr3+"</span>" +
                    "<span>再联日期："+data.data[guest1].attr6+"</span>" +
                    "<span>"+data.data[guest1].attr4+"</span>" +
                    "</div></div>");

            $("#goutonglist").append(tempDiv);
          }
        },
        error: function(){

        }
      });
    };

    var queryGuest2Data = function(){
      var jsonstr = {
        attr5:$abb_temp1,
        attr11:"1"
      };

      var reqJson = {
        data: JSON.stringify(jsonstr)
      }

      $.ajax({
        url: 'Guest2/getGuest2ByOpt',
        dataType: 'json',
        method:'post',
        data:reqJson,
        success: function(data){
          console.log(data);
          $("#genjinxinxi").html("");
          for(var guest1 in data.data){
            console.log(JSON.stringify(data.data[guest1]));
            var tempDiv = $("<div class='portlet'>" +
                    "<div class='portlet-note'>" +
                    "<span>地址："+data.data[guest1].attr6+"</span>" +
                    "<span>"+data.data[guest1].attr4+"</span>" +
                    "</div></div>");

            $("#genjinxinxi").append(tempDiv);
          }
        },
        error: function(){

        }
      });
    };

    queryData();
    queryGuest1Data();
    queryGuest2Data();
  });
</script>
