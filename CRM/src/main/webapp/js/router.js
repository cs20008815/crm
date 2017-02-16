/**
 * Created by Administrator on 2017/2/8.
 */
define(['jquery', 'underscore', 'backbone'
    , 'view/Login/LoginView'
    , 'view/Main/MainView'
], function ($, _, Backbone
    , LoginView
    , MainView) {
    var AppRouter = Backbone.Router.extend({
        routes: {
            "": "home",
            "home": "home",
            "index":"index"
        },
        //login
        "home": function () {
            var view = new LoginView();
        },
        "index": function(){
            console.log("------------");
            var view = new MainView();
        }
    });
    return AppRouter;
});
