/**
 * Created by Administrator on 2017/2/10.
 */
define(
    ['jquery', 'underscore', 'backbone', 'text!templates/Main/main.html'],
    function ($, _, Backbone, mainTemplate)
    {
        MainView = Backbone.View.extend({
            el: $('body'),
            templates: {
                "mainTemplate": _.template(mainTemplate)
            },
            initialize: function () {
                this.render();
                return this;
            },
            render: function () {
                var _this = this;
                _this.$el.html(this.templates.mainTemplate());

                _this.$(".leftDiv").height($(window).height()-60);
                _this.$(".rightDiv").width($(window).width()-150);
                _this.$(".rightDiv").height($(window).height()-60);
                $(window).resize(function(){
                    _this.$(".leftDiv").height($(window).height()-60);
                    _this.$(".rightDiv").width($(window).width()-150);
                    _this.$(".rightDiv").height($(window).height()-60);
                });

                $(document).ready(function() {
                    $('.inactive').click(function(){
                        if($(this).siblings('ul').css('display')=='none'){
                            $(this).parent('li').siblings('li').removeClass('inactives');
                            $(this).addClass('inactives');
                            $(this).siblings('ul').slideDown(100).children('li');
                            if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
                                $(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
                                $(this).parents('li').siblings('li').children('ul').slideUp(100);

                            }
                        }else{
                            //控制自身变成+号
                            $(this).removeClass('inactives');
                            //控制自身菜单下子菜单隐藏
                            $(this).siblings('ul').slideUp(100);
                            //控制自身子菜单变成+号
                            $(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
                            //控制自身菜单下子菜单隐藏
                            $(this).siblings('ul').children('li').children('ul').slideUp(100);
                            //控制同级菜单只保持一个是展开的（-号显示）
                            $(this).siblings('ul').children('li').children('a').removeClass('inactives');
                        }
                    })
                });

                $.ajax({
                    url: 'getMenu',
                    dataType: 'json',
                    method:'post',
                    data:{menuid:"4"},
                    success: function(data){
                        if(data.isSucc == "true"){
                            console.log(data.data.length);
                            for(var i in data.data){
                                console.log(JSON.stringify(data.data[i]));
                                $("#xtsz").append("<li><a href='javascript:void(0);' name='"+data.data[i].ename+"' url='"+data.data[i].url+"' class='active'>"+data.data[i].name+"</a></li>");
                            }
                            if(data.data.length > 0){
                                $("li[name='xtsz']").show();
                                //$("li[name='xtsz'] .active").click(onActive);
                            }
                        }
                    },
                    error: function(){

                    }
                });

            },
            events: {
                //"click #login" : "login"
            }
        });
        return MainView;
    }
);