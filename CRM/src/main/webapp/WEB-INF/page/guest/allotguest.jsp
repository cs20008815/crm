<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/19
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="" style="margin: 15px;">
  <h2 style="color: #66666a">
    客户分配
  </h2>
  <div class="box">
    <div style="height: 40px; width: 100%; background: #44b6ae; color: #ffffff;line-height:40px;">
      <h3 style="margin: 0 20px;">搜索</h3>
    </div>
    <div style="text-align: center; margin: 20px 30px 0 0;">
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-4" />
          <label class="input__label input__label--isao" for="input-4" data-content="客户分类">
            <span class="input__label-content input__label-content--isao">客户状态</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-5" />
          <label class="input__label input__label--isao" for="input-5" data-content="TMK">
            <span class="input__label-content input__label-content--isao">TMK</span>
          </label>
      </span>
    </div>
  </div>
  <div style="width: 100%; text-align: right;">
    <button type="button" id="allot" class="btn green" style="margin: 15px;"> 分 配 </button>
  </div>
  <div class="box">
    <div style="background: #ffffff; padding: 10px; max-height: 440px; width: 100%; overflow: auto;">
      <table>
        <thead>
        <tr>
          <th>客户名称</th>
          <th>客户号码</th>
          <th>TMK</th>
          <th>操作</th>
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

    var queryData = function(){

      var reqJson = {
        data: JSON.stringify({state:$("#input-4").attr("sid"),beginRow:0,pageSize:100})
      };

      console.log(JSON.stringify(reqJson));

      $.ajax({
        url: 'Guest/getGuestByOpt',
        dataType: 'json',
        method:'post',
        data:reqJson,
        success: function(data){
          console.log("data:"+JSON.stringify(data.data));
          console.log("total:"+JSON.stringify(data.total));
          $("#List").html("");

          for(var json in data.data){
            var tableStr = $("<tr><td>"+data.data[json].attr6+"</td><td>"+telphone(data.data[json].attr10)+"</td><td>"+$.notNull(data.data[json].tmk)+"</td><td><input type='checkbox' uid='"+data.data[json].uid+"' style='width: 20px;height: 20px;' ></td></tr>");
            $("#List").append(tableStr);
          }
        },
        error: function(){

        }
      });
    }

    $("#input-4").QueryBox({
      url:"Query/queryStateByattr1",
      queryCallBack:queryData
    });

    $("#input-5").QueryUserBox({
      url:"Query/queryUserByattr1"
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
        attr27 : "12",
        userId : $("#input-5").attr("sid"),
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
          notyf.confirm("分配成功");

          $.ajax({
            url: "allotGuest",
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

