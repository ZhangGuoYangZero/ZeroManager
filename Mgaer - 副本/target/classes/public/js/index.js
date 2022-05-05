layui.use(['form', 'jquery', 'jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);

    //底层是jquery实现的
    //这里得到 'submit(*)' Layuer -filter 的名字 过滤所有不是的filter的 传给ajax
    form.on('submit(login)', function (data) {

        //打印当前容器的全部表单字段给游览器consoleTest，名值对形式：{name: value}
        console.log(data.field)

        //发送信息给ajax,由于index里面包含了COMMONT的接口所以可以引用
        $.ajax({
            type: "post", // 发送方式post
            url: ctx + "/user/login",//controller 的LOGIN函数
            data: {
                //    这里是Key-value key是login函数的形参，value是表单的控件提交值
                uname: data.field.username,
                pwd: data.field.password
            },
            //    回调函数 ，用于接受后台给我的KEY-VALUE
            //function(回调的对象)   就是后面仍过来的对象
            success: function (resultinfo) {
                console.log(resultinfo);
                //获取返回的对象的异常码来判断是那种状态
                //200 success  账号密码为空,账号密码错误300  500(额外异常
                if (resultinfo.code == 200) {
                    //利用cookie 暂存一会登陆信息

                    //先打印登陆成功的信息和操作
                    layer.msg("登陆成功...", function () {
                        //$.cooke(key,包装里面的对象的中的属性-useName,passwprd.realName)
                        // 将用户信息写入cookie
                        $.cookie("userName", resultinfo.result.useName);
                        $.cookie("password", resultinfo.result.password);
                        $.cookie("realName", resultinfo.result.realName);
                        $.cookie("ID",       resultinfo.result.id);
                        //return false
                        //cookie 保存之后
                        window.location.href = ctx + "/main";
                    });
                } else {//这里是paramsException的异常
                    layer.msg(resultinfo.msg, {icon: 5});
                }
            }
        });

        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
});