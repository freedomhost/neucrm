layui.use(['form','jquery','table','layer'],function(){
    var form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    //加载数据表格
    var tabInstance = table.render({
        elem: '#marketList',
        url: '/draw-plan/list', //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[
            {field: 'id', title: '机会编号', width:'7%',align: 'center'},
            {field: 'opportunitySource', title: '机会来源',width:'11%',align: 'center'},
            {field: 'name', title: '客户姓名',width:'10%',align: 'center'},
            {field: 'successProbability', title: '成功几率',width:'8%',align: 'center'},
            {field: 'contacts', title: '联系人',width:'9%',align: 'center'},
            {field: 'contactsTel', title: '联系电话',width:'10%',align: 'center'},
            {field: 'status', title: '开发状态',width:'10%',align: 'center',templet:function (d) {
                    if (d.status ===1){
                        return "开发中";
                    }
                    if (d.status ===2){
                        return "开发成功";
                    }
                    else {
                        return "开发失败";
                    }
                }},
            {field: 'assignName', title: '指派经理',width:'10%',align: 'center'},
            {field: 'foundName', title: '销售机会创建人',width:'10%',align: 'center'},
            {title: '操作', width: 120,fixed:'right',width:'16%',toolbar:"#marketTool"}
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
    table.on('tool(marketList)',function(obj){
        switch (obj.event){
            case 'look_btn':
                        var data = myEncode(obj.data);
                        $.post('/system-user/login-info', function (info) {
                            if(obj.data.assignName===info.data.name ||obj.data.foundName===info.data.name){
                                window.location.href = "look.html?data="+data;
                            }else{
                                layer.alert("抱歉，你不是该客户的<h2>客户经理或销售主管</h2>没有此客户的操作权限！！",{icon: 0,offset: '100px'});
                            }
                        });
                        break;
            default:
                if(obj.data.status===1){
                    layer.msg('该客户还未开发完成，不能删除！！！！');
                }else{
                layer.confirm("你确定要删除<h2><font color='red'>机会编号为【" +obj.data.id + "】</font></h2><h2><font color='red'>客户名称为【" + obj.data.name + "】</font></h2>的机会吗？", {
                    icon: 3,
                    anim: 4,
                    skin: 'layui-layer-molv'
                }, function () {
                    $.post('/draw-plan/delsale/' + obj.data.id, function (data) {
                        tabInstance.reload({
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                        });
                        layer.msg(data.msg);
                    });
                });
                }
                break;

        }
    });
});