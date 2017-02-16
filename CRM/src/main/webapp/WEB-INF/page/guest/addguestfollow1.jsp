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
    <span class="inputBig input--isao">
          <input class="input__field input__field--isao" type="text" id="input-54" />
          <label class="input__label input__label--isao" for="input-54" data-content="备注">
            <span class="input__label-content input__label-content--isao">备注</span>
          </label>
      </span>
    <span class="input input--isao">
        <input class="input__field input__field--isao" type="text" id="input-1102" />
        <label class="input__label input__label--isao" for="input-1102" data-content="提醒日期">
          <span class="input__label-content input__label-content--isao">提醒日期</span>
        </label>
    </span>
  </div>
  <div style="margin-top: 20px;">
    <button type="button" id="addgoutong1" onclick="" class="btn blue">  提 交  </button>
  </div>
</div>
<script>
  (function(){
    $('#input-1102').dateRangePicker({
      autoClose: true,
      singleDate: true,
      showShortcuts: true,
      format: 'YYYY-MM-DD'
    });

    $("#addgoutong1").click(function(e){
      var reqJson = {
        attr4: $("#input-54").val(),
        attr6: $("#input-1102").val(),
        attr5: $abb_temp1
      }

      $.ajax({
        url: 'Guest1/newGuest1',
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

