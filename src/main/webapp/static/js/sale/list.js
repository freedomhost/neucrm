layui.use(['form','jquery','table','layer','laydate'],function(){
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;
        var tabInstance;
       //获取当前用户的角色
        var loginN;
        var roleN;
        $.get('/system-user/login-info',function (info) {
            roleN = info.data.roleName;
            loginN = info.data.name;
        });

        tabInstance = table.render({
            elem: '#userList',
            url: '/sopt/list', //数据接口
            page: true, //开启分页
            limit:5, //每页显示的条数，默认10
            limits:[3,5,10],
            request:{
                pageName: 'current',
                limitName: 'size'
            },
            cols: [[ //表头
                {field: 'id', title: '编号', width:80, sort: true, fixed: 'left',align:'center'},
                {field: 'name', title: '客户名称',align:'center'},
                {field: 'outline', title: '概要',align:'center'},
                {field: 'contacts', title: '联系人',align:'center'},
                {field: 'contactsTel', title: '联系人电话',align:'center'},
                {field: 'creationTime', title: '创建时间',align:'center'},
                {title: '操作', width:160,toolbar:"#userTool",align:'center'}
            ]]
        });


        //工具栏操作
        table.on('tool(userList)',function(obj){
            switch (obj.event){
                case 'assign_btn':
                    if(roleN == "客户经理"){
                        layer.alert('客户经理不能指派销售机会', {
                            icon: 7,
                            title: "提示"
                        });
                        return false;
                        break;
                    }
                    if(obj.data.status == 1){
                        layer.alert('客户 <b>'+obj.data.name+'</b> 已被指派', {
                            icon: 7,
                            title: "提示"
                        });
                        return false;
                        break;
                    }
                    else{
                        //指派
                        var data = obj.data;
                        layer.open({
                            type: 2,
                            title:'指派',
                            skin: 'layui-layer-molv', //加上边框
                            area: ['900px', '556px'], //宽高
                            content: '/pages/sale/assign.html',
                            value: data,
                            //将数据赋值给弹框元素对象
                            success: function (layero,index) {
                                var iframe = layer.getChildFrame('body', index);
                                iframe.find('#id').val(data.id);
                                iframe.find('#opportunitySource').val(data.opportunitySource);
                                iframe.find('#name').val(data.name);
                                iframe.find('#successProbability').val(data.successProbability);
                                iframe.find('#outline').val(data.outline);
                                iframe.find('#contacts').val(data.contacts);
                                iframe.find('#contactsTel').val(data.contactsTel);
                                iframe.find('#opportunityDesc').val(data.opportunityDesc);
                                iframe.find('#foundName').val(data.foundName);
                                iframe.find('#creationTime').val(data.creationTime);
                                iframe.find('#hidName').val(data.assignName);
                            },
                            end:function () {
                                tabInstance.reload();
                            }
                        });
                    }
                    break;
                //编辑
                case 'edit_btn':
                    var data = obj.data;
                    if(data.status != 0){
                        layer.alert('客户 <b>'+data.name+"</b> 已被指派,不可编辑", {
                            icon: 7,
                            title: "提示"
                        });
                        break;
                    }
                    layer.open({
                        type: 2,
                        title:'编辑',
                        skin: 'layui-layer-molv', //加上边框
                        area: ['900px', '500px'], //宽高
                        content: '/pages/sale/edit.html',
                        value: data,
                        //将数据赋值给弹框元素对象
                        success: function (layero,index) {
                            var iframe = layer.getChildFrame('body', index);
                            iframe.find('#id').val(data.id);
                            iframe.find('#opportunitySource').val(data.opportunitySource);
                            iframe.find('#name').val(data.name);
                            iframe.find('#successProbability').val(data.successProbability);
                            iframe.find('#outline').val(data.outline);
                            iframe.find('#contacts').val(data.contacts);
                            iframe.find('#contactsTel').val(data.contactsTel);
                            iframe.find('#opportunityDesc').val(data.opportunityDesc);
                            iframe.find('#foundName').val(data.foundName);
                            iframe.find('#creationTime').val(data.creationTime);
                        },
                        end:function () {
                            tabInstance.reload();
                        }
                    });
                    break;
                //删除
                case 'del_btn':
                    if(obj.data.status != 0){
                        layer.alert('客户 <b>'+obj.data.name+"</b> 已被指派,不可删除", {
                            icon: 7,
                            title: "提示"
                        });
                        break;
                    }
                    layer.confirm('你确定要删除客户 <b>'+obj.data.name+'</b> 吗？',{icon:3,anim: 4,skin:'layui-layer-molv'},function(){
                            $.post('/sopt/del/'+obj.data.id,function(data){
                                layer.msg(data.msg);
                                tabInstance.reload({
                                    page : {curr :1}
                                });
                            });
                        });
                    break;
            }
        });

        //帮助
        $("#btn1").click(function(){
            layer.open({
                type: 2,
                title:"详细功能",
                content: '/pages/sale/help.html',
                skin:'layui-layer-molv',
                area:["600px","400px"],
                btn:['关闭'],
            });
        });

        //添加
        $("#btn2").click(function(){
            layer.open({
                type: 2,
                content: '/pages/sale/add.html',
                skin:'layui-layer-molv',
                title:"营销机会",
                area:["900px","500px"],
                success: function (layero,index) {
                    var iframe = layer.getChildFrame('body', index);
                    iframe.find('#foundName').val(loginN);
                }
            });
        });
        //查询
        $("#btn3").on("click",function () {
               var datastr="";
               $("#search").find("input").each(function () {
                   datastr += "\""+$(this).attr("name")+"\":"+"\""+$.trim($(this).val())+"\""+",";
                   $(this).val("");
               })
               datastr = "{"+datastr.substr(0,datastr.length-1)+"}";
               var isop = JSON.parse(datastr);
               tabInstance.reload({
                    where : isop,
                    page : {curr: 1}
               });
        });
});
