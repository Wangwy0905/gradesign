<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function(){
        $("#AddCategoryName").textbox({
            required:true
        });

        $("#AddSecondCategoryButton").linkbutton({
            plain:true,
            onClick:function(){
                $("#AddSecondCategoryForm").form("submit",{
                    url:"${pageContext.request.contextPath}/category/addSecondCategory?cateId="+cateId,
                    onSubmit:function(){
                        $("#AddSecondCategoryForm").form("validate");
                    },
                    success:function(){
                        $.messager.show({
                            title:"系统提示",
                            msg:"添加成功!",
                            showType:"show",
                            width:300,
                            height:200
                        });
                        $("#PruductCategory").treegrid("reload");
                        $("#SecondCategoryDialog").dialog("close");
                    }

                })
            }
        });
    });

</script>

<form id="AddSecondCategoryForm" method="post">
    <table>

        <tr>
            <td>
                分类名:
            </td>
            <td >
                <input id="AddCategoryName" name="CategoryName"/>
            </td>
        </tr>


        </tr>

    </table>
    <a id="AddSecondCategoryButton">提交</a>

</form>
