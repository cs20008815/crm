<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/5
  Time: 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="libs/date2/js/moment.min.js"></script>
<script src="libs/date2/js/jquery.daterangepicker.js"></script>
<h3 style="color: #0081C2;margin: 20px">基本信息</h3>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-41" />
          <label class="input__label input__label--isao" for="input-41" data-content="姓名">
              <span class="input__label-content input__label-content--isao">姓名</span>
          </label>
      </span>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-42" />
          <label class="input__label input__label--isao" for="input-42" data-content="性别">
              <span class="input__label-content input__label-content--isao">性别</span>
          </label>
      </span>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-43" />
          <label class="input__label input__label--isao" for="input-43" data-content="学校">
              <span class="input__label-content input__label-content--isao">学校</span>
          </label>
      </span>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-44" />
          <label class="input__label input__label--isao" for="input-44" data-content="小区">
              <span class="input__label-content input__label-content--isao">小区</span>
          </label>
      </span>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-45" />
          <label class="input__label input__label--isao" for="input-45" data-content="年级">
              <span class="input__label-content input__label-content--isao">年级</span>
          </label>
      </span>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-46" />
          <label class="input__label input__label--isao" for="input-46" data-content="生日">
              <span class="input__label-content input__label-content--isao">生日</span>
          </label>
      </span>

<h3 style="color: #0081C2;margin: 20px">渠道信息</h3>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-50" />
          <label class="input__label input__label--isao" for="input-51" data-content="中心">
              <span class="input__label-content input__label-content--isao">中心</span>
          </label>
      </span>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-51" />
          <label class="input__label input__label--isao" for="input-51" data-content="渠道">
              <span class="input__label-content input__label-content--isao">渠道</span>
          </label>
      </span>

<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-52" />
          <label class="input__label input__label--isao" for="input-52" data-content="来源">
              <span class="input__label-content input__label-content--isao">来源</span>
          </label>
      </span>

<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-53" />
          <label class="input__label input__label--isao" for="input-53" data-content="推广点">
              <span class="input__label-content input__label-content--isao">推广点</span>
          </label>
      </span>
<span class="inputBig input--isao">
          <input class="input__field input__field--isao" type="text" id="input-54" />
          <label class="input__label input__label--isao" for="input-54" data-content="备注">
              <span class="input__label-content input__label-content--isao">备注</span>
          </label>
      </span>
<h3 style="color: #0081C2;margin: 20px">问卷情况</h3>
<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-61" />
          <label class="input__label input__label--isao" for="input-61" data-content="意向产品类型">
              <span class="input__label-content input__label-content--isao">意向产品类型</span>
          </label>
      </span>

<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-62" />
          <label class="input__label input__label--isao" for="input-62" data-content="课程需求">
              <span class="input__label-content input__label-content--isao">课程需求</span>
          </label>
      </span>

<span class="input input--isao">
          <input class="input__field input__field--isao" type="text" id="input-63" />
          <label class="input__label input__label--isao" for="input-63" data-content="客户分类">
              <span class="input__label-content input__label-content--isao">客户分类</span>
          </label>
      </span>
<div style="text-align: center; width: 100%; height: 30px;">
    <button type="button" id="btn_save" onclick="" class="btn green"> 保 存</button>
</div>

<script>
    (function () {
        Date.prototype.Format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1,                 //月份
                "d+": this.getDate(),                    //日
                "h+": this.getHours(),                   //小时
                "m+": this.getMinutes(),                 //分
                "s+": this.getSeconds(),                 //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds()             //毫秒
            };
            if (/(y+)/.test(fmt))
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }

//        $('#input-46').val(new Date().Format("yyyy-MM-dd"));

        $('#input-46').dateRangePicker({
            autoClose: true,
            singleDate: true,
            showShortcuts: false
        });

        $('#btn_save').click(function () {
            if ("" == $('#input-41').val()) {
                alert("姓名不能为空！");
            }

            var jsonstr = {
                guestname: $('#input-41').val(),
                bdate: $('#input-46').val(),
                sex: $('#input-42').val(),
                phone: $('#input-4').val(),
                school: $('#input-43').val(),
                address: $('#input-44').val(),
                grade: $('#input-45').val(),
                zhongxin:$('#input-50').attr('sid'),
                qudao:$('#input-51').attr('sid'),
                laiyuan:$('#input-52').attr('sid'),
                tuiguangdian:$('#input-53').attr('sid'),
                beizhu:$('#input-54').val(),
                yixiangchanpin:$('#input-61').attr('sid'),
                kechengxuqiu:$('#input-62').attr('sid'),
                kehufenlei:$('#input-63').attr('sid'),
            }

            console.log(JSON.stringify(jsonstr));

            $.ajax({
                url: 'Guest/newGuest',
                dataType: 'json',
                method: 'post',
                data: jsonstr,
                success: function (data) {
                    console.log(data);
                    var notyf = new Notyf({delay: 3000});
                    notyf.confirm("添加成功");
                    $.ajax({
                        url: "addguest",
                        type: "POST",
                        success: function (data) {
                            $(".rightDiv").html(data);
                        }
                    });
                },
                error: function () {

                }
            });
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
            window.setTimeout(function () {
                if (ev.target.value.trim() === '') {
                    classie.remove(ev.target.parentNode, 'input--filled');
                }
            }, 1);
        }

        $("#input-50").QueryBox({
            url:"Query/querySchoolByattr1"
        });

        $("#input-51").QueryBox({
            url:"Query/queryQdByattr1"
        });

        $("#input-52").QueryBox({
            url:"Query/queryLyByattr1"
        });

        $("#input-53").QueryBox({
            url:"Query/querySourceByattr1"
        });

        $("#input-61").QueryBox({
            url:"Query/queryYxcpByattr1"
        });

        $("#input-62").QueryBox({
            url:"Query/queryKcxqByattr1"
        });

        $("#input-63").QueryBox({
            url:"Query/queryKhflByattr1"
        });
    })();
</script>