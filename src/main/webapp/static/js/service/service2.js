layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table,
        form=layui.form,
        $ = layui.$;
    var tabInstance;


    //搜索监听启用
    form.on('submit(search)',function(data){
        tabInstance.reload({
            where :data.field
        });
        return false;
    });
    //加载数据表格
    tabInstance = table.render({
        elem: '#userList',
        url: '/service-user-allot/feedbackList', //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'id', title: '编号',  width:'8%', sort: true, fixed: 'left'},
            {field: 'customerName', title: '客户',width:'13%'},
            {field: 'outline', title: '概要', width:'21%'},
            {field: 'serviceTypeTitle', title: '服务类型', width:'10%'},
            {field: 'creationName', title: '创建人', width:'10%'},
            {field: 'userIdName', title: '负责经理', width:'10%'},
            {field: 'creationTime', title: '创建日期', width:'13%'},
            {field: 'statusTitle',title:'状态', width:'8%'},
            {title: '操作', width:'7%',align:'center',toolbar:"#userTool"}
        ]]
    });


    //工具栏操作
    table.on('tool(userList)',function(obj){
        switch (obj.event){
            case 'show-btn':
                var data = myEncode(obj.data);
                console.log(obj.data);
                window.location.href = "gdshow.html?data="+data;
                break;

        }
    });
    $('#refur').click(function () {
        tabInstance.reload({where: {}});
    });



});