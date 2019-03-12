layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table,
        form=layui.form,
        $ = layui.$;
    var tableIns;

     var data ={};
    // var str = window.location.href.split("data=")[1];
    // if(str!=null)data= myUncode(str);//解密
    var id = window.location.href.split("id=")[1];
    console.log(id);
    $.post("/customer-info/getCustomer/"+id,function (value) {
        data = value;
        if(data!=null) {
            //客户id
            if (data.customerId != null)
                $("#customerId").val(data.customerId);
            //客户名字
            if (data.customerName != null)
                $("#customerName").val(data.customerName);
        }

        $("#return-btn").click(function () {
            str = myEncode(value);
            window.location.href="../customer/show.html?data="+str;
        });

        tableIns = table.render({
            elem: '#list',
            height: 'full-200',
            url: '/order-history/list/'+data.customerId ,//数据接口
            page: true ,//开启分页
            limit:10,//每页显示的条数，默认10
            limits:[2,5,10,15,], //每页显示条数选择框数据
            request:{
                pageName: 'current',
                limitName: 'size'
            },
            cols: [[ //表头
                {field: 'id', title: '订单编号', width:'10%', sort: true, align:'center'},
                {field: 'orderTime', title: '日期', width:'25%', sort: true,align:'center'},
                {field: 'deliverGoods', title: '送货地址', width:'25%',align:'center'},
                {field: 'status', title: '状态', width:'15%',align:'center',templet:function(d){
                        return d.status ===0?"未回款":"已汇款"
                    }},
                {title:'操作',width:'25%',toolbar:'#orderTool',align:'center'}
            ]]
        });
        table.on('tool(list)',function(obj){
            switch (obj.event){
                case 'show-btn':
                    var data = myEncode(obj.data);
                    window.location.href = "order.html?data="+data;
                    break;
            }
        });
    });




});