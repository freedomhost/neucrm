
layui.use(['layer','table','jquery','form'],function(){
    var layer = layui.layer,
        table = layui.table,
        $ = layui.jquery,
        form = layui.form;

    //加载数据表格
    var tabInstance = table.render({
        elem: '#assignService',
        url: '/service-management/findUnassignedService', //数据接口
        page: true, //开启分页

        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'id', title: '服务编号', width:120, sort: true, fixed: 'left'},
            {field: 'customerName', title: '客户',width:180},
            {field: 'outline', title: '概要',width:400},
            {field: 'serviceTypeTitle', title: '服务类型' ,width:200},
            {field: 'creationName', title: '创建人',width:200},
            {field: 'creationTime', title: '创建时间',width:200},

            {title: '操作', toolbar:"#AssignTool"}
        ]]

    });

    //搜索监听启用
    form.on('submit(search)',function(data){
        tabInstance.reload({
            where :data.field
        });
        return false;
    });
    //刷新监听
    $('#refur').click(function () {
        tabInstance.reload({where: {}});
    });
    //工具栏操作
    table.on('tool(assignService)',function(obj){

            switch (obj.event){
                case 'assign_btn':


                    $.post('/service-management/getService/'+obj.data.id,function(info) {
                        var data = myEncode(info.data);
                        window.location.href = "assign.html?data="+data;
                    });

                break;
            };

    });

});
