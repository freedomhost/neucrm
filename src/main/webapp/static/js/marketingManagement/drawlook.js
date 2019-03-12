layui.use(['form','jquery','table','layer'],function(){
    var form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    var data;//解密
    var opportunityId;
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密
    //加载数据表格
    console.log(data);
    var tabInstance = table.render({
        elem: '#lookList',
        url: '/draw-plan/looklist/'+data.id, //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[1,2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[
            {field: '', title: '序号',width:'12%',type: 'numbers'},
            //{field: 'id', title: '计划项编号', width:'12%', sort: true, fixed: 'left',align: 'center'},
            {field: 'planTime', title: '计划时间',width:'14%', align: 'center'},
            {field: 'planItem', title: '计划项',width:'12%', align: 'center'},
            {field: 'result', title: '执行效果',width:'12%', align: 'center'},
            {field: 'founder', title: '创建人',width:'12%', align: 'center'},
            {field: 'foundId', title: '创建人编号',width:'12%', align: 'center'},
            {title: '操作', width: 300,fixed:'right',width:'26%', toolbar:"#lookTool"}
        ]]
    });
    if(data.status==3||data.status==2){
        table.on('tool(lookList)',function(obj) {
            switch (obj.event) {
                case 'save_btn':
                    if(data.status===2){
                        layer.msg('已开发成功，无法再进行操作！！！！');
                    }else{
                        layer.msg('已开发失败，无法再进行操作！！！！');
                    }
                    break;
                default:
                    if(data.status===2){
                        layer.msg('已开发成功，无法再进行操作！！！！');
                    }else{
                        layer.msg('已开发失败，无法再进行操作！！！！');
                    }
            }
        });
    }else {
        //计划项
        table.on('tool(lookList)', function (obj) {
            switch (obj.event) {
                case 'save_btn':
                    layer.open({
                        type: 2,
                        content: '/pages/marketingManagement/runEdit.html',
                        skin: 'layui-layer-molv',
                        title: "修改计划",
                        area: ["600px", "400px"],
                        value: data,
                        success: function (layero, index) {
                            var iframe = layer.getChildFrame('body', index);
                            var ddForm = layer.getChildFrame('body', index).find("#market2_edit");
                            iframe.find('#id').val(obj.data.id);
                            iframe.find('#opportunityId').val(obj.data.opportunityId);
                            iframe.find('#planTime').val(obj.data.planTime);
                            iframe.find('#planItem').val(obj.data.planItem);
                        },
                        btn: ['确定', '关闭'],
                        yes: function (index, layero) {
                            var user_form = layer.getChildFrame('body', index).find("#market2_edit");
                            var data = {};
                            //把数组转为JSON
                            user_form.serializeArray().forEach(function (val) {
                                data[val.name] = val.value;
                            });
                            console.log(data)
                            $.post('/draw-plan/edit', data, function (info) {
                                layer.close(index);
                                layer.msg(info.msg);
                                tabInstance.reload();
                            });
                        }
                    })
                    break;
                case 'edit_btn':
                    layer.open({
                        type: 2,
                        content: '/pages/marketingManagement/runPlan.html',
                        skin: 'layui-layer-molv',
                        title: "执行计划",
                        area: ["600px", "340px"],
                        value: data,
                        success: function (layero, index) {
                            var iframe = layer.getChildFrame('body', index);
                            var ddForm = layer.getChildFrame('body', index).find("#market3_edit");
                            iframe.find('#id').val(obj.data.id);
                            iframe.find('#opportunityId').val(obj.data.opportunityId);
                            iframe.find('#result').val(obj.data.result);
                        },
                        btn: ['确定', '关闭'],
                        yes: function (index, layero) {
                            var user_form = layer.getChildFrame('body', index).find("#market3_edit");
                            var data = {};
                            //把数组转为JSON
                            user_form.serializeArray().forEach(function (val) {
                                data[val.name] = val.value;
                            });
                            console.log(data)
                            $.post('/draw-plan/edit', data, function (info) {
                                layer.close(index);
                                layer.msg(info.msg);
                                tabInstance.reload();
                            });
                        }
                    });
                    break;
                case 'del_btn':
                    layer.confirm('你确定要删除【' + obj.data.id + '】号计划项吗？', {
                        icon: 3,
                        anim: 4,
                        skin: 'layui-layer-molv'
                    }, function () {
                        $.post('/draw-plan/deldraw/' + obj.data.id, function (data) {
                            tabInstance.reload();
                            layer.msg(data.msg);
                        });
                    });
                    break;
            }
        });
    }
    //添加计划项
    if(data.status==3||data.status==2){
        $(".add_btn").click(function(obj){
            if(data.status===2){
                layer.msg('已开发成功，无法再进行操作！！！！');
            }else{
                layer.msg('已开发失败，无法再进行操作！！！！');
            }
        });
    }else{
    $(".add_btn").click(function(obj){
        layer.open({
            type: 2,
            content: '/pages/marketingManagement/edit.html',
            skin:'layui-layer-molv',
            title:"添加计划",
            area:["680px","450px"],
            success: function (layero,index) {
                var iframe = layer.getChildFrame('body', index);
                var ddForm = layer.getChildFrame('body', index).find("#market_edit");
                var founder = ddForm.find("#founder");
                var foundId = ddForm.find("#foundId");
                $.post('/system-user/login-info',function (info) {
                    founder.val(info.data.name);
                    foundId.val(info.data.id);
                });
                iframe.find('#opportunityId').val(data.id);
            },
            end:function () {
                tabInstance.reload();
            }

        });
    });
    }


    if(data.status==3||data.status==2){
        console.log(data.status);
        $(".success_btn").click(function(obj){
            if(data.status===2){
                layer.msg('已开发成功，无法再进行操作！！！！');
            }else{
                layer.msg('已开发失败，无法再进行操作！！！！');
            }
        });
    }else {
        //开发成功
        $(".success_btn").click(function (obj) {
            layer.open({
                type: 2,
                content: '/pages/marketingManagement/developSuccess.html',
                skin: 'layui-layer-molv',
                title: "计划成功",
                area: ["380px", "150px"],
                btn: ['确定', '关闭'],
                success: function (layero, index) {
                    var iframe = layer.getChildFrame('body', index);
                    var ddForm = layer.getChildFrame('body', index).find("#market4_edit");
                    var customerMgr = ddForm.find("#customerMgr");
                    var customerMgrId = ddForm.find("#customerMgrId");
                    $.post('/draw-plan/getuser/'+data.assignName, function (info) {
                        customerMgr.val(info.data.name);
                        customerMgrId.val(info.data.id);
                    });
                    iframe.find('#customerName').val(data.name);
                    iframe.find('#fax').val(data.id);
                },
                yes: function (index, layero) {
                    var user_form = layer.getChildFrame('body', index).find("#market4_edit");
                    var data = {};
                    //把数组转为JSON
                    user_form.serializeArray().forEach(function (val) {
                        data[val.name] = val.value;
                    });
                    $.post('/draw-plan/developSuccess', data, function (info) {
                        layer.close(index);
                        layer.msg(info.msg);
                        window.location.href = "list.html";
                    });
                }
            });
        });
    }
    if(data.status==3||data.status==2){
        $(".fail_btn").click(function(obj){
            if(data.status===2){
                layer.msg('已开发成功，无法再进行操作！！！！');
            }else{
                layer.msg('已开发失败，无法再进行操作！！！！');
            }
        });
    }else {
        //开发失败
        $(".fail_btn").click(function (obj) {
            layer.open({
                type: 2,
                content: '/pages/marketingManagement/developFail.html',
                skin: 'layui-layer-molv',
                title: "计划成功",
                area: ["380px", "150px"],
                btn: ['确定', '关闭'],
                success: function (layero, index) {
                    var iframe = layer.getChildFrame('body', index);
                    var ddForm = layer.getChildFrame('body', index).find("#market5_edit");
                    iframe.find('#opportunityId').val(data.id);
                },
                yes: function (index, layero) {
                    var user_form = layer.getChildFrame('body', index).find("#market5_edit");
                    var data = {};
                    user_form.serializeArray().forEach(function (val) {
                        data[val.name] = val.value;
                    });
                    console.log(data.opportunityId);
                    $.post('/draw-plan/developFail/' + data.opportunityId, function (info) {
                        layer.close(index);
                        layer.msg(info.msg);
                        window.location.href = "list.html";
                    });
                }
            });
        });
    }
});