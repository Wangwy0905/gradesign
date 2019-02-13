<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8" />
    <title>易瑞商城</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/public.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<!------------------------------head------------------------------>
<%@include file="../userJsp/header.jsp"%>
<!-------------------------banner--------------------------->
<div class="block_home_slider">
   <div id="home_slider" class="flexslider">

    </div>
</div>
<script type="text/javascript">

    $.ajax({
        type:"POST",
        url:"${pageContext.request.contextPath}/banner/queryAllBanner",
        dataType:"JSON",
        async:false,
        success:function(result){
            var ul=$("<ul class='slides'>");
            var ul2=$("</ul>");
            for(var i=0;i<result.length;i++){
                var img="${pageContext.request.contextPath}/userJsp/img/"+result[i].imgPath;
                console.log(img);
                var td1=$("<li><div class='slide'><img src='"+img+"'/></div></li>");
                ul.append(td1);
            }
            $("#home_slider").append(ul).append(ul2);

        }
    });
</script>
<!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix">
        <a href="vase_proList.html"><img src="${pageContext.request.contextPath}/userJsp/img/3.jpg"/></a>
        <a href="proList.html"><img src="${pageContext.request.contextPath}/userJsp/img/4.jpg"/></a>
        <a href="#2"><img src="${pageContext.request.contextPath}/userJsp/img/5.jpg"/></a>
    </div>
</div>

<!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper">
        <h2><img src="${pageContext.request.contextPath}/img/ih1.jpg"/></h2>
        <div class="top clearfix">
            <a href="proDetail.html"><img src="${pageContext.request.contextPath}/img/n1.jpg"/><p></p></a>
            <a href="proDetail.html"><img src="${pageContext.request.contextPath}/img/n2.jpg"/><p></p></a>
            <a href="proDetail.html"><img src="${pageContext.request.contextPath}/img/n3.jpg"/><p></p></a>
        </div>
        <div class="bott clearfix">
            <a href="proDetail.html"><img src="${pageContext.request.contextPath}/img/n4.jpg"/><p></p></a>
            <a href="proDetail.html"><img src="${pageContext.request.contextPath}/img/n5.jpg"/><p></p></a>
            <a href="proDetail.html"><img src="${pageContext.request.contextPath}/img/n6.jpg"/><p></p></a>
        </div>
        <h2><img src="${pageContext.request.contextPath}/img/ih2.jpg"/></h2>
        <div class="flower clearfix tran">
            <a href="proDetail.html" class="clearfix">
                <dl>
                    <dt>
                        <span class="abl"></span>
                        <img src="${pageContext.request.contextPath}/img/flo1.jpg"/>
                        <span class="abr"></span>
                    </dt>
                    <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                    <dd><span>¥ 79.00</span></dd>
                </dl>
            </a>
            <a href="proDetail.html">
                <dl>
                    <dt>
                        <span class="abl"></span>
                        <img src="${pageContext.request.contextPath}/img/flo2.jpg"/>
                        <span class="abr"></span>
                    </dt>
                    <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                    <dd><span>¥ 79.00</span></dd>
                </dl>
            </a>
            <a href="proDetail.html">
                <dl>
                    <dt>
                        <span class="abl"></span>
                        <img src="${pageContext.request.contextPath}/img/flo3.jpg"/>
                        <span class="abr"></span>
                    </dt>
                    <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                    <dd><span>¥ 79.00</span></dd>
                </dl>
            </a>
        </div>

    </div>
</div>

<!------------------------------ad------------------------------>
<a href="#" class="ad"><img src="${pageContext.request.contextPath}/img/ib1.jpg"/></a>

<!------------------------------people------------------------------>
<div class="people">
    <div class="wrapper">
        <h2><img src="${pageContext.request.contextPath}/img/ih3.jpg"/></h2>
        <div class="pList clearfix tran">
            <a href="proDetail.html">
                <dl>
                    <dt>
                        <span class="abl"></span>
                        <img src="${pageContext.request.contextPath}/img/s7.jpg"/>
                        <span class="abr"></span>
                    </dt>
                    <dd>【最家】不锈钢壁饰墙饰软装</dd>
                    <dd><span>￥688.00</span></dd>
                </dl>
            </a>
            <a href="proDetail.html">
                <dl>
                    <dt>
                        <span class="abl"></span>
                        <img src="${pageContext.request.contextPath}/img/s10.jpg"/>
                        <span class="abr"></span>
                    </dt>
                    <dd>【最家】小城动物木板画壁挂北欧</dd>
                    <dd><span>￥188.00</span></dd>
                </dl>
            </a>
            <a href="proDetail.html">
                <dl>
                    <dt>
                        <span class="abl"></span>
                        <img src="${pageContext.request.contextPath}/img/s4.jpg"/>
                        <span class="abr"></span>
                    </dt>
                    <dd>【最家】玄关假山水壁饰背景墙饰挂件创意</dd>
                    <dd><span>￥599.00</span></dd>
                </dl>
            </a>
            <a href="proDetail.html">
                <dl>
                    <dt>
                        <span class="abl"></span>
                        <img src="${pageContext.request.contextPath}/img/s9.jpg"/>
                        <span class="abr"></span>
                    </dt>
                    <dd>【最家】金属树枝壁饰铜鸟装饰品</dd>
                    <dd><span>￥928.00</span></dd>
                </dl>
            </a>
        </div>


    </div>
</div>
<!--返回顶部-->
<div class="gotop">
    <a href="cart.html">
        <dl>
            <dt><img src="${pageContext.request.contextPath}/img/gt1.png"/></dt>
            <dd>去购<br />物车</dd>
        </dl>
    </a>
    <a href="#" class="dh">
        <dl>
            <dt><img src="${pageContext.request.contextPath}/img/gt2.png"/></dt>
            <dd>联系<br />客服</dd>
        </dl>
    </a>
    <a href="mygxin.html">
        <dl>
            <dt><img src="${pageContext.request.contextPath}/img/gt3.png"/></dt>
            <dd>个人<br />中心</dd>
        </dl>
    </a>
    <a href="#" class="toptop" style="display: none">
        <dl>
            <dt><img src="${pageContext.request.contextPath}/img/gt4.png"/></dt>
            <dd>返回<br />顶部</dd>
        </dl>
    </a>
    <p>400-800-8200</p>
</div>

<!-------------------login-------------------------->
<!--footer-->
<%@include file="../userJsp/footer.jsp"%>


<script type="text/javascript">
    $(function() {
        $('#home_slider').flexslider({
            animation: 'slide',
            controlNav: true,
            directionNav: true,
            animationLoop: true,
            slideshow: true,
            slideshowSpeed:2000,
            useCSS: false
        });



    });
</script>


</body>
</html>
