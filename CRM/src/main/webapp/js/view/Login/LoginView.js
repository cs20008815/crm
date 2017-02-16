/**
 * Created by Administrator on 2017/2/8.
 */
define(
    ['jquery', 'underscore', 'backbone', 'text!templates/Login/login.html'],
    function ($, _, Backbone, loginTemplate)
    {
        LoginView = Backbone.View.extend({
            templates: {
                "loginTemplate": _.template(loginTemplate)
            },
            initialize: function () {
                this.render();
                return this;
            },
            render: function () {
                this.$el.html(this.templates.loginTemplate());
                $('#indexDiv').html(this.el);
            },
            events: {
                "click #login" : "login"
            },
            login: function(){
                var _this = this;
                var model = new Backbone.Model;
                model.set({
                    "username": _this.$("#username").val(),
                    "password": _this.$("#password").val()
                })
                model.fetchEx({},{
                    url : 'userlogin',
                    success: function (data) {
                        if(data && data.get("status") == "S"){
                            //清空列表数据
                            window.location.href = "#index";
                            //window.location.href = "index";
                        }else{
                            _this.$("#loginMsg").html(data.get("errorMessage"));
                        }
                    }
                });
            }
        });
        return LoginView;
    }
);