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
        , url: ctx + '/procure/list'
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
            , {field: 'deviceName', title: '设备名', align: 'center'}
            , {field: 'model', title: '型号', align: 'center'}
            , {field: 'numberOfDevices', title: '数量', align: 'center'}
            , {
                field: 'statu', title: '缺货状态', align: 'center', templet: function (d) {
                    // 调用函数，返回格式化的结果
                    return formatState(d.statu);
                }
            }
        ]]
    });


    //格式化分配状态值
    // 0 = 缺货
    // 1 = 不缺货

    function formatState(state) {
        if (state == 0) {
            return "<div style='color: red'>缺货</div>";
        } else if (state == 1) {
            return "<div style='color: grey'>不缺货</div>";
        }
    }


    //搜索按钮的点击事件
    $(".search_btn").click(function () {

        /**
         * 表格重载
         *  多条件查询
         */
        tableIns.reload({
            // 设置需要传递给后端的参数
            where: { //设定异步数据接口的额外参数，任意设
                // 通过文本框/下拉框的值，设置传递的参数
                DeviceName: $("[name='deviceName']").val() // 设备名
                , Model: $("[name='model']").val() // 型号
                , isSelected: $("#state").val() // 状态
            }
            , page: {
                curr: 1 // 重新从第 1 页开始
            }
        });

    });


});
