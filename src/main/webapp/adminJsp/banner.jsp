<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">

    $(function(){


        $("#BannerTable") .edatagrid({
            fitColumns:true,
            fit:true,
            url:"${pageContext.request.contextPath}/banner/queryDto",
            //updateUrl:"${pageContext.request.contextPath}/banner/updateBanner",
            pagination:true,
            pageSize:3,
            pageList:[1,3,5,7,9],
            toolbar:tb,
            view: detailview,
            columns: [[

                {field: 'title', title: '标题', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required:true}
                    },formatter:status
                },
                {field: 'pubDate', title: '时间', width: 100},
                {field: 'descption', title: '详细描述'}
            ]],
            detailFormatter: function (rowIndex, rowData) {

                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/userJsp/img/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.descption + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
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
<table id="BannerTable">

</table>
<div id="tb">
    <a id="bannerAdd">添加</a>
    <a id="bannerUpdate">修改</a>
    <a id="bannerDelete">删除</a>
    <a id="bannerSave">保存</a>
</div>
<div id="Bannerdialog"></div>