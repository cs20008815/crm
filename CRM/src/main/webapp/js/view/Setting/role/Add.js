/**
 * Created by Administrator on 2017/3/1.
 */
define(['jquery', 'underscore', 'backbone', 'iziToast', 'autoselect'
        , 'text!templates/Setting/role/add.html'
    ],
    function ($, _, Backbone, iziToast, autoselect
        , addTemplate
    ) {
        Add = Backbone.View.extend({
            templates: {
                "addTemplate": _.template(addTemplate)
            },
            initialize: function (option) {
                this.option = option;
                this.render();

                return this;
            },
            render: function () {
                this.$el.html(this.templates.addTemplate());

                this.$("#deptName").autoselect({
                    source:"api/dept/queryDept",
                    searchParam:"attr1",
                    label:["schoolName","deptName"],
                    id:"deptId"
                });
            },
            events: {
                "click #save":"save",
                "click #cancel":"onCancel"
            },
            save: function(){
                var _this = this;
                var opt = {
                    attr1:this.$("#roleName").val(),
                    attr2:this.$("#deptName").attr("inputid")
                }

                var model = new Backbone.Model;
                model.fetchEx(opt,{
                    url : 'api/role/add',
                    success: function (data) {
                        if(data && data.get("status") == "S"){
                            _this.option.callback();
                            iziNotyf.confirm("添加成功");
                            _this.onCancel();
                        }else{
                            iziNotyf.alert("添加失败");
                        }
                    }
                });
            },
            onCancel: function(){
                this.layer.cancleView();
            }
        });
        return Add;
    });