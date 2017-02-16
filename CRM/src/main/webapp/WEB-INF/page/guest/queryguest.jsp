<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="libs/date2/js/moment.min.js"></script>
<script src="libs/date2/js/jquery.daterangepicker.js"></script>
<script>
  var total = 0;
  var loadPage = 20;
  var maxPage = 0;
  var isload = true;
  var reqJson = {};
  var jsonstr = {};
  var getSchool = function(param,success,error){
    $.ajax({
      url: 'School/getSchool',
      dataType: 'json',
      method:'post',
      success: function(data){
        var bases = JSON.stringify(data);
        bases = JSON.parse(bases);
        success(bases);
      },
      error: function(){

      }
    });
  }

  var getSource = function(param,success,error){
    $.ajax({
      url: 'Source/getSource',
      dataType: 'json',
      method:'post',
      success: function(data){
        var bases = JSON.stringify(data);
        bases = JSON.parse(bases);
        success(bases);
      },
      error: function(){

      }
    });
  }

  var strNotNull = function(str){
    return str != null?str:""
  }

  var queryData = function(){

    reqJson = {
      data: JSON.stringify(jsonstr)
    }

    $.ajax({
      url: 'Guest/getGuestByOpt',
      dataType: 'json',
      method:'post',
      data:reqJson,
      success: function(data){
        console.log("data:"+JSON.stringify(data.data));
        console.log("total:"+JSON.stringify(data.total));
        $(".loadingPNG").remove();

        for(var json in data.data){
          $("#guestList").append(getHtml01Str(data.data[json]));
        }
        if($("#guestList").html() == ""){
          $.ajax({
            url: "addguestdetail",
            type: "POST",
            success: function(data){
              $("#guestList").html(data);
            }
          });
        }

        total += 20;
        if(total >= data.total.total){
          total = data.total.total;
        }else{
          $("#guestList").append("<div class='loadingPNG' style='text-align: center'>"+
                  "<span><i style='color: #1995dc' class='icono-spinner spin step'></i></span>"+
                  "</div>");
        }
        $("#curNum").html(total);
        $("#countNum").html(data.total.total);
        maxPage = data.total.total;


        isload = true;

      },
      error: function(){

      }
    });
  }

  $("#btn_query").click(function(){
    var school = $("#input-17").attr("sid");
    var source = $("#input-18").attr("sid");
    var date = $("#input-23").val();
    var startdate = $("#input-19").val();
    var enddate = $("#input-20").val();
    var cname = $("#input-21").val();
    var ename = $("#input-22").val();
    var sex = $("#input-24").val();
    var phone = $("#input-25").val();
    total = 0;

    jsonstr = {
      school:school,
      source:source,
      date:date,
      startdate:startdate,
      enddate:enddate,
      cname:cname,
      ename:ename,
      sex:sex,
      phone:phone,
      beginRow:total,
      pageSize:loadPage
    }

    console.log(JSON.stringify(jsonstr));

    $("#guestList").html("");
    queryData();

  });

  $('#guestList').on('scroll',function(){
    var $this =$(this),
            viewH =$(this).height(),//可见高度
            contentH =$(this).get(0).scrollHeight,//内容高度
            scrollTop =$(this).scrollTop();//滚动高度
    //if(contentH - viewH - scrollTop <= 100) { //到达底部100px时,加载新内容
    if(scrollTop/(contentH -viewH)>=0.99){
      if(isload && maxPage > total){
        isload = false;
        console.log("这里加载数据.."+total);
        jsonstr.beginRow = total;
        queryData();
      }
      // 这里加载数据..
    } //到达底部100px时,加载新内容


  });
</script>

