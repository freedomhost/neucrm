layui.use(['form','jquery','table','layer'],function(){
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    //加载数据表格
    let tabInstance = table.render({
        elem: '#analServiceList',
        url: '/analService/list', //数据接口
        page: true, //开启分页
        limit:5, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: '', title: '序号',type: 'numbers',width: 60},
            {field: 'serviceType', title: '条目', sort: true},
            {field: 'number', title: '服务数量', sort: true}

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