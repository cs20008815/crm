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
    人员添加
  </h2>
  <button type="button" id="add" class="btn green" style="float: right; margin: 15px;"> + </button>
  <table id="table">
    <thead>
    <tr>
      <th>人员账号</th>
      <th>人员名称</th>
      <th>中心</th>
      <th>部门</th>
      <th>职位</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody id="List">

    </tbody>
  </table>

  <div class="easyui-panel" style="padding:5px">
    <ul id="tt" class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,checkbox:true"></ul>
  </div>
</div>
<script type="text/javascript">
  $(function() {
    var queryData = function(){
      $.ajax({
        url: 'Query/queryUserByattr1',
        dataType: 'json',
        method: 'post',
        success: function (data) {
          console.log(data);
          $("#List").html("");
          for(var temp in data){
            var tr = $("<tr><td>"+data[temp].attr1+"</td><td>"+data[temp].attr3
                    +"</td><td>"+data[temp].attr6+"</td><td>"+data[temp].attr8+"</td><td>"+data[temp].attr10+"</td></tr>");
            var td = $("<td></td>");
            var button = $("<button type='button' sid='"+data[temp].uid+"' class='btn green'> 删 除 </button>");
            button.click(remove);

            $("#List").append(tr);

            td.append(button);
            tr.append(td);

          }
        },
        error: function () {

        }
      });
    };

    var add = function(){
      var jsonstr = {
        attr1:$("#input-17-0-1").val(),
        attr2:$("#input-17-0-2").val(),
        attr3:$("#input-17-0-3").val(),
        attr4:"1",
        attr5:$("#input-17-1").attr("sid"),
        attr6:$("#input-17-1").attr("sname"),
        attr7:$("#input-17-2").attr("sid"),
        attr8:$("#input-17-2").attr("sname"),
        attr9:$("#input-17-3").attr("sid"),
        attr10:$("#input-17-3").attr("sname"),
        attr20:"1",
      }

      $.ajax({
        url: 'Query/addUser',
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

    var remove = function(e){
      console.log($(e.target).attr("sid"));
      var jsonstr = {
        sid : $(e.target).attr("sid")
      }

      $.ajax({
        url: 'Query/removeUser',
        dataType: 'json',
        method: 'post',
        data: jsonstr,
        success: function (data) {
          console.log(data.isSucc);
          if(data.isSucc == "true"){
            var notyf = new Notyf({delay: 3000});
            notyf.confirm("删除成功");
            queryData();
          }else{
            var notyf = new Notyf({delay: 3000});
            notyf.alert("删除成功");
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

    div2.append(getButton("添加",add));
    div.append(div1);
    div.append(div2);

    var span1_1 = $("<span class='input input--isao'></span>");
    var input1_1 = $("<input class='input__field input__field--isao' type='text' id='input-17-1' />");
    var label1_1 = $("<label class='input__label input__label--isao' for='input-17-1' data-content='中心'>");
    var span2_1 = $("<span class='input__label-content input__label-content--isao'>中心</span>");

    var span1_2 = $("<span class='input input--isao'></span>");
    var input1_2 = $("<input class='input__field input__field--isao' type='text' id='input-17-2' />");
    var label1_2 = $("<label class='input__label input__label--isao' for='input-17-2' data-content='部门'>");
    var span2_2 = $("<span class='input__label-content input__label-content--isao'>部门</span>");

    var span1_3 = $("<span class='input input--isao'></span>");
    var input1_3 = $("<input class='input__field input__field--isao' type='text' id='input-17-3' />");
    var label1_3 = $("<label class='input__label input__label--isao' for='input-17-3' data-content='职位'>");
    var span2_3 = $("<span class='input__label-content input__label-content--isao'>职位</span>");

    var span1_0 = $("<span class='input input--isao'></span>");
    var input1_0 = $("<input class='input__field input__field--isao' type='text' id='input-17-0-1' />");
    var label1_0 = $("<label class='input__label input__label--isao' for='input-17-0-1' data-content='账号'>");
    var span2_0 = $("<span class='input__label-content input__label-content--isao'>账号</span>");
    label1_0.append(span2_0);
    span1_0.append(input1_0);
    span1_0.append(label1_0);
    div1.append(span1_0);

    var span1_0 = $("<span class='input input--isao'></span>");
    var input1_0 = $("<input class='input__field input__field--isao' type='text' id='input-17-0-2' />");
    var label1_0 = $("<label class='input__label input__label--isao' for='input-17-0-2' data-content='密码'>");
    var span2_0 = $("<span class='input__label-content input__label-content--isao'>密码</span>");
    label1_0.append(span2_0);
    span1_0.append(input1_0);
    span1_0.append(label1_0);
    div1.append(span1_0);

    var span1_0 = $("<span class='input input--isao'></span>");
    var input1_0 = $("<input class='input__field input__field--isao' type='text' id='input-17-0-3' />");
    var label1_0 = $("<label class='input__label input__label--isao' for='input-17-0-3' data-content='名称'>");
    var span2_0 = $("<span class='input__label-content input__label-content--isao'>名称</span>");
    label1_0.append(span2_0);
    span1_0.append(input1_0);
    span1_0.append(label1_0);
    div1.append(span1_0);

    label1_1.append(span2_1);
    span1_1.append(input1_1);
    span1_1.append(label1_1);

    label1_2.append(span2_2);
    span1_2.append(input1_2);
    span1_2.append(label1_2);

    label1_3.append(span2_3);
    span1_3.append(input1_3);
    span1_3.append(label1_3);

    div1.append(span1_1);
    div1.append(span1_2);
    div1.append(span1_3);

    $("#add").PopupLayer({
      content: div,
      to: 'left',
      blur: true
    });

    $("#input-17-1").QueryBox({
      url:"Query/querySchoolByattr1"
    });

    $("#input-17-2").QueryBox({
      url:"Query/queryDeptByattr1"
    });

    $("#input-17-3").QueryBox({
      url:"Query/queryRoleByattr1"
    });
  });
</script>