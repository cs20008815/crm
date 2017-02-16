<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/11
  Time: 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="" style="margin: 15px; max-height: 580px; overflow: auto;">
  <h2 style="color: #66666a">
    来源设置
  </h2>
  <table id="table">
    <thead>
    <tr>
      <th>名称</th>
      <th>时间</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody id="List">

    </tbody>
  </table>
</div>
<script type="text/javascript">
  $(function() {
    var queryData = function(){
      $.ajax({
        url: 'Query/queryBhqByattr1',
        dataType: 'json',
        method: 'post',
        success: function (data) {
          console.log(data);
          $("#List").html("");
          for(var temp in data){
            var input1 = "<input type='text' id='input1' value='"+data[temp].attr3+"' />";
            var input2 = "<input type='text' id='input2' value='"+data[temp].attr2+"' />";

            var tr = $("<tr><td>"+input1+"</td><td>"+input2+"</td></tr>");
            var td = $("<td></td>");
            var button = $("<button type='button' sid='"+data[temp].sid+"' class='btn green'> 修 改 </button>");
            var button1 = $("<button type='button' sid='"+data[temp].sid+"' class='btn green'> 删 除 </button>");
            button1.click(removeSchool);
            button.click(edit);

            $("#List").append(tr);

            td.append(button);
            td.append(" ");
            td.append(button1);
            tr.append(td);

          }
        },
        error: function () {

        }
      });
    };

    var sjstype = "ly"+Math.floor(Math.random()*10000);
    var add = function(){
      var jsonstr = {
        attr1 : $("#input-query[stype='"+sjstype+"']").val()
      }

      $.ajax({
        url: 'Query/addLy',
        dataType: 'json',
        method: 'post',
        data: jsonstr,
        success: function (data) {
          console.log(data.isSucc);
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

    var edit = function(e){
      var jsonstr = {
        sid : $(e.target).attr("sid"),
        attr3: $("#input1").val(),
        attr2: $("#input2").val()
      }

      $.ajax({
        url: 'Query/editBhq',
        dataType: 'json',
        method: 'post',
        data: jsonstr,
        success: function (data) {
          console.log(data.isSucc);
          if(data.isSucc == "true"){
            var notyf = new Notyf({delay: 3000});
            notyf.confirm("修改成功");
            queryData();
          }else{
            var notyf = new Notyf({delay: 3000});
            notyf.alert("修改失败");
          }

        },
        error: function () {

        }
      });
    };

    var removeSchool = function(e){
      console.log($(e.target).attr("sid"));
      var jsonstr = {
        sid : $(e.target).attr("sid")
      }

      $.ajax({
        url: 'Query/removeLy',
        dataType: 'json',
        method: 'post',
        data: jsonstr,
        success: function (data) {
          console.log(data.isSucc);
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

    div1.append(getInput({title:"来源",stype:sjstype}));
    div2.append(getButton("添加",add));
    div.append(div1);
    div.append(div2);

    $('#add').PopupLayer({
      content: div,
      to: 'left',
      blur: true
    });
  });
</script>
