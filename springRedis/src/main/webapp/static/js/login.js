jQuery(document).ready(function () {
    layuiFormInit();

    function layuiFormInit() {
        layui.use('form',function () {
            var form=layui.form;
            form.on('submit(LAY-user-login-submit)',function (data) {
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });
    }
});