layui.use(['form','jquery','table','layer'],function(){
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    //加载数据表格
    let tabInstance = table.render({
        elem: '#stockList',
        url: '/stock/list', //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: '', title: '序号',type: 'numbers',width: 60},
            {field: 'productName', title: '产品'},
            {field: 'warehouse', title: '仓库'},
            {field: 'shelf', title: '货位'},
            {field: 'number', title: '件数'},
            {field: 'remark', title: '备注'},
        ]]
    });

    //监听查询按钮，重新加载表格数据
    form.on('submit(search)',function (data) {
        tabInstance.reload({
            where : data.field,
            page : {curr: 1}
        });
    });




});