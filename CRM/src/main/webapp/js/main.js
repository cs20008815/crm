/**
 * Created by Administrator on 2017/2/8.
 */
require.config({
    baseUrl : 'js',
    paths:{
        "jquery":"libs/jquery/jquery",
        "jqueryui":'libs/jqueryui/jquery-ui',
        "underscore" : 'libs/underscore/underscore',
        "backbone" : 'libs/backbone/backbone',
        "text":"libs/require/text",
        ztreeCore:'libs/ztree/jquery.ztree.core',
        ztreeExcheck:'libs/ztree/jquery.ztree.excheck',
        ztreeExhide:'libs/ztree/jquery.ztree.exhide',
        ztreeExedit:'libs/ztree/jquery.ztree.exedit',
        pagination:'libs/pagination/jquery.pagination',
        iziToast:'libs/toast/iziToast',
        iziNotyf:'libs/notyf/notyf',
        autocheckcomplete:'libs/autocheck/autocheckcomplete',
        autocheck:'libs/autocheck/autocheck',
        autoselectcomplete:'libs/autoselect/autoselectcomplete',
        autoselect:'libs/autoselect/autoselect',
        laydate:'libs/laydate/laydate',
        echarts :'libs/echarts/echarts.min'

    },
    shim : {
        underscore: {
            deps:['jquery'],
            exports: '_'
        },
        jqueryui:{
            deps: [
                'jquery'
            ],
            exports: 'jqueryui'
        },
        backbone : {
            deps : ['underscore','jquery'],
            exports : 'Backbone'
        },
        ztreeCore:{
            deps: [
                'jquery'
            ],
            exports: 'ztreeCore'
        },
        ztreeExcheck:{
            deps: [
                'jquery','ztreeCore'
            ],
            exports: 'ztreeExcheck'
        },
        ztreeExhide:{
            deps: [
                'jquery','ztreeCore'
            ],
            exports: 'ztreeExhide'
        },
        ztreeExedit:{
            deps: [
                'jquery','ztreeCore'
            ],
            exports: 'ztreeExedit'
        },
        pagination:{
            deps: [
                'jquery'
            ],
            exports: 'pagination'
        },
        iziToast:{
            deps: [
                'jquery'
            ],
            exports: 'iziToast'
        },
        iziNotyf:{
            deps: [
                'jquery'
            ],
            exports: 'iziNotyf'
        },
        autoselectcomplete:{
            deps: [
                'jqueryui'
            ],
            exports: 'autoselectcomplete'
        },
        autoselect:{
            deps: [
                'autoselectcomplete'
            ],
            exports: 'autoselect'
        },
        autocheckcomplete:{
            deps: [
                'jqueryui'
            ],
            exports: 'autocheckcomplete'
        },
        autocheck:{
            deps: [
                'autocheckcomplete'
            ],
            exports: 'autoselect'
        },
        laydate: {
            exports: 'laydate'
        },
        echarts: {
            exports: 'echarts'
        }
    }
});
var isLoginTimeOutDealing = false;
require(['router','jquery', 'underscore', 'backbone', 'iziToast', 'iziNotyf', 'view/Main/HeadView', 'view/Main/MenuView'],
    function(AppRouter,$, _, Backbone, iziToast, iziNotyf, HeadView,MenuView) {

        //登陆超时 调整登陆页面
        $.ajaxSetup({
            complete:function(XMLHttpRequest, textStatus){
                var data = XMLHttpRequest.responseText;
                var dataJson = {};
                try{
                    dataJson = JSON.parse(data);
                }catch (e){
                    return;
                }

                if(dataJson.status == "LOGIN_TIME_OUT"){
                    if(isLoginTimeOutDealing){
                        return;
                    }

                    window.location.href = "/crm/";
                }
            }
        });

        $.ajax({
            url: 'api/login/isLogin',
            dataType: 'json',
            method:'post',
            success: function(data){

            },
            error: function(){

            }
        });

        window.iziToast = iziToast;
        window.iziNotyf = new Notyf({delay:3000});
        var menuView = new MenuView;
        var headView = new HeadView;
        var appRouter = new AppRouter;
        Backbone.history.start();
});

