<!DOCTYPE html>
<html>
<head>
	<title>缺货目录</title>
	<#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="deviceName"
						   class="layui-input
					searchVal" placeholder="设备名" />
				</div>
				<div class="layui-input-inline">
					<input type="text" name="model" class="layui-input
					searchVal" placeholder="型号" />
				</div>
				<div class="layui-input-inline">
                    <select name="statu"  id="state">
                        <option value="" >缺货状态</option>
                        <option value="0">缺货</option>
                        <option value="1" >已满足</option>
                    </select>
				</div>
				<a class="layui-btn search_btn" data-type="reload"><i
							class="layui-icon">&#xe615;</i> 搜索</a>
			</div>
		</form>
	</blockquote>
	<#-- 在页面放置一个元素 <table id="demo"></table>，然后通过 table.render() 方法指定该容器 -->
	<table id="saleChanceList" class="layui-table"  lay-filter="saleChances"></table>
</form>
<script type="text/javascript" src="${ctx}/js/suppliers/procure.js"></script>

</body>
</html>