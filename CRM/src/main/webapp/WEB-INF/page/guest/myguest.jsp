<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="" style="margin: 15px;">
  <h2 style="color: #66666a">
    我的客户
  </h2>
  <div class="box">
    <div style="background: #ffffff; padding: 10px; max-height: 440px; width: 100%; overflow: auto;">
      <table>
        <thead>
        <tr>
          <th>客户名称</th>
          <th>客户号码</th>
          <th>TMK</th>
          <th style="width: 20px;text-align: center;">操作</th>
        </tr>
        </thead>
        <tbody id="List">

        </tbody>
      </table>
    </div>
  </div>
</div>
<script>
  (function() {
    var queryData = function() {
      var reqJson = {
        data: JSON.stringify({beginRow: 0, pageSize: 100})
      };
      $.ajax({
        url: 'Guest/getGuestByMy',
        dataType: 'json',
        method: 'post',
        data: reqJson,
        success: function (data) {
          console.log("data:" + JSON.stringify(data.data));

          $("#List").html("");

          for(var json in data.data){
            var tableStr = $("<tr><td>"+data.data[json].attr6+"</td><td>"+data.data[json].attr10+"</td><td>"+$.notNull(data.data[json].tmk)+"</td><td><button name='look' type='button' onclick='lookGuest1(this)' class='btn blue' uid='"+data.data[json].uid+"' style='float: right'>  查 看  </button></td></tr>");
            $("#List").append(tableStr);
          }
        },
        error: function () {

        }
      });
    }

    queryData();

    $("#input-4").QueryBox({
      url:"Query/queryStateByattr1"
    });

    $("#allot").click(function(){
      var arr = [];
      if($("#List").find("input:checked").length == 0){
        var notyf = new Notyf({delay: 3000});
        notyf.alert("请选择客户！");
        return;
      }
      $("#List").find("input:checked").each(function(i){
        arr.push($(this).attr("uid"));
      });

      var updateDate = {
        attr27 : $("#input-4").attr("sid"),
        guestList : arr.join(",")
      }

      console.log(updateDate);

      $.ajax({
        url: 'Guest/editGuest',
        dataType: 'json',
        method:'post',
        data:updateDate,
        success: function(data){
          console.log("data:"+JSON.stringify(data));
          var notyf = new Notyf({delay: 3000});
          notyf.confirm("提交成功");

          $.ajax({
            url: "myguset",
            type: "POST",
            success: function(data){
              $(".rightDiv").html(data);
            }
          });
        },
        error: function(){

        }
      });

    });
  })();
</script>
