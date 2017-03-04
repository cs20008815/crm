/**
 * Created by Administrator on 2017/2/21.
 */
define(
    ['jquery', 'underscore', 'backbone', 'text!templates/Main/head.html'],
    function ($, _, Backbone, headTemplate)
    {
        HeadView = Backbone.View.extend({
            templates: {
                "headTemplate": _.template(headTemplate)
            },
            initialize: function () {
                this.render();
                return this;
            },
            render: function () {
                var _this = this;
                _this.$el.html(_this.templates.headTemplate());
                $("#header").html(_this.$el);
            },
            events: {
                "click div[name=xial]":"SignOut",
                "click #loginout":"onSignOut"
            },
            SignOut: function(){
                var _this = this;
                _this.$("div[name=show]").toggle();
            },
            onSignOut: function(){
                window.location.href = 'login';
            }
        });
        return HeadView;
    }
);