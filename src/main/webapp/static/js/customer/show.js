layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;

    var data;//解密
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密



    form.on('submit(save-btn)', function(obj){
        layer.confirm('你确定要更新当前客户吗？',{icon:3,anim:0,skin:'layui-layer-lan'},function(index){
            console.log(obj.field);
            $.post('/customer-info/edit',obj.field,function (info) {
                str = myEncode(obj.field);
                layer.msg(info.msg);
                layer.close(index);
            });
        });
        return true; //跳转。如果需要表单跳转，去掉这段即可。
    });

    form.verify({
        fax: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!(/^(\d+)(\-{0,1}(\d+))$/.test(value))){
                return '传真格式不正确！！';
            }
            if(value==''){
                return '传真不能为空！！';
            }
        }
    });

    $("#help-btn").click(function () {
        layer.open({
            type: 0,
            title:'帮助说明',
            skin: 'layui-layer-rim', //加上边框
            area: ['380px', '180px'], //宽高
            content: '带＊为必填项'
        })
    }
    );

    $("#contactor-btn").click(function () {
        window.location.href="../contactor/list.html?data="+str;
    });
    $("#contactRecord-btn").click(function () {
        window.location.href="../contactRecord/list.html?data="+str;
    });
    $("#history_btn").click(function () {
        window.location.href="../order/history.html?id="+data.customerId;
    });

    if(data!=null) {
        //判断是不是负责经理
        $.post('/system-user/login-info',function (info) {
            //不是负责经理
            if(info.data.name!=data.customerMgr){
                $("#fieldset").attr("disabled",true);
                $("#customerMgr").attr("disabled",true);
                $("#city").attr("disabled",true);
                $("#customerGrade").attr("disabled",true);
                $("#customerSatisfaction").attr("disabled",true);
                $("#customerCredit").attr("disabled",true);
                $("#msg").css("display","inline-block");
            }else{
                $("#save-btn").css("display","inline-block");
            }
            form.render();
        });

        //客户id
        if(data.customerId!=null)
            $("#customerId").val(data.customerId);
        //客户名字
        if(data.customerName!=null)
            $("#customerName").val(data.customerName);
        //客户地区
        if(data.city!=null) {
            var flg=false;
            $("#city option").each(function (index,element) {
                if (element.value===data.city){
                    element.selected = true;
                    flg=true;
                    return;
                }
            });
            if(!flg)
                $("#city").append("<option selected>"+data.city+"</option>")
        }else{
            $("#city").append("<option selected>"+"暂未设置"+"</option>");
        }
        //客户经理
        var customerMgr=$("#customerMgr");
        $.post("/system-user/customer-mgr",function(o){
            if(data.customerMgr!=null) {
                o.forEach(function (value) {
                    if(value.name === data.customerMgr)
                        customerMgr.append("<option value="+value.name+" selected>"+value.name+"</option>");
                    else
                        customerMgr.append("<option value="+value.name+">"+value.name+"</option>");
                });
                form.render();
            }else{
                customerMgr.append("<option selected>"+"暂未设置"+"</option>");
                o.forEach(function (value) {
                    customerMgr.append("<option value="+value.name+">"+value.name+"</option>");
                });
                form.render();
            }
        });
        //客户等级
        var customerGrade =$("#customerGrade")
        $.post("/data-dict/get/企业客户等级",function(o){
            if(data.customerGrade!=null) {
                o.data.forEach(function (value) {
                    if(value.title == data.customerGrade)
                        customerGrade.append("<option value=" + value.title + " selected>" + value.title + "</option>");
                    else
                        customerGrade.append("<option value="+value.title+">"+value.title+"</option>");
                });
                form.render();
            }else{
                customerGrade.append("<option selected>"+"暂未设置"+"</option>");
                o.data.forEach(function (value) {
                    customerGrade.append("<option value="+value.title+">"+value.title+"</option>");
                });
                form.render();
            }
        });
        //客户满意度
        if(data.customerSatisfaction!=null) {
            var list=$("#customerSatisfaction option").each(function (index,element) {
                if (element.value===data.customerSatisfaction){
                    element.selected = true;
                }
            });

        }else{
            $("#customerSatisfaction").append("<option selected>"+"暂未设置"+"</option>");
        }
        //客户信用度
        if(data.customerCredit!=null) {
            var list=$("#customerCredit option").each(function (index,element) {
                if (element.value===data.customerCredit){
                    element.selected = true;
                }
            });
        }else{
            $("#customerCredit").append("<option selected>"+"暂未设置"+"</option>");
        }
        //地址
        if(data.address!=null)
            $("#address").val(data.address);
        //邮政编码
        if(data.postalCode!=null)
            $("#postalCode").val(data.postalCode);
        //电话
        if(data.phone!=null)
            $("#phone").val(data.phone);
        //传真
        if(data.fax!=null)
            $("#fax").val(data.fax);
        //网址
        if(data.ulr!=null)
            $("#ulr").val(data.ulr);
        //营业执照注册号
        if(data.businessLicense!=null)
            $("#businessLicense").val(data.businessLicense);
        //法人
        if(data.juridicalPerson!=null)
            $("#juridicalPerson").val(data.juridicalPerson);
        //注册资金
        if(data.registeredCapital!=null)
            $("#registeredCapital").val(data.registeredCapital);
        //年营销额
        if(data.annualSales!=null)
            $("#annualSales").val(data.annualSales);
        //开户银行
        if(data.depositBank!=null)
            $("#depositBank").val(data.depositBank);
        //银行账号
        if(data.bankAccount!=null)
        $("#bankAccount").val(data.bankAccount);
        //地税登记号
        if(data.landTaxCode!=null)
            $("#landTaxCode").val(data.landTaxCode);
        //国税登记号
        if(data.centralTax!=null)
            $("#centralTax").val(data.centralTax);


    }

    form.render();
});

