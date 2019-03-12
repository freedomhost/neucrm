layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table,
        form=layui.form,
        $ = layui.$;
    var tableIns;

    var data;
    var str = window.location.href.split("data=")[1];
    if(str!=null)data= myUncode(str);//解密
    var id = data.customerId;
    $.post("/customer-info/getCustomer/"+id,function (value) {
        console.log(value.customerName);
        if(data!=null) {
            console.log(data);
            //
            if (data.id != null)
                $("#id").val(data.id);
            //
            if (data.orderTime != null)
                $("#orderTime").val(data.orderTime);
            //
            if (data.deliverGoods != null)
                $("#deliverGoods").val(data.deliverGoods);
            //
            if (data.totalAmount != null)
                $("#totalAmount").val(data.totalAmount);
            //
            if (data.status != null)
                $("#status").val(data.status);
            //客户名字
            if(value.customerName != null)
                $("#customerName").val(value.customerName);
        }
        $("#return-btn").click(function () {
            window.location.href="../order/history.html?id="+value.customerId;
        });
    });

    tableIns = table.render({
        elem: '#list',
        height: 'full-150',
        url: '/order-info/list/'+data.id ,//数据接口
        page: true ,//开启分页
        limit:10,//每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'productName', title: '商品', width:'25%', align:'center'},
            {field: 'num', title: '数量', width:'10%',align:'center'},
            {field: 'units', title: '单位', width:'25%',align:'center'},
            {field: 'price', title: '单价（元）', width:'20%',align:'center'},
            {field: 'money', title: '金额（元）', width:'20%',align:'center'}
        ]]
    });
});