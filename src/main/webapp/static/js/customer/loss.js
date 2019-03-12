layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table,
        form=layui.form,
        $ = layui.$;
    var tableIns;

    form.on('submit(search)',function (data) {
        tableIns.reload({
            where :data.field
        } );
        return false;
    });

    tableIns = table.render({
        elem: '#list',
        height: 312,
        url: '/customer-loss/loss' ,//数据接口
        page: true ,//开启分页
        limit:5,//每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'id', title: '编号', width:'8%', sort: true, align:'center'},
            {field: 'customerName', title: '客户名称', width:'12%',align:'center'},
            {field: 'customerMgr', title: '客户经理', width:'12%',align:'center'},
            {field: 'lastOrderTime', title: '上次下单时间', width:'15%',align:'center'},
            {field: 'lossTime', title: '确认流失时间', width: '15%',align:'center'},
            // {field: 'status', title: '状态'},
            {field: 'status', title: '状态', width: '8%',align:'center', templet: function (d) {
                    if (d.status === 0){
                        return "暂缓流失";
                    }
                    if (d.status === 1){
                        return "确认流失";
                    }
                    else {
                        return "流失预警";
                    }
                    // return d.status ===0?"暂缓流失":"确认流失";
                }},
            {title:'操作',width:'20%',toolbar:'#lossTool',align:'center'}
        ]]
    });


    table.on('tool(list)',function(obj){
        switch (obj.event){
            case 'edit-btn':
                // console.log(obj.data.status);判断状态是否为确认流失
                if (obj.data.status!=0){
             // console.log(obj);是则不做操作，否则跳转到编辑界面
                } else {
                    var data = myEncode(obj.data);
                window.location.href = "temloss.html?data="+data;
                }
                break;
            case 'tem-loss':
                if (obj.data.status!=2){

                }
                else {
                var data = myEncode(obj.data);
                window.location.href = "warloss.html?data="+data;
                }
                break;
            case 'min-loss':
                var data = myEncode(obj.data);
                window.location.href = "minshow.html?data="+data;
                break;
        }
    });
});
