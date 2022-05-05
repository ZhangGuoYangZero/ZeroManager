layui.use(['form', 'jquery', 'jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);

    //表单绑定， 提交事件，按钮的filter
    form.on('submit(saveBtn)', function (data) {
        console.log(data.field)//测试

        $.ajax({
            type: "post",
            url: ctx + "/user/updatePwd",
            data: {
                oldPassowrd: data.field.old_password,
                newPassword: data.field.new_password,
                entPassword: data.field.again_password
            },
            success: function (resultInfo) {
                if (resultInfo.code == 200) {
                    //清空cookie
                    layer.msg("修改成功", function () {
                        $.removeCookie("userName", {Domain: "localhost", path: "/mag"});
                        $.removeCookie("password", {Domain: "localhost", path: "/mag"});
                        $.removeCookie("realName", {Domain: "localhost", path: "/mag"});
                        $.removeCookie("ID", {Domain: "localhost", path: "/mag"})
                    })
                } else {
                    layer.msg(resultInfo.msg, {cion: 5})
                }

                //跳转登陆界面 如果没paent会在内部小窗口跳
                window.parent.location.href =ctx + "/index";
            }
        });

    })


});
