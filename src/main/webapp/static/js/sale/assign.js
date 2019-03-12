layui.use(['form','jquery','table','layer','laydate'],function(){
    var table = layui.table,
        form = layui.form,
        laydate = layui.laydate,
        $ = layui.$;

    laydate.render({
        elem: '#assignTime'
        ,type: 'datetime'
    });

    var hidName = $("#hidName").val();

    var assignd = $.get("/sopt/role",function(o){
        o.forEach(function (value) {
            if(value.name == hidName){
                $("#assignName").append('<option selected="selected" value='+value.name+'>'+value.name+'</option>');
            }
            else{
                $("#assignName").append("<option value="+value.name+">"+value.name+"</option>");
            }
        });
        form.render('select');
    });

    form.on('submit(save-btn)', function(obj){
        var data = {};
        $('#soptunity').serializeArray().forEach(function(val){
            data[val.name] = val.value;
        });
        if($("#assignName").length > 0) {
            var result = $("#assignName").find("option:selected").val();
            data["assignName"] = result ;
        }
        console.log(data);
        $.post('/sopt/save-edit',data,function (info) {
            layer.msg(info.msg);
            parent.layer.close(parent.layer.getFrameIndex(window.name));
        });
        return false;

    });
});