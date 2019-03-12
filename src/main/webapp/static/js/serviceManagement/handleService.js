layui.use(['layer','table','jquery','form'],function(){
    var layer = layui.layer,
        table = layui.table,
        $ = layui.jquery,
        form = layui.form;

    //加载数据表格
    var tabInstance = table.render({
        elem: '#handleService',
        url: '/service-management/findServiceFiles', //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'id', title: '处理编号', width:'8%', sort: true, fixed: 'left'},
            {field: 'customerName', title: '客户',width:'15%'},   //(user.serviceType===1?"建议":"上门")
            {field: 'outline', title: '概要', width:'25%'},
            {field: 'serviceTypeTitle', title: '服务类型', width:'10%'},
            {field: 'userIdName', title: '负责经理', width:'10%'},
            {field:'creationName',title:'创建人', width:'10%'},
            {field: 'creationTime', title: '创建时间', width:'15%'},
            {title: '操作',  width:'7%',fixed:'right',toolbar:"#HandleTool"}
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
    table.on('tool(handleService)',function(obj){

        switch (obj.event){
            case 'handle_btn':
                $.post('/system-user/login-info', function (info) {
                    console.log(obj.data.userIdName);
                    if(obj.data.userIdName===info.data.name) {
                        $.post('/service-management/findServiceFileById/'+obj.data.id,function(info) {

                            var data = myEncode(info);
                            window.location.href = "handleManagement.html?data="+data;

                        });
                    }else{
                        layer.alert("抱歉，你不是该服务的负责经理，没有此服务的访问权限！！",{icon: 0,offset: '100px'});
                    }

                });

                break;
        };


    });

});
