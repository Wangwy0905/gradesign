<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function(){
        $("#FirstCategory").textbox({
            required:true
        });

        $("#AddFirstCategoryButton").linkbutton({
            plain:true,
            onClick:function(){
                $("#FistCategoryForm").form("submit",{
                    url:"${pageContext.request.contextPath}/category/addFirstCategory",
                    onSubmit:function(){
                        $("#FistCategoryForm").form("validate");
                    },
                    success:function(){

                        $("#PruductCategory").treegrid("reload");
                        $("#FirstCategoryDialog").dialog("close");
                    }

                })
            }
        });
    });

</script>

<form id="FistCategoryForm" method="post">
    <table>

        <tr>
            <td>
                总类别名字:
            </td>
            <td >
                <input id="FirstCategory" name="categoryName"/>
            </td>
        </tr>
    </table>
    <a id="AddFirstCategoryButton">提交</a>


</form>
