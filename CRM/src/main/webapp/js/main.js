/**
 * Created by Administrator on 2017/2/8.
 */
(function() {
    require.config({
        paths:{
            "jquery":"libs/jquery/jquery",
            "underscore" : 'libs/underscore/underscore',
            "backbone" : 'libs/backbone/backbone',
            "text":"libs/require/text"
        },
        shim : {
            underscore: {
                deps:['jquery'],
                exports: '_'
            },
            backbone : {
                deps : ['underscore','jquery'],
                exports : 'Backbone'
            }
        }
    });
    require(['router'], function(AppRouter) {
        var appRouter = new AppRouter;
        Backbone.history.start();
    });
})(this);
