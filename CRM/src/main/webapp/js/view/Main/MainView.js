/**
 * Created by Administrator on 2017/2/10.
 */
define(
    ['jquery', 'underscore', 'backbone', 'text!templates/Main/main.html'],
    function ($, _, Backbone, mainTemplate)
    {
        MainView = Backbone.View.extend({
            templates: {
                "mainTemplate": _.template(mainTemplate)
            },
            initialize: function () {
                this.render();
                return this;
            },
            render: function () {
                var _this = this;
                new MenuView();
            },
            events: {

            }
        });
        return MainView;
    }
);