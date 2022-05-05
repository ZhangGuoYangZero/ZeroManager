<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ZGY-Manager</title>
    <#-- 引用common文件的公共端口    -->
    <#include "common.ftl">
    <link rel="stylesheet" href="${ctx}/css/index.css" media="all">
</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form" action="">
                <div class="layui-form-item logo-title">
                    <h1>Manager Login</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" name="username" lay-verify="required|account" placeholder="用户名或者邮箱"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" name="password" lay-verify="required|password" placeholder="密码"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <#-- Lay- 是LAY组件的属性， Lay-submit 是提交的地址， Lay-filter 是JS的函数名-->
                    <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="login">登 录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${ctx}/js/index.js" charset="utf-8"></script>
</body>
</html>