layui.use(['form','jquery','table','layer'],function() {
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    //加载数据表格
    let tabInstance = table.render({
        elem: '#constituteList',
        url: '/analyseConstitute/list', //数据接口
        page: true, //开启分页
        limit: 5, //每页显示的条数，默认10
        limits: [2, 5, 10, 15,], //每页显示条数选择框数据
        defaultToolbar: ['filter', 'print', 'exports'],
        request: {
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: '', title: '序号',type: 'numbers',width: 60},
            {field:'customerGrade', title: '等级', sort: true},
            {field: 'countSum', title: '数量', sort: true},
        ]]
    });
// 搜索监听启用
    form.on('submit(searchAnaly)', function (data) {
        let search=$('#searchAnaly option:selected') .val();
        console.log(search);
        if(search === 'customer_grade'){
            tabInstance = table.render({
                elem: '#constituteList',
                url: '/analyseConstitute/searchAnaly/'+search, //数据接口
                page: true, //开启分页
                limit: 5, //每页显示的条数，默认10
                limits: [2, 5, 10, 15,], //每页显示条数选择框数据
                request: {
                    pageName: 'current',
                    limitName: 'size'
                },
                cols: [[ //表头
                    {field: '', title: '序号',type: 'numbers',width: 60},
                    {field:'customerGrade', title: '等级', sort: true},
                    {field: 'countSum', title: '数量', sort: true},

                ]]
            });
        }
        if(search === 'customer_credit'){
            tabInstance = table.render({
                elem: '#constituteList',
                url: '/analyseConstitute/searchAnaly/'+search, //数据接口
                page: true, //开启分页
                limit: 5, //每页显示的条数
                limits: [2, 5, 10, 15,], //每页显示条数选择框数据
                request: {
                    pageName: 'current',
                    limitName: 'size'
                },
                cols: [[ //表头
                    {field: '', title: '序号',type: 'numbers',width: 60},
                    {field: 'customerCredit', title: '信用度', sort: true},
                    {field: 'countSum', title: '数量', sort: true},
                ]]
            });
        }
        if(search === 'customer_satisfaction'){
            tabInstance = table.render({
                elem: '#constituteList',
                url: '/analyseConstitute/searchAnaly/'+search, //数据接口
                page: true, //开启分页
                limit: 5, //每页显示的条数，默认10
                limits: [2, 5, 10, 15,], //每页显示条数选择框数据
                request: {
                    pageName: 'current',
                    limitName: 'size'
                },
                cols: [[ //表头
                    {field: '', title: '序号',type: 'numbers',width: 60},
                    {field: 'customerSatisfaction', title: '满意度', sort: true},
                    {field: 'countSum', title: '数量', sort: true},
                ]]
            });
        }
        return false;
    });
})