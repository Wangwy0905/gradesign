<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
    $(function(){

        $("#ComputerMessage") .edatagrid({
            fitColumns:true,
            fit:true,
            url:"${pageContext.request.contextPath}/computer/queryAll?cateId="+cateId,
            pagination:true,
            pageSize:5,
            pageList:[1,3,5,7,9],
            view:detailview,
            columns: [[
                {field: 'productName', title: '电脑名', width: 100},
                {field: 'description', title: '详细描述', width: 100},
                {field: 'price', title: '价格', width: 100},
                {field: 'repertory', title: '库存', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required:true}
                    },formatter:status
                },
                {field: 'chuliqi', title: '处理器', width: 100},
                {field: 'neicuntiao', title: '内存条',width:100},


            ]],
            detailFormatter: function (rowIndex, rowData) {
                console.log(rowData+"11111");
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/picture/Lenovo/'+ rowData.comPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.color + '</p>' +
                    '<p>日期: ' + rowData.createTime + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });

    });

    function status(value,row,idx) {

        if(row.status==1){
            return "是";
        }else{
            return "否";
        }
    }
</script>

<table id="ComputerMessage"></table>
