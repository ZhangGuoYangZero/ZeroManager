layui.use(['element', 'layer', 'layuimini', 'jquery', 'jquery_cookie'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        $ = layui.jquery_cookie($);

    // 菜单初始化
    $('#layuiminiHomeTabIframe').html('<iframe width="100%" height="100%" frameborder="0"  src="welcome"></iframe>')
    layuimini.initTab();

    //Jquery的类选择器_>找到知道删除按钮的对象，绑定click事件
    $(".login-out").click(function () {
        layer.confirm('确定退出吗?', {icon: 3, title: '提示'}, function (index) {
            layer.close(index);
            $.removeCookie(function (){
                $.removeCookie("userName", {Domain: "localhost", path: "/mag"});
                $.removeCookie("password", {Domain: "localhost", path: "/mag"});
                $.removeCookie("realName", {Domain: "localhost", path: "/mag"});
                $.removeCookie("ID", {Domain: "localhost", path: "/mag"});
            })
            window.parent.location.href=ctx+"/index";
        })
    })
});