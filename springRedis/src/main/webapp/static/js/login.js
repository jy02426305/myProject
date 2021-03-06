jQuery(document).ready(function () {
    layuiFormInit();

    function layuiFormInit() {
        layui.config({
            base: 'static/plugin/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'user'], function(){
            var $ = layui.$
                ,setter = layui.setter
                ,admin = layui.admin
                ,form = layui.form
                ,router = layui.router()
                ,search = router.search;

            form.render();

            //提交
            form.on('submit(LAY-user-login-submit)', function(data){
                data.field.username=DesUtils.encode(data.field.username,"service,ideatc,com");
                data.field.password=DesUtils.encode(data.field.password,"service,ideatc,com");
                $.ajax({
                    url: 'http://localhost:8088/login',
                    type: 'post',
                    data: data.field,
                    dataType:"jsonp",
                    processData:false,
                    xhrFields: {
                        withCredentials: true
                    },
                    crossDomain: true,
                    headers : {
                        'Content-Type' : 'application/x-www-form-urlencoded'
                    },
                    success: function (data) {
                        console.log(data);
                        window.location.href="http://localhost:8088/wp/main";
                    }
                });
                // window.location.href="./main";
                return;
                //请求登入接口
                admin.req({
                    url: layui.setter.base + 'json/user/login.js' //实际使用请改成服务端真实接口
                    ,data: obj.field
                    ,done: function(res){

                        //请求成功后，写入 access_token
                        layui.data(setter.tableName, {
                            key: setter.request.tokenName
                            ,value: res.data.access_token
                        });

                        //登入成功的提示与跳转
                        layer.msg('登入成功', {
                            offset: '15px'
                            ,icon: 1
                            ,time: 1000
                        }, function(){
                            location.href = '../'; //后台主页
                        });
                    }
                });

            });
        });

        // layui.use('form',function () {
        //     var form=layui.form;
        //     form.on('submit(LAY-user-login-submit)',function (data) {
        //         layer.msg(JSON.stringify(data.field));
        //         return false;
        //     });
        // });
    }
});