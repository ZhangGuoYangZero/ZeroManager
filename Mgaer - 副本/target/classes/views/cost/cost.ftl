<!DOCTYPE html>
<html>
<head>
	<title>财务成本</title>
	<#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
		</form>
	</blockquote>
	<#-- 在页面放置一个元素 <table id="demo"></table>，然后通过 table.render() 方法指定该容器 -->
	<table id="saleChanceList" class="layui-table"  lay-filter="saleChances"></table>
</form>
<script type="text/javascript" src="${ctx}/js/cost/cost.js"></script>

</body>
</html>