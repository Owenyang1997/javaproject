<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no" >
    <title>软件工程创新实验室</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/style1.css">
    <link rel="stylesheet" href="static/css/base.css">
</head>
<body>
<!--导航栏-->
<jsp:include page="/top.jsp"></jsp:include>
<!--导航栏-->

<!--图片-->
<div class="home"></div>

<!--学生风采-->
<article class="content">
    <section class="mainWrap relative">
        <div class="commContent clearfix">
            <section class="channelInfo">

                <i></i>

                <nav class="nav"><a href="http://www.tsinghua.edu.cn/">首页</a> &middot; <a href="./index.html">学生风采</a></nav>

                <h2>学生风采</h2>

                <p class="yahei">安徽建筑大学培育和凝聚了一批又一批高水平的专家学者。近年来，学校遵循"引进与培养并举"的方针，加强青年队伍建设，在国内外选聘优秀人才，学生队伍水平稳步提高。</p>

            </section>

            <article class="mainContent">

                <header class="contentNav">

                    <h1 class="noNav"><a name="gk"></a>概况</h1>

                </header>

                <div class="articleIntro">

                    <p>安徽建筑大学软件工程实验室培育和凝聚了一批又一批高水平的学者。近年来，学校遵循"引进与培养并举"的方针，加强青年教师队伍建设，在国内外选聘优秀人才，学生水平稳步提高。</p>

                    <p>截至2017年12月底，学校现有教师3461人，其中45岁以下青年教师1758人。教师中具有正高级职务的1400人，具有副高级职务的1582人。现有教师中有诺贝尔奖获得者1名，图灵奖获得者1名，中国科学院院士51名，中国工程院院士37名，16名教授荣获国家级"高等学校教学名师奖"，163人入选教育部"长江学者奖励计划"特聘教授，58人入选讲座教授，36人入选青年学者，221人获得"国家杰出青年科学基金"，133人获得"优秀青年科学基金"，"海外高层次人才引进计划"（简称"千人计划"）入选者118人，在职"青年千人计划"入选者137人。</p>
                </div>
                <header class="contentNav">

                    <h1 class="noNav"><a name="jcrc"></a>杰出人才</h1>

                </header>

                <div class="articleIntro">

                    <p>　　安徽建筑大学培育和凝聚了一批又一批高水平的专家学者。近年来，学校遵循"引进与培养并举"的方针，加强青年教师队伍建设，在国内外选聘优秀人才，师资队伍水平稳步提高。</p>

                </div>
                <section class="article fullwidth">
                    <!--内容-->

                    <ul class="subChannelList subChannelListNoImg">
                        <c:forEach  items="${peopletype}" var="peo">
                        <c:if test="${peo.typeId%3!=2}" >
                        <li>

                            <figure style="height:300px;">
                                <figcaption><h3><a href="${pageContext.request.contextPath}/getpeople?state=${peo.typeId}">${peo.type}</a></h3></figcaption>

                                <p>${peo.context}</p>

                            </figure>

                        </li></c:if>
                            <c:if test="${peo.typeId%3==2}">
                        <li class="alternative">

                            <figure style="height:300px;">

                                <figcaption><h3><a href="${pageContext.request.contextPath}/getpeople?state=${peo.typeId}">${peo.type}</a></h3></figcaption>

                                <p>${peo.context}</p>

                            </figure>

                        </li>
                            </c:if>
                        </c:forEach>
                    <!--内容结束-->
                </section>

            </article>

        </div>
    </section>
</article>

<section id="contact">
    <div class="lvjing">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h2>
                        <span class="glyphicon glyphicon-send"></span>
                        &nbsp;
                        联系我们
                    </h2>
                    <p>在人生中，重要的事情不是胜利，而是奋争。对人生来说必不可缺的东西，不是取胜，而是曾经无悔地战斗过。</p>
                    <address>
                        <p>
                            <span class="glyphicon glyphicon-home"></span>
                            &nbsp;
                            地址:安徽建筑大学实验综合楼708号
                        </p>
                        <P>
                            <span class="glyphicon glyphicon-phone-alt"></span>
                            &nbsp;
                            联系电话：xxxxx
                        </P>
                        <p>
                            <span class="glyphicon glyphicon-envelope"></span>
                            &nbsp;
                            邮箱：xxxx@xxx
                        </p>
                    </address>
                </div>
                <div class="col-md-6">
                    <form action="#" method="post">
                        <div class="col-md-6">
                            <input type="text" class="form-control" placeholder="您的姓名">
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" placeholder="您的邮箱">
                        </div>
                        <div class="col-md-12">
                            <input type="texts" class="form-control" placeholder="标题">
                        </div>
                        <div class="col-md-6">
                            <textarea class="form-control" placeholder="留言内容" rows="4"></textarea>
                        </div>
                        <div class="col-md-8">
                            <input type="submit" class="form-control" value="提交">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--footer-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>
                    追求得到之日即其终止之时，寻觅的过程亦即失去的过程。
                </p>
            </div>
        </div>
    </div>
</footer>


<!--footer-->

<script src="static/js/jquery-3.3.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
