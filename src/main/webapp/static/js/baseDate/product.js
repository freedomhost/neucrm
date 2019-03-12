layui.use(['form','jquery','table','layer'],function(){
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    //加载数据表格
    let tabInstance = table.render({
        elem: '#productList',
        url: '/product/list', //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: '', title: '序号',type: 'numbers',width: 60},
            {field: 'name', title: '名称'},
            {field: 'type', title: '型号'},
            {field: 'batch', title: '等级/批次'},
            {field: 'unit', title: '单位'},
            {field: 'price', title: '单价(元)'},
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