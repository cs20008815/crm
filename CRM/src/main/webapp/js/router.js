/**
 * Created by Administrator on 2017/2/8.
 */
define(['jquery', 'underscore', 'backbone'
    , 'view/Login/LoginView'
    , 'view/Main/MainView'
    , 'view/Setting/QXSettingView'
    , 'view/Setting/school/View'
    , 'view/Setting/dept/View'
    , 'view/Setting/role/View'
], function ($, _, Backbone
    , LoginView
    , MainView
    , QXSettingView
    , SchoolView
    , DeptView
    , RoleView
) {
    var AppRouter = Backbone.Router.extend({
        routes: {
            "sy": "home",
            "index":"home",
            "quanxianSetting":"quanxianSetting",
            "zhongxinSetting":"zhongxinSetting",
            "bumenSetting":"bumenSetting",
            "zhiweiSetting":"zhiweiSetting"

        },
        home: function(){
            var view = new MainView();
        },
        quanxianSetting:function(){
            var view = new QXSettingView();
            $("#rightdiv").html(view.$el);
        },
        zhongxinSetting:function(){
            var view = new SchoolView();
            $("#rightdiv").html(view.$el);
        },
        bumenSetting:function(){
            var view = new DeptView();
            $("#rightdiv").html(view.$el);
        },
        zhiweiSetting:function(){
            var view = new RoleView();
            $("#rightdiv").html(view.$el);
        }
    });
    return AppRouter;
});
