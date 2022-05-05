<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <#--    用隐藏域区分 插入的时候这里是空的-->
    <input type="hidden" name="employeeNumberFuck" value="${(employeee.employeeNumber)!}">
    <#--  提交对应name  =  形参的property-->
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">编号</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="employeeNumber" id="employeeNumber"
                   value="${(employeee.employeeNumber)!}"
                   placeholder="请输入编号/非空/唯一">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="employeeName" id="employeeName"
                   value="${(employeee.employeeName)!}"
                   placeholder="请输入姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">职位</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="employeePosition" id="employeePosition"
                   value="${(employeee.employeePosition)!}"
                   placeholder="请输入职位">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="employeeDepartment" lay-verify="required"
                   value="${(employeee.employeeDepartment)!}"
                   placeholder="请输入部门/默认员工">
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
<script type="text/javascript" src="${ctx}/js/emp/add.update1.js"></script>
</body>
</html>