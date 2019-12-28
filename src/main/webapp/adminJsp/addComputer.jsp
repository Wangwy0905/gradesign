<%@page pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#name").textbox({
            required:true
        });
        $("#price").textbox({
            required:true
        });
        $("#describe").textbox({
            required:true
        });
        $("#color").textbox({
            required:true
        });
        $("#chuliqi").textbox({
            required:true
        });
        $("#neicuntiao").textbox({
            required:true
        });
        $("#comPic").filebox({
            required:true,
            editable:false
        });

        $("#createTime").datebox({
            required:true,
            editable:false
        });
        $("#categoryId").combobox({
           url:"${pageContext.request.contextPath}/category/queryAll",
            textField:"categoryName",
            valueField:"id",
            onLoadSuccess:function(data){
                $("#categoryId").combobox("setValue",data[0].id);
            }
        });



        $("#addComputerButton").linkbutton({

            plain:true,
            //iconCls:"icon-save",
            onClick:function(){
                /*提交表单*/
                $("#addComputerForm").form("submit",{
                    url:"${pageContext.request.contextPath}/computer/addComputer",
                    onSubmit:function(){
                        return $("#addComputerForm").form("validate");
                    },
                    success:function(){
                        $.messager.show({
                            title:"系统提示",
                            msg:"添加成功",
                            showType:"show",
                            width:300,
                            height:200
                        });
                        $("#addComputerDialog").dialog("close");
                        //重置表单数据
                        $("#addComputerForm").form("reset");
                    }
                });
            }
        });

    });

</script>

<form id="addComputerForm" method="post" enctype="multipart/form-data">

    <table>
        <tr>
            <td>商品名称:</td><td><input id="name" name="productName"/></td>
        </tr>
        <tr>
            <td>商品价格:</td><td><input id="price" name="price"/></td>
        </tr>
        <tr>
            <td>商品描述:</td><td><textarea id="describe" name="description"></textarea></td>
        </tr>
        <tr>
            <td>商品颜色:</td><td><input id="color" name="color"/></td>
        </tr>
        <tr>
            <td>处理器:</td><td><input id="chuliqi" name="chuliqi"/></td>
        </tr>
        <tr>
            <td>内存条:</td><td><input id="neicuntiao" name="neicuntiao"/></td>
        </tr>
        <tr>
            <td>商品图片:</td><td><input id="comPic" name="file"/></td>
        </tr>

        <tr>
            <td>创建日期:</td><td><input id="createTime" name="createTime"/></td>
        </tr>
        <tr>
            <td>所属类别:</td><td><input id="categoryId" name="categoryId"/></td>
        </tr>
        <tr>
            <td>商品状态:</td><td><input type="radio" value="1" name="status"/>在售
            <input type="radio" value="0" name="status"/>下架</td>
        </tr>



    </table>

    <a id="addComputerButton">提交</a>
</form>