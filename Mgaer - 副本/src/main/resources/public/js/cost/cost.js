layui.use(['table', 'layer'], function () {
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    /**
     * 加载数据表格
     */
    var tableIns = table.render({
        id: 'saleChanceTable'
        // 容器元素的ID属性值
        , elem: '#saleChanceList'
        // 容器的高度 full-差值
        , height: 'full-125'
        // 单元格最小的宽度
        , cellMinWidth: 95
        // 访问数据的URL（后台的数据接口）
        , url: ctx + '/cost/list'
        // 开启分页
        , page: true
        // 默认每页显示的数量
        , limit: 10
        // 每页页数的可选项
        , limits: [1, 2, 3, 4, 5]
        // 表头
        , cols: [[
            // field：要求field属性值与返回的数据中对应的属性字段名一致
            // title：设置列的标题
            // sort：是否允许排序（默认：false）
            // fixed：固定列
            , {field: 'id', title: '编号', sort: true, align: 'center'}
            , {field: 'deviceName', title: '设备名', sort: true, align: 'center'}
            , {field: 'model', title: '型号', sort: true, align: 'center'}
            , {field: 'numberOfDevice', title: '数量', sort: true, align: 'center'}
            , {field: 'price', title: '单价', sort: true, align: 'center'}
            , {field: 'total', title: '总计', align: 'center'}
        ]]
    });

});
