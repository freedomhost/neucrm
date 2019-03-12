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
        url: '/service-management/feedbackList', //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'id', title: '编号',  width:'8%', sort: true, fixed: 'left'},
            {field: 'customerName', title: '客户',width:'15%'},
            {field: 'outline', title: '概要', width:'25%'},
            {field: 'serviceTypeTitle', title: '服务类型', width:'10%'},
            {field: 'userIdName', title: '负责经理', width:'10%'},
            {field: 'creationName', title: '创建人', width:'10%'},
            {field: 'creationTime', title: '创建日期', width:'15%'},
            {title: '操作', width:'7%',align:'center',toolbar:"#userTool"}
        ]]
    });


    //工具栏操作
    table.on('tool(userList)',function(obj){
        switch (obj.event){
            case 'show-btn':
                $.post('/system-user/login-info', function (info) {
                    if(obj.data.userIdName===info.data.name) {
                        var data = myEncode(obj.data);
                        window.location.href = "fkshow.html?data="+data;

                    }else{
                        layer.alert("抱歉，你不是该服务的负责经理，没有此服务的访问权限！！",{icon: 0,offset: '100px'});
                    }
                });


                break;

        }
    });

    $('#refur').click(function () {
        tabInstance.reload({where: {}});
    });


});