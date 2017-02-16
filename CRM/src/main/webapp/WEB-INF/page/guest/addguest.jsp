<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/4
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="" style="margin: 15px;">
  <h2 style="color: #66666a">
    客户新增
  </h2>
  <div class="box">
    <div style="height: 40px; width: 100%; background: #44b6ae; color: #ffffff;line-height:40px;">
      <h3 style="margin: 0 20px;">搜索</h3>
    </div>
    <div style="text-align: center">
      <span class="inputBig input--hoshi">
          <input class="input__field input__field--hoshi" type="text" id="input-4" maxlength="11" />
          <label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-4">
            <span class="input__label-content input__label-content--hoshi">手机号</span>
          </label>
      </span>
    </div>
  </div>

  <div class="box_guest">
    <div style="height: 55px; width: 100%; background: #44b6ae; color: #ffffff;line-height:55px;">
      <h3 style="margin: 0 20px;">客户列表</h3>
    </div>
    <div id="guestList" style="background: #ffffff; padding: 10px; max-height: 840px; width: 100%;">

    </div>
  </div>
</div>

  <script>
    (function() {
      // trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
      if (!String.prototype.trim) {
        (function() {
          // Make sure we trim BOM and NBSP
          var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
          String.prototype.trim = function() {
            return this.replace(rtrim, '');
          };
        })();
      }

      [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
        // in case the input is already filled..
        if( inputEl.value.trim() !== '' ) {
          classie.add( inputEl.parentNode, 'input--filled' );
        }

        // events:
        inputEl.addEventListener( 'focus', onInputFocus );
        inputEl.addEventListener( 'blur', onInputBlur );
      } );

      function onInputFocus( ev ) {
        classie.add( ev.target.parentNode, 'input--filled' );
      }

      function onInputBlur( ev ) {
        if( ev.target.value.trim() === '' ) {
          classie.remove( ev.target.parentNode, 'input--filled' );
        }
      }



      var getHtmlStr = function(data){
        var htmlStr = "<div class='guestDiv'>";
        htmlStr += "<div style='width: 95%; height: 30px; margin: 15px 20px;'>";
        if("男" == $.notNull(data.attr9)){
          htmlStr += "<span class='nanhaizi'>"+$.notNull(data.attr6)+"</span>";
        }else{
          htmlStr += "<span class='nvhaizi'>"+$.notNull(data.attr6)+"</span>";
        }
        htmlStr += "<span style='color: #b6b6b6; font-weight:bold; font-size: 14px;'> "+$.notNull(data.attr5)+"</span>";
        htmlStr += "<span><button name='look' type='button' onclick='lookGuest(this)' class='btn green' uid='"+data.uid+"' style='float: right'>  查 看  </button></span></div>";
        htmlStr += "<div class='guestDivNeirong'>";
        htmlStr += "<div class='neirong'>状态："+$.notNull(data.state)+"</div>";
        htmlStr += "<div class='neirong'>中心："+$.notNull(data.schoolName)+"</div>";
        htmlStr += "<div class='neirong'>电话专员："+$.notNull(data.tmk)+"</div>";
        htmlStr += "<div class='neirong'>推广员："+$.notNull(data.mk)+"</div>";
        htmlStr += "<div class='neirong'>当前CC："+$.notNull(data.fullname)+"</div>";
        htmlStr += "<div class='neirong'>渠道："+$.notNull(data.qudao)+"</div>";
        htmlStr += "<div class='neirong'>推广点："+$.notNull(data.tuiguangdian)+"</div>";
        htmlStr += "<div class='neirong'>意向产品："+$.notNull(data.yixiangchanpin)+"</div>";
        htmlStr += "<div class='neirong'>推广时间："+$.notNull(data.attr22)+"</div>";
        htmlStr += "<div class='neirong'>到访时间："+$.notNull(data.attr23)+"</div>";
        if(dateContrast(data.attr22)){
          htmlStr += "<div class='baohuqinei'>保护期内</div>";
        }else{
          htmlStr += "<div class='baohuqiwai'>保护期外</div>";
        }

        htmlStr += "<div class='beizhu'>备注："+$.notNull(data.attr18)+"</div></div></div>";

        return htmlStr;
      }

      var queryData = function(phone){

        var jsonstr = {
          phone:phone,
          beginRow:0,
          pageSize:20
        }

        var reqJson = {
          data: JSON.stringify(jsonstr)
        }

        $.ajax({
          url: 'Guest/getGuestByOpt',
          dataType: 'json',
          method:'post',
          data:reqJson,
          success: function(data){
            console.log("------------------");
            console.log(JSON.stringify(data));
            console.log("------------------");
            $("#guestList").html("");
            if(data.data.length > 0){
              for(var json in data.data){
                $("#guestList").append(getHtml01Str(data.data[json]));
              }
            }else{
              $.ajax({
                url: "addguestdetail",
                type: "POST",
                success: function(data){
                  $("#guestList").html(data);
                }
              });
            }
          },
          error: function(){

          }
        });
      }

      $('#input-4').keyup(function(){
        this.value = this.value.replace(/[^\d]/g, '');
        if($('#input-4').val().length == 11){
          if($("#guestList").html() == ""){
            queryData($('#input-4').val());
          }
        }else{
          $("#guestList").html("");
        }
      });
    })();
  </script>