<div class="" style="margin: 15px;">
  <h2 style="color: #66666a">
    客户查询
  </h2>
  <div class="box">
    <div style="height: 40px; width: 100%; background: #44b6ae; color: #ffffff;line-height:40px;">
      <h3 style="margin: 0 20px;">搜索</h3>
    </div>
    <div style="text-align: center; margin: 20px 30px 0 0;">
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-17" />
          <label class="input__label input__label--isao" for="input-17" data-content="中心">
            <span class="input__label-content input__label-content--isao">中心</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-18" />
          <label class="input__label input__label--isao" for="input-18" data-content="推广点">
            <span class="input__label-content input__label-content--isao">推广点</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-19" />
          <label class="input__label input__label--isao" for="input-19" data-content="创建日期">
            <span class="input__label-content input__label-content--isao">创建日期</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-20" />
          <label class="input__label input__label--isao" for="input-20" data-content="结束日期">
            <span class="input__label-content input__label-content--isao">结束日期</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-21" />
          <label class="input__label input__label--isao" for="input-21" data-content="姓名">
            <span class="input__label-content input__label-content--isao">姓名</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-22" />
          <label class="input__label input__label--isao" for="input-22" data-content="英文名">
            <span class="input__label-content input__label-content--isao">英文名</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-23" />
          <label class="input__label input__label--isao" for="input-23" data-content="出生日期">
            <span class="input__label-content input__label-content--isao">出生日期</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-24" />
          <label class="input__label input__label--isao" for="input-24" data-content="性别">
            <span class="input__label-content input__label-content--isao">性别</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-25"  maxlength="11" />
          <label class="input__label input__label--isao" for="input-25" data-content="联系方式">
            <span class="input__label-content input__label-content--isao">联系方式</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-26" />
          <label class="input__label input__label--isao" for="input-26" data-content="学校">
            <span class="input__label-content input__label-content--isao">学校</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-27" />
          <label class="input__label input__label--isao" for="input-27" data-content="小区">
            <span class="input__label-content input__label-content--isao">小区</span>
          </label>
      </span>
      <span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-28" />
          <label class="input__label input__label--isao" for="input-28" data-content="年级">
            <span class="input__label-content input__label-content--isao">年级</span>
          </label>
      </span>
      <div style="margin: 20px;">
        <button type="button" id="btn_query" onclick="" class="btn green">  搜 索  </button>
        <button type="button"  onclick="" class="btn green">  重 置  </button>
        <button type="button"  onclick="" id="btn_add" class="btn green">  新 增  </button>
      </div>
    </div>
  </div>
  <div class="box">
    <div style="height: 55px; width: 100%; background: #44b6ae; color: #ffffff;line-height:55px;">
      <h3 style="margin: 0 20px;">客户列表 当前<span id="curNum" style="font-size: 14px;">0</span>条,共<span id="countNum" style="font-size: 14px;">0</span>条</h3>
    </div>
    <div id="guestList" style="background: #ffffff; padding: 10px; max-height: 440px; overflow: scroll; width: 100%;">

    </div>
  </div>
</div>
<script>
  (function () {
    Date.prototype.Format = function(fmt)
    { //author: meizz
      var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
      };
      if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
      for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
      return fmt;
    }

    $("#input-17").QueryBox({
      url:"Query/querySchoolByattr1"
    });

    $("#input-18").QueryBox({
      url:"Query/querySourceByattr1"
    });

    $('#input-19').dateRangePicker({
      autoClose: true,
      singleDate: true,
      showShortcuts: false
    });

    $('#input-20').dateRangePicker({
      autoClose: true,
      singleDate: true,
      showShortcuts: false
    });

    $('#input-23').dateRangePicker({
      autoClose: true,
      singleDate: true,
      showShortcuts: false
    });

    $('#input-25').keyup(function(){
      this.value = this.value.replace(/[^\d]/g, '');
      if($('#input-25').val().length == 11){
          jsonstr = {
            phone:$('#input-25').val(),
            beginRow:total,
            pageSize:loadPage
          }
          queryData();
      }else{
        $("#guestList").html("");
      }
    });

    if (!String.prototype.trim) {
      (function () {
        // Make sure we trim BOM and NBSP
        var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
        String.prototype.trim = function () {
          return this.replace(rtrim, '');
        };
      })();
    }

    [].slice.call(document.querySelectorAll('input.input__field')).forEach(function (inputEl) {
      // in case the input is already filled..
      if (inputEl.value.trim() !== '') {
        classie.add(inputEl.parentNode, 'input--filled');
      }

      // events:
      inputEl.addEventListener('focus', onInputFocus);
      inputEl.addEventListener('blur', onInputBlur);
    });

    function onInputFocus(ev) {
      classie.add(ev.target.parentNode, 'input--filled');
    }

    function onInputBlur(ev) {
      window.setTimeout(function(){
        if (ev.target.value.trim() === '') {
          classie.remove(ev.target.parentNode, 'input--filled');
        }
      },1);
    }
  })();
</script>

