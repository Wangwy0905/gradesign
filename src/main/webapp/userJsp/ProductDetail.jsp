<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!------------------------------head------------------------------>
<%@include file="../userJsp/header.jsp"%>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.html">首页</a>
        <span>/</span>
        <a href="flowerDer.html">装饰摆件</a>
        <span>/</span>
        <a href="proList.html">干花花艺</a>
        <span>/</span>
        <a href="#" class="on">【最家】非洲菊仿真花干花</a>
    </div>
</div>
<!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <>
            <div class="proImg fl">
                <img class="det" src="${pageContext.request.contextPath}/userJsp/img/${sessionScope.computer.comPic}"/>

            </div>
            <div class="fr intro">
                <div class="title">
                    <h4>【最家】非洲菊仿真花干花</h4>
                    <p>【破损补寄】【适合放室内、卧室、书房、餐桌、办公室、客厅、电视柜等地方】【无理由退换货】【包邮】【白色现代简约花瓶】</p>
                    <span>￥59.90</span>
                </div>
                <div class="proIntro">
                    <p>数量&nbsp;&nbsp;库存<span>${sessionScope.computer.repertory}</span>件</p>
                    <div class="num clearfix">
                        <img class="fl sub" src="img/temp/sub.jpg">
                        <span class="fl" contentEditable="true">1</span>
                        <img class="fl add" src="img/temp/add.jpg">
                        <p class="please fl">请选择商品属性!</p>
                    </div>
                </div>
                <div class="btns clearfix">
                    <a href="#2"><p class="buy fl">立即购买</p></a>
                    <a href="#2"><p class="cart fr">加入购物车</p></a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix">
            <!--<a class="on">商品详情</a>-->
            <a>所有评价</a>
        </div>

        <div class="eva">
            <div class="per clearfix">
                <img class="fl" src="img/temp/per01.jpg">
                <div class="perR fl">
                    <p>馨***呀</p>
                    <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                    <div class="clearfix">
                        <p><img src="img/temp/eva01.jpg"></p>
                        <p><img src="img/temp/eva02.jpg"></p>
                        <p><img src="img/temp/eva03.jpg"></p>
                        <p><img src="img/temp/eva04.jpg"></p>
                        <p><img src="img/temp/eva05.jpg"></p>
                    </div>
                    <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                </div>
            </div>
            <div class="per clearfix">
                <img class="fl" src="img/temp/per02.jpg">
                <div class="perR fl">
                    <p>么***周</p>
                    <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                    <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="like">
    <h4>猜你喜欢</h4>
    <div class="bottom">
        <div class="hd">
            <span class="prev"><img src="img/temp/prev.png"></span>
            <span class="next"><img src="img/temp/next.png"></span>
        </div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like01.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like02.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like03.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like04.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html" class="last">
                        <dl>
                            <dt><img src="img/temp/like05.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                </div>
                <div>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like01.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like02.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like03.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like04.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html" class="last">
                        <dl>
                            <dt><img src="img/temp/like05.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<!--返回顶部-->
<div class="gotop">
    <a href="cart.html">
        <dl class="goCart">
            <dt><img src="img/gt1.png"/></dt>
            <dd>去购<br />物车</dd>
            <span>1</span>
        </dl>
    </a>
    <a href="#" class="dh">
        <dl>
            <dt><img src="img/gt2.png"/></dt>
            <dd>联系<br />客服</dd>
        </dl>
    </a>
    <a href="mygxin.html">
        <dl>
            <dt><img src="img/gt3.png"/></dt>
            <dd>个人<br />中心</dd>
        </dl>
    </a>
    <a href="#" class="toptop" style="display: none;">
        <dl>
            <dt><img src="img/gt4.png"/></dt>
            <dd>返回<br />顶部</dd>
        </dl>
    </a>
    <p>13213787982</p>
</div>
<div class="msk"></div>
<!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot1.png"/></a>
                <span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot2.png"/></a>
                <span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot3.png"/></a>
                <span class="fl">正品包邮</span>
            </div>
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot4.png"/></a>
                <span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">易瑞商城，本店保证所有商品均为正品，绝无虚假<br />
        店主联系电话：13269828106  ，违法和不良信息举报电话：13213787982   </p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    jQuery(".bottom").slide({titCell:".hd ul",mainCell:".bd .likeList",autoPage:true,autoPlay:false,effect:"leftLoop",autoPlay:true,vis:1});
</script>
</body>
</html>
