<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/11
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="" style="margin: 15px; max-height: 580px; overflow: auto;">
  <h2 style="color: #66666a">
    权限设置
  </h2>
  <button type="button" id="add" class="btn green" style="float: right; margin: 15px;"> + </button>
  <button type="button" id="addqx" class="btn green" style="float: right; margin: 15px;"> 授权 </button>
  <table id="table">
    <thead>
    <tr>
      <th width="40%">角色</th>
      <th>权限</th>
    </tr>
    </thead>
    <tbody id="List">
    <tr>
      <td>
        <div style="height: 400px; font-size: 20px; overflow: auto;" id="userList"></div>
      </td>
      <td>
        <div style="height: 400px; font-size: 20px; overflow: auto;" id="premList">

        </div>
      </td>
    </tr>
    </tbody>
  </table>

  <div class="easyui-panel" style="padding:5px">
    <ul id="tt" class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,checkbox:true"></ul>
  </div>
</div>

<script type="text/javascript">
  $(function() {
    var userid = "";

    var queryData = function(){
      $.ajax({
        url: 'Query/queryRoleByattr1',
        dataType: 'json',
        method: 'post',
        success: function (data) {
          $("#userList").html("");
          for(var temp in data){
            var div1 = $("<div class='role_a' sid='"+data[temp].sid+"'><a sid='"+data[temp].sid+"'>"+data[temp].attr1+"</a></div>");
            div1.click(function(e){
              userid = $(e.target).attr("sid");
              $("input[type='checkbox']").prop("checked",false);
              var opt = {
                userid:userid
              }

              $.ajax({
                url: 'Query/queryUserPermByattr1',
                dataType: 'json',
                method: 'post',
                data:{userid:$(e.target).attr("sid")},
                success: function (data) {
                  for(var temp in data){
                    $("input[sid='"+data[temp].permid+"']").prop("checked",true);
                  }

                },
                error: function () {

                }
              });
            });
            $("#userList").append(div1);
          }

        },
        error: function () {

        }
      });

      $.ajax({
        url: 'Query/queryPermByattr1',
        dataType: 'json',
        method: 'post',
        success: function (data) {
          for(var temp in data){
            var div1 = $("<div><label>"+data[temp].attr1+" <input type='checkbox' sid='"+data[temp].sid+"' value='' /></label></div>");
            $("#premList").append(div1);
          }

        },
        error: function () {

        }
      });
    };

    var sjstype = "qx"+Math.floor(Math.random()*10000);
    var add = function(){
      var jsonstr = {
        attr1 : $("#input-query[stype='"+sjstype+"']").val()
      }

      $.ajax({
        url: 'Query/addRole',
        dataType: 'json',
        method: 'post',
        data: jsonstr,
        success: function (data) {
          if(data.isSucc == "true"){
            var notyf = new Notyf({delay: 3000});
            notyf.confirm("添加成功");
            queryData();
          }else{
            var notyf = new Notyf({delay: 3000});
            notyf.alert("添加失败");
          }

        },
        error: function () {

        }
      });
    };

    queryData();

    var div = $("<div style='width: 100%; margin-top: 40px; text-align: center'></div>");
    var div1 = $("<div style='width: 100%;'></div>");
    var div2 = $("<div style='width: 100%;'></div>");

    div1.append(getInput({title:"职位",stype:sjstype}));
    div2.append(getButton("添加",add));
    div.append(div1);
    div.append(div2);

    $('#add').PopupLayer({
      content: div,
      to: 'left',
      blur: true
    });

    $('#addqx').click(function(){
      var arr = [];
      var arr2 = [];
      $("input:checkbox").each(function(i) {
        if($(this).is(':checked')){
          arr.push($(this).attr("sid"));
        }else{
          arr2.push($(this).attr("sid"));
        }

      });

      var opt = {
        userid : userid,
        reqdata1 : arr.toString(),
        reqdata2 : arr2.toString()
      }

      $.ajax({
        url: 'Query/queryUserPermByattr1',
        dataType: 'json',
        method: 'post',
        data : opt,
        success: function (data) {
          console.log(data);
          var notyf = new Notyf({delay: 3000});
          notyf.confirm("授权成功");
        },
        error: function () {
          console.log("错误！");
        }
      });
    });
  });
</script>