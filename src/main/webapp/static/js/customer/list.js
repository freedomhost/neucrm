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
         height: 'full-200',
         url: '/customer-info/list' ,//数据接口
         page: true ,//开启分页
         limit:10,//每页显示的条数，默认10
         limits:[2,5,10,15,], //每页显示条数选择框数据
         request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'customerId', title: '客户编号', width:'8%', sort: true, align:'center'},
            {field: 'customerName', title: '客户名称', width:'25%',align:'center'},
            {field: 'customerMgr', title: '客户经理', width:'12%',align:'center'},
            {field: 'customerGrade', title: '客户等级', width:'15%',align:'center'},
            {field: 'customerSatisfaction', title: '客户信满意度', width: '10%',align:'center'},
            {field: 'customerCredit', title: '客户信用度', width: '10%',align:'center'},
            {field: 'juridicalPerson', title: '法人', width: '10%',align:'center'},
            {title:'操作',width:'10%',toolbar:'#customerTool',align:'center'}
        ]]
    });

    table.on('tool(list)',function(obj){

        switch (obj.event){
            case 'show-btn':
                var data = myEncode(obj.data);
                window.location.href = "show.html?data="+data;
                break;
    }
    });

    $('#refur').click(function () {
        tableIns.reload({where: {}});
    });


});