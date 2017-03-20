/**
 * Created by Administrator on 2017/2/8.
 */
define(['jquery', 'underscore', 'backbone'
    , 'view/Login/LoginView'
    , 'view/Main/MainView'
    , 'view/Setting/role/QXSettingView'
    , 'view/Setting/school/View'
    , 'view/Setting/dept/View'
    , 'view/Setting/role/View'
    , 'view/Setting/menu/View'
    , 'view/Guest/View'
    , 'view/GuestFP/View'
    , 'view/MyGuest/View'
], function ($, _, Backbone
    , LoginView
    , MainView
    , QXSettingView
    , SchoolView
    , DeptView
    , RoleView
    , MenuView
    , GuestView
    , GuestFPView
    , MyGuestView
) {
    var AppRouter = Backbone.Router.extend({
        routes: {
            "sy": "home",
            "index":"home",
            "quanxianSetting":"quanxianSetting",
            "zhongxinSetting":"zhongxinSetting",
            "bumenSetting":"bumenSetting",
            "zhiweiSetting":"zhiweiSetting",
            "caidanSetting":"caidanSetting",
            "kehuchaxun":"guest",
            "khfp":"guestFP",
            "wdkh":"myguest"

        },
        home: function(){
            var view = new MainView();
            $("#rightdiv").html(view.$el);
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
        },
        caidanSetting:function(){
            var view = new MenuView();
            $("#rightdiv").html(view.$el);
        },
        guest:function(){
            var view = new GuestView();
            $("#rightdiv").html(view.$el);
        },
        guestFP:function(){
            var view = new GuestFPView();
            $("#rightdiv").html(view.$el);
        },
        myguest:function(){
            var view = new MyGuestView();
            $("#rightdiv").html(view.$el);
        }
    });
    return AppRouter;
});
