<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/27
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center;">
  <div>
    <span class="input input--isao">
      <input class="input__field input__field--isao" type="text" id="input-101-1" />
      <label class="input__label input__label--isao" for="input-101-1" data-content="到访中心">
        <span class="input__label-content input__label-content--isao">到访中心</span>
      </label>
    </span>
    <span class="input input--isao">
        <input class="input__field input__field--isao" type="text" id="input-102-2" />
        <label class="input__label input__label--isao" for="input-102-2" data-content="到访时间">
          <span class="input__label-content input__label-content--isao">到访时间</span>
        </label>
    </span>
  </div>
  <div style="margin-top: 20px;">
    <button type="button" onclick="" id="addyuyue1" class="btn blue">  提 交  </button>
  </div>
</div>
<script>
  (function(){
    $("#input-101-1").QueryBox({
      url:"Query/querySchoolByattr1"
    });

    $('#input-102-2').dateRangePicker({
      autoClose: true,
      singleDate: true,
      showShortcuts: true,
      format: 'YYYY-MM-DD HH:mm:ss',
      time: {
        enabled: true
      }
    });

    $("#addyuyue1").click(function(e){
      var reqJson = {
        attr5: $abb_temp1,
        attr4: $("#input-102-2").val(),
        attr6: $("#input-101-1").attr("sname"),
        attr7: $("#input-101-1").attr("sid")
      }

      $.ajax({
        url: 'Guest2/newGuest2',
        dataType: 'json',
        method:'post',
        data:reqJson,
        success: function(data){
          if(data.isSucc == "true"){
            var notyf = new Notyf({delay: 3000});
            notyf.confirm("添加成功");
          }else{
            var notyf = new Notyf({delay: 3000});
            notyf.alert("添加失败");
          }
        },
        error: function(){

        }
      });

    });
  })();
</script>

