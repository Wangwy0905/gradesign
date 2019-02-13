<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
  /*  var toolbar =[{
        iconCls:'icon-add',
        text:'管理员详情',
        handler:function(){
            var row=$("#")
        }
    }]
*/
    $(function(){
        $("#AdminMessage").datagrid({
           url:"${pageContext.request.contextPath}/admin/queryAdminDto",
            pagination:true,
            pageSize:3,
            pageList:[1,3,5,7,9],
            columns:[[
                {field:'username',title:'名字',width:60},
                {field:'password',title:'密码',width:60},
                {field:'grade',title:'等级',width:60}
            ]],
            fit:true,
            fitColumns:true,
            //toolbar:toolbar
        });
    });
</script>

<table id="AdminMessage"></table>
<div id="AdminMessageDialog"></div>