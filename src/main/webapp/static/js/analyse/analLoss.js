layui.use(['form','jquery','table','layer'],function() {
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    //加载数据表格
    let tabInstance = table.render({
        elem: '#lossList',
        url: '/analyseLoss/list', //数据接口
        page: true, //开启分页
        limit: 5, //每页显示的条数，默认10
        limits: [2, 5, 10, 15,], //每页显示条数选择框数据
        request: {
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: '', title: '序号',type: 'numbers',width: 60},
            {field: 'lossTime', title: '流失时间'},
            {field: 'customerName', title: '客户名称'},
            {field: 'customerMgr', title: '客户经理'},
            {field: 'lossReason', title: '流失原因'},
        ]]
    });
    // 搜索监听启用
    form.on('submit(search)', function (data) {
        tabInstance.reload({
            where: data.field
        });
        return false;
    });
});
