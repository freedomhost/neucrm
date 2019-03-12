layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table,
        form=layui.form,
        $ = layui.$;
    var tableIns;

    var data;
    var str = window.location.href.split("data=")[1];
    if(str!=null)data= myUncode(str);//解密

    $("#return-btn").click(function () {
        window.location.href="../customer/show.html?data="+str;
    });
    var isMgr = true;

    tableIns = table.render({
        elem: '#list',
        height: 'full-200',
        url: '/customer-contact/list/'+data.customerId ,//数据接口
        page: true ,//开启分页
        limit:10,//每页显示的条数，默认10
        limits:[2,5,10,15,], //每页显示条数选择框数据
        done: function(res, curr, count){
            if(data!=null) {
                $.post('/system-user/login-info',function (info) {
                    //不是负责经理
                    if(info.data.name!=data.customerMgr){
                        $("#add-btn").attr("disabled",true);
                        $("#add-btn").css("background-color","#aaa");
                        $(".mybtn").addClass("gary-btn");
                        isMgr = false;
                    }
                })
                //客户id
                if (data.customerId != null)
                    $("#customerId").val(data.customerId);
                //客户名字
                if (data.customerName != null)
                    $("#customerName").val(data.customerName);
            }
        },
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: 'name', title: '姓名', width:'10%', sort: true, align:'center'},
            {field: 'sex', title: '性别', width:'7%',align:'center'},
            {field: 'job', title: '职位', width:'13%',align:'center'},
            {field: 'phone', title: '办公电话', width:'20%',align:'center'},
            {field: 'tel', title: '手机', width:'20%',align:'center'},
            {field: 'remark', title: '备注', width: '15%',align:'center'},
            {title:'操作',width:'15%',toolbar:'#contactorTool',align:'center'}
        ]]
    });
    $("#help-btn").click(function () {
            layer.open({
                type: 0,
                title:'帮助说明',
                skin: 'layui-layer-rim', //加上边框
                area: ['380px', '180px'], //宽高
                content: '编辑时带＊为必填项'
            })
        }
    );

    $("#add-btn").click(function () {
        if(isMgr){
            layer.open({
            type: 2,
            title:'新建联系人',
            skin: 'layui-layer-rim', //加上边框
            area: ['750px', '330px'], //宽高
            content: 'save-edit.html?customerId='+data.customerId,
            end:function () {
                tableIns.reload();
            }
             });
        }

    });
    $('#refur').click(function () {
        tableIns.reload({where: {}});
    });
    table.on('tool(list)',function(obj){
        if(isMgr){
            switch (obj.event){
                case 'edit-btn':
                    console.log(obj);
                    var contactorData = myEncode(obj.data);
                    layer.open({
                        type: 2,
                        title:'编辑联系人',
                        skin: 'layui-layer-rim', //加上边框
                        area: ['750px', '330px'], //宽高
                        content: 'save-edit.html?data='+contactorData,
                        end:function () {
                            tableIns.reload();
                        }
                    });
                    break;
                case 'del-btn':
                    layer.confirm('你确定要删除吗？',{icon:3,skin:'layui-layer-molv' ,btn: ["确定","取消"]}, function(){
                        $.post('/customer-contact/del/'+obj.data.id,function(info){
                            tableIns.reload();
                            layer.msg(info.msg);
                        });
                    },
                    function(){
                        tableIns.reload();
                    });
                    break;
            }
        }else{
            layer.msg("没有权限");
        }
    });

    form.on('submit(search)',function (data) {
        tableIns.reload({
            where :data.field
        } );
        return false;
    });
});