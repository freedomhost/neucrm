layui.use(['layer','table','jquery','form'],function(){
    var layer = layui.layer,
        table = layui.table,
        $ = layui.jquery,
        form = layui.form;

    //加载数据表格
    var tabInstance = table.render({
        elem: '#serviceList',
        url: '/service-management/list', //数据接口
        page: true, //开启分页
        limit:2, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'id', title: '编号', width:80, sort: true, fixed: 'left'},
            {field: 'serviceType', title: '服务类型'},
            {field: 'outline', title: '概要'},
            {field: 'customerName', title: '客户'},
            {field: 'status', title: '状态',templet:function(user){
                    return user.status === 0 ?"新创建":(user.status===1?"已分配":"已处理");
                }},
            {field: 'serviceReq', title: '服务请求'},
            {field: 'creationName', title: '创建人'},
            {field: 'creationTime', title: '创建时间'},
            {title: '操作', width: 135,fixed:'right',toolbar:"#serviceTool"}
        ]]

    });

    //搜索监听启用
    form.on('submit(search)',function(data){
        tabInstance.reload({
            where :data.field
        });
        return false;
    });

    //工具栏操作
    table.on('tool(serviceList)',function(obj){
        switch (obj.event){
            case 'del_btn':
                layer.confirm('你确定要删除【'+obj.data.customerName+'】吗？',{icon:3,anim: 4,skin:'layui-layer-molv'},function(){
                    $.post('/service-management/del/'+obj.data.id,function(data){
                        tabInstance.reload();
                        layer.msg(data.msg);
                    });
                });
        }
    });



    //添加
    $(".add_btn").click(function(){
        layer.open({
            type: 2,
            content: '/pages/serviceManagement/saveService.html',
            skin:'layui-layer-molv',
            title:"服务创建",
            area:["600px","340px"],
            btn:['确定','关闭'],

            yes: function(index, layero){

                //user_edit
                var user_form = layer.getChildFrame('body', index).find("#service_edit");
                var data = {};
                //把数组转为JSON
                user_form.serializeArray().forEach(function(val){
                    data[val.name] = val.value;

                });

                $.post('/service-management/save-edit',data,function(info){
                    layer.close(index);
                    layer.msg(info.msg);
                    tabInstance.reload();
                });
            }
        });


    });
});
