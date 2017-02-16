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
    中心设置
  </h2>
  <button type="button" id="add" class="btn green" style="float: right; margin: 15px;"> + </button>
  <table id="table">
    <thead>
    <tr>
      <th>中心名称</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody id="schoolList">

    </tbody>
  </table>
</div>
<script type="text/javascript">
  $(function() {
    var queryData = function(){
      $.ajax({
        url: 'School/getSchool',
        dataType: 'json',
        method: 'post',
        success: function (data) {
          console.log(data);
          $("#schoolList").html("");
          for(var temp in data){
            var tr = $("<tr><td>"+data[temp].attr1+"</td></tr>");
            var td = $("<td></td>");
            var button = $("<button type='button' sid='"+data[temp].sid+"' class='btn green'> 删 除 </button>");

            button.click(removeSchool);

            $("#schoolList").append(tr);

            td.append(button);
            tr.append(td);

          }
        },
        error: function () {

        }
      });
    };

    var sjstype = "zx"+Math.floor(Math.random()*10000);
    var addSchool = function(){
      var jsonstr = {
        attr1 : $("#input-query[stype='"+sjstype+"']").val()
      }

      $.ajax({
        url: 'School/addSchool',
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

    var removeSchool = function(e){
      console.log($(e.target).attr("sid"));
      var jsonstr = {
        sid : $(e.target).attr("sid")
      }

      $.ajax({
        url: 'School/removeSchool',
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

    div1.append(getInput({title:"中心",stype:sjstype}));
    div2.append(getButton("添加",addSchool));
    div.append(div1);
    div.append(div2);

    $('#add').PopupLayer({
      content: div,
      to: 'left',
      blur: true
    });
  });
</script>