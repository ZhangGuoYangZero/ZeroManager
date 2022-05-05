<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <#-- 设置的隐藏域  通过返回的request集合中的关键字拿取对应的数据，用VALUE默认显示 -->
    <#--    name 要和 suppliers中的property想对应， 但是发给游览器的property却变小写了-->
    <input type="hidden" name="id" value="${(procurement.id)!}">
    <#--  提交对应name  =  形参的property-->
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">设备名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="DeviceName" id="DeviceName" value="${(procurement.deviceName)!}"
                   placeholder="请输入设备名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">型号</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="Model" lay-verify="required" value="${(procurement.model)!}"
                   placeholder="请输入型号">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">数量</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="NumberOfDevices" id="NumberOfDevices"
                   value="${(procurement.numberOfDevices)!}" placeholder="请输入数量">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="statu" id="statu"
                   value="${(procurement.statu)!}" placeholder="请输入状态">
        </div>
    </div>
    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdateSaleChance">确认</button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/suppliers/add.update1.js"></script>
</body>
</html>