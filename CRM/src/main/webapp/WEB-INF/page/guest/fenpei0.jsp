<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/12
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center;">
  <div>
    <span class="input input--isao">
      <input class="input__field input__field--isao" type="text" id="input-10-1" />
      <label class="input__label input__label--isao" for="input-10-1" data-content="课程顾问">
        <span class="input__label-content input__label-content--isao">课程顾问</span>
      </label>
    </span>
    <span class="input input--isao">
        <input class="input__field input__field--isao" type="text" id="input-10-2" />
        <label class="input__label input__label--isao" for="input-10-2" data-content="到访时间">
          <span class="input__label-content input__label-content--isao">到访时间</span>
        </label>
    </span>
  </div>
  <div style="margin-top: 20px;">
    <button type="button" onclick="" id="addfenpei1" class="btn blue">  提 交  </button>
  </div>
</div>

<script>
  $("#input-10-1").QueryUserBox({
    url:"Query/queryUserByattr1"
  });

  $('#input-10-2').dateRangePicker({
    autoClose: true,
    singleDate: true,
    showShortcuts: false
  });

  $("#addfenpei1").click(function(){
    var updateDate = {
      sid : $abb_temp1,
      attr27 : "8",
      userId : $("#input-10-1").attr("sid"),
      attr23 : $("#input-10-2").val()
    }

    console.log(updateDate);

    $.ajax({
      url: 'Guest/editGuest1',
      dataType: 'json',
      method:'post',
      data:updateDate,
      success: function(data){
        console.log("data:"+JSON.stringify(data));
        var notyf = new Notyf({delay: 3000});
        notyf.confirm("分配成功");
        $.ajax({
          url: "queryguest0",
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
</script>
