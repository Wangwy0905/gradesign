<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head lang="en">
    <meta charset="utf-8" />
    <title>易瑞商城</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <script type="text/javascript">
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/category/querySecond",
            data:"pid1=1&pid2=7&pid3=11&pid4=18",
            async:false,
            success:function(){
                alert();
            }
        });
    </script>

</head>
<body>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
            <h1 class="fl"><a href="index.html"><img src="${pageContext.request.contextPath}/img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <a href="#" id="login">登录</a>
                    <a href="#" id="reg">注册</a>
                </p>
                <form action="#" method="get" class="fl">
                    <input type="text" placeholder="热门搜索：联想电脑" />
                    <input type="button" />
                </form>
                <div class="btn fl clearfix">
                    <a href="mygxin.html"><img src="${pageContext.request.contextPath}/img/grzx.png"/></a>
                    <a href="#" class="er1"><img src="${pageContext.request.contextPath}/img/ewm.png"/></a>
                    <a href="cart.html"><img src="${pageContext.request.contextPath}/img/gwc.png"/></a>
                    <p><a href="#"><img src="${pageContext.request.contextPath}/img/smewm.png"/></a></p>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="${pageContext.request.contextPath}/userJsp/index.jsp">首页</a></li>
            <li>
                <a href="#">所有商品</a>
                <div class="sList">
                    <div class="wrapper  clearfix">
                        <a href="paint.html">
                            <dl>
                                <dt><img src="../img/nav1.jpg"/></dt>
                                <dd>品牌电脑</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="../img/nav2.jpg"/></dt>
                                <dd>电脑配件</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="../img/nav3.jpg"/></dt>
                                <dd>外设设备</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="../img/nav6.jpg"/></dt>
                                <dd>游戏必备</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="../img/nav7.jpg"/></dt>
                                <dd>推荐商品</dd>
                            </dl>
                        </a>
                    </div>
                </div>
            </li>
            <li><a href="flowerDer.html">品牌电脑</a>
                <div class="sList2">
                    <div class="clearfix">
                        <a href="proList.html">联想</a>
                        <a href="vase_proList.html">华硕</a>
                    </div>
                </div>
            </li>
            <li><a href="javascript:void(0)">电脑配件</a>
                <div class="sList2">
                    <div class="clearfix">
                        <c:forEach var="c" items="${sessionScope.list2}">
                            <a href="zbproList.html">${c.categoryName}</a>
                        </c:forEach>
                    </div>
                </div>
            </li>
            <li><a href="javascript:void(0)">外设产品</a>
                <div class="sList2">
                    <div class="clearfix">
                        <c:forEach var="c" items="${sessionScope.list3}">
                        <a href="zbproList.html">${c.categoryName}</a>
                       </c:forEach>
                    </div>
                </div>
            </li>
            <li><a href="javascript:void(0)">游戏装备</a>
                <div class="sList2">
                    <div class="clearfix">
                        <div class="clearfix">
                            <c:forEach var="c" items="${sessionScope.list4}">
                                <a href="zbproList.html">${c.categoryName}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </li>
            <li><a href="perfume.html">关于我们</a>
                <div class="sList2">
                    <div class="clearfix">

                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>

</body>
</html>
