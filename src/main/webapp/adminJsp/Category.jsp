<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
    var toolbar = [{

        text: "添加总类",
        iconCls: 'icon-add',
        handler: function () {

            $("#FirstCategoryDialog").dialog("open");
        },

    },'-', {
        text: "添加分类别",
        iconCls:"icon-add",
        handler: function () {
            var rowSecondCategory = $("#PruductCategory").treegrid("getSelected");

            if (rowSecondCategory == null) {
                $.messager.alert("警告", "请先选中总类别");
            }else{
                if (!isNaN(rowSecondCategory.id)) {
                    //获取指定行
                    cateId = rowSecondCategory.id;
                    $("#SecondCategoryDialog").dialog("open");

                } else {
                    $.messager.alert("警告", "请先选中总行");
                }
            }
        }
    }];
    $(function () {
        $('#PruductCategory').treegrid({

            url:'${pageContext.request.contextPath}/category/queryAllByPage',
            pagination:true,
            pageSize:3,
            pageList:[1,3,5,7,9],
            idField:'id',
            treeField:'categoryName',
            columns:[[
                {field:'categoryName',title:'名字',width:60}
            ]],
            fit:true,
            fitColumns:true,
            toolbar:toolbar,
        });
        $("#FirstCategoryDialog").dialog({
            title:"添加总类",
            width:400,
            height:200,
            closed:true,
            cache:false,
            href:'${pageContext.request.contextPath}/adminJsp/addFirstCategory.jsp'
        });
        $("#SecondCategoryDialog").dialog({
            title:"添加总类",
            width:400,
            height:200,
            closed:true,
            cache:false,
            href:'${pageContext.request.contextPath}/adminJsp/addSecondCategory.jsp'
        });

    });

</script>

<table id="PruductCategory"></table>
<div id="FirstCategoryDialog"></div>
<div id="SecondCategoryDialog"></div>
