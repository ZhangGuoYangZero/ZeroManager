<!DOCTYPE html>
<html>
<head>
    <title>库存总表</title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="supplyName"
                           class="layui-input
					searchVal" placeholder="设备名"/>
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="numm" class="layui-input
					searchVal" placeholder="型号"/>
                </div>
                <div class="layui-input-inline">
                    <select name="state" id="state">
                        <option value="">状态</option>
                        <option value="0">需更换</option>
                        <option value="1">可使用</option>
                    </select>
                </div>
                <a class="layui-btn search_btn" data-type="reload"><i
                            class="layui-icon">&#xe615;</i> 搜索</a>
            </div>
        </form>
    </blockquote>

    <table id="supplyList" class="layui-table" lay-filter="SupplyList">

    </table>

    <#--头部工具栏  table自带的 用这个生成的样式去具体绑定-->
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <a class="layui-btn layui-btn-normal addNews_btn" lay-event="add">
                <i class="layui-icon">&#xe608;</i>
                添加
            </a>
            <a class="layui-btn layui-btn-normal delNews_btn" lay-event="del">
                <i class="layui-icon">&#xe608;</i>
                删除
            </a>
        </div>
    </script>


    <#--行工具栏  table自带的 用这个生成的样式去具体绑定-->
    <script id="supplyBar" type="text/html">
        <a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    </script>

</form>
<script type="text/javascript" src="${ctx}/js/ALL/all.js"></script>

</body>
</html>