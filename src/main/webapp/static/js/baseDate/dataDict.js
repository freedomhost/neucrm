layui.use(['form','jquery','table','layer'],function(){
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table;
        // layer = layui.layer;

    //加载数据表格
    let tabInstance = table.render({
        id:'id',
        elem: '#dataDictList',
        url: '/data-dict/list', //数据接口
        page: true, //开启分页
        limit:10, //每页显示的条数，默认10
        limits:[2,5,10,15,20], //每页显示条数选择框数据
        request:{
            pageName: 'current',
            limitName: 'size'
        },
        cols: [[ //表头
            {field: '', title: '序号',type: 'numbers',width: 60},
            {field: 'type', title: '类别',sort: true},
            {field: 'title', title: '条目'},
            {field: 'value', title: '值',sort: true},
            {field: 'status', title: '是否可编辑', templet: function(d){
                return d.status === 0 ?"是":"否";
            }},
            {field: 'id', title: '操作', toolbar: '#bar'},
        ]]
    });

    //监听查询按钮，重新加载表格数据
    form.on('submit(search)',function (data) {
        console.log(data.field);
        tabInstance.reload({
            where : data.field,
            page : {curr: 1}
        });
    });

    //监听行工具事件（编辑 删除）
    table.on('tool(dataDictList)', function(obj){
        var data = obj.data;
        console.log(obj);
        console.log(data);
        if(obj.event === 'del'){
            layer.confirm('确认删除条目'+data.title, function(index){
                console.log(index);
                // obj.del();
                $.post('/data-dict/del/'+data.id,function (info) {
                    layer.close(index);
                    layer.msg(info.msg);
                    tabInstance.reload({
                        page : {curr:1}
                    });
                });
            });
        } else if(obj.event === 'edit'){
            if (data.status === 0){
                layer.open({
                    type: 2,
                    content: '/pages/baseDate/editDataDict.html',
                    skin:'layui-layer-molv',
                    title:"编辑数据字典",
                    area:["500px","400px"],
                    value: data,
                    //将数据赋值给弹框元素对象
                    success: function (layero,index) {
                            let iframe = layer.getChildFrame('body', index);
                            let ddForm = layer.getChildFrame('body', index).find("#DDForm");
                            iframe.find('#id').val(data.id);
                            iframe.find('#type').val(data.type);
                            iframe.find('#title').val(data.title);
                            iframe.find('#value').val(data.value);
                    }
                    /*btn:['确定','关闭'],
                    yes: function(index, layero){
                        let ddForm = layer.getChildFrame('body', index).find("#DDForm");
                        let data = {};
                        //把数组转为JSON
                        ddForm.serializeArray().forEach(function(val){
                            data[val.name] = val.value;
                        });
                        console.log(data);
                        $.post('/data-dict/edit',data,function(info){
                            layer.close(index);
                            layer.msg(info.msg);
                            tabInstance.reload();
                        });
                    }*/
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                    layer.msg(info.msg);
                    tabInstance.reload();
                });
            }else {
                layer.msg("不可编辑！");
            }

        }
    });

    //监听添加事件
    $(".add_btn").click(function () {
         layer.open({
             type: 2,
             content: '/pages/baseDate/addDataDict.html',
             skin:'layui-layer-molv',
             title:"新建数据字典",
             area:["500px","400px"],
             shade: 0.3,
             maxmin: false
/*             btn:['确定','关闭'],
             yes: function(index, layero){
                 let ddForm = layer.getChildFrame('body', index).find("#DDForm");
                 let data = {};
                 //把数组转为JSON
                 ddForm.serializeArray().forEach(function(val){
                     data[val.name] = val.value;
                 });
                 console.log(data);
                 $.post('/data-dict/save',data,function(info){
                     layer.close(index);
                     layer.msg(info.msg);
                     tabInstance.reload();
                 });
             }*/
         })
    });

});