layui.use(['table', 'layer'], function () {
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        //这个是绑定批量获取数据的id
        id: 'BoolBarDel'
        //TABLE控件的ID
        , elem: '#supplyList'
        //差值
        , height: 'full-125'
        , cellMinWidth: 95
        //数据接口  ctx + /*/*/*的写法.这里也指定了表单的寻址接口
        , url: ctx + '/emp/list'
        , page: true //开启分页
        //默认每页9条
        , limit: 9
        //下拉可选
        , limits: [1, 2, 3, 4, 5]
        , toolbar: '#toolbarDemo'
        // field 访问实体类的属性字段,title列名,sort排序规则,fixed固定列
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'center'}
            , {field: 'employeeNumber', title: '编号', sort: true, align: 'center'}
            , {field: 'employeeName', title: '员工姓名', align: 'center'}
            , {
                field: 'employeePosition', title: '职位', align: 'center', templet: function (statut) {
                    return formatColor(statut.employeePosition);
                    //console.log(statut)
                }
            }
            , {field: 'employeeDepartment', title: '部门', align: 'center'}
            , {title: '操作', templet: "#supplyBar", fixed: 'right', align: 'center', minwidth: 150}
        ]]
    });

    //返回的HTML语句  要用这个“” 包起来


    function formatColor(employeePosition) {
        if (employeePosition.match(/管理员$/)) {
            return "<div style='color:deepskyblue'>" + employeePosition +"</div>";
        } else {
            return "<div style='color:grey'>" + employeePosition +"</div>";
        }
    }


    //给搜索按钮绑定单机事件，好传递数据，前提是已经获取了三个数据
    //jquery 类搜索返回对象，设置点击事件
    $('.search_btn').click(function () {


        //通过获取的table对象 去设置参数传递给后台
        tableIns.reload({
            //设置给传递给后端的参数
            //这里通过TABLE的重载传递参数，这个参数会传刚给suppliers的查询 也就是suppliQuery
            where: {
                EmpNum: $("[name = 'supplyName']").val()//编号
                , Position: $("[name = 'numm']").val()//职位
            }
            , page: {
                //默认的起始页
                curr: 1
            }

        });
    });

    //前后端的接口类型和变量名字要一模一样
    function RefNewWintoAdd(employeeNumber) {
        var url = ctx + '/emp/addorDel';
        var title = 'addEmp';
        if (employeeNumber != null && employeeNumber != '') {
            title = "eddEmp"
            //非空切唯一
            url += '?employeeNumber=' + employeeNumber;
        }
        layui.layer.open({
            type: 2,
            title: title,
            maxmin: true, //开启最大化最小化按钮
            area: ['500px', '620px'],
            //去请求controller 给地址，
            content: url
        });
    }

    function delMulSupply() {
        //获取数据拿到数组
        //通过LAYER官网给的方法
        var isCheckStatus = table.checkStatus("BoolBarDel");
        //statusArray获取了所被选定的行的所有信息
        var statusArray = isCheckStatus.data;
        //测试
        console.log(statusArray);
        if (statusArray.length < 1) {
            layer.msg("请选择要删除的记录", {icon: 5})
            return;
        }
        layer.confirm('确定要删除记录吗？', {icon: 3, title: "删除"}, function (index) {
            layer.close(index);

            //传递参数数组的写法是ids=xx&&ids=xx&&ids=xXX这样才能把数据在另外一边链接在一起
            var employeeNumbers = 'employeeNumber=';
            for (var i = 0; i < statusArray.length; i++) {
                if (i < statusArray.length - 1) {
                    //获取所选定行信息中的id
                    employeeNumbers += statusArray[i].employeeNumber + '&&employeeNumber='
                } else
                    employeeNumbers += statusArray[i].employeeNumber;
            }
            //测试
            console.log(employeeNumbers)
            //用AJAX发送记录给对应的接口
            $.ajax({
                type: 'post',
                url: ctx + '/emp/del',
                data: employeeNumbers,//数组传走,
                // 由于前面已经拼接了们可以直接发送了,data本身就是数组，就只能这样传了
                success: function (resultinfo) {
                    if (resultinfo.code == 200) {
                        layer.msg("成功", {icon: 6})
                        tableIns.reload();
                    } else
                        layer.msg(resultinfo.msg, {icon: 5})
                }
            });
        });


    }


    //设置监听事件
    table.on('toolbar(SupplyList)', function (data) {
        // 测试
        console.log(data.data);
        if (data.event == 'add') {
            //做添加需要打开LAYER的弹窗口
            //由于id已经被绑定删除时用于获取数组记录占用了，所以这里只能给null来占位了，逻辑判断为空是一致的
            RefNewWintoAdd(null);
        } else {
            //点了删除的操作
            delMulSupply();
        }

    });

    //toolbar 头部工具栏  tool 行工具栏
    //tool里面有删除和更新
    table.on('tool(SupplyList)', function (data) {
        if (data.event == 'edit') {
            //console.log(data.data.id)

            RefNewWintoAdd(data.data.employeeNumber);
        } else {
            //参数1， 弹出提示， 参数2，配置， 参数3 functionc操作
            layer.confirm('确定要删除记录吗？', {icon: 3, title: "删除"}, function (index) {
                layer.close(index);
                //用AJAX发送记录给对应的接口
                $.ajax({
                    type: 'post',
                    url: ctx + '/emp/del',
                    data: {
                        employeeNumber: data.data.employeeNumber
                    },
                    success: function (resultinfo) {
                        if (resultinfo.code == 200) {
                            layer.msg("成功", {icon: 6})
                            tableIns.reload();
                        } else
                            layer.msg(resultinfo.msg, {icon: 5})
                    }
                });
            });
        }
    });


});
