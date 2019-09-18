<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no" >
    <title>师资队伍</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
<!--导航栏-->
<jsp:include page="/top.jsp"></jsp:include>
<!--导航栏-->
<!--图片-->
<div class="home"></div>
<!--图片-->
<!--列表组-->
<div class="main">
    <div class="container">
        <div class="row">
            <h1>师资概况</h1>
            <hr>
            <p>
                <br/>
                安徽建筑大学软件工程创新实验室位于学校实验室综合楼708室，由章曙光、钟娟、
                王立新、程远、吴一尘等老师负责并参与指导。实验室每年吸收数十名优秀新生
                来实验室学习和完成各类软件设计。
                <br/>　　
            </p>
            <br/><br/>
        </div>
        <div class="row">
            <h1>个人介绍</h1>
            <hr>
            <c:forEach items="${peopleList}" var="p">
            <div class="panel panel-default">
                <div class="panel-body">
                    <!-- 人物左1 -->
                    <div class="media">
                        <div class="media-left media-middle">
                            <img src="${p.img}" class="media-object" style="width:100px">
                        </div>
                        <div class="media-body">
                            <h2 class="media-heading">${p.name}</h2>
                            <p>${p.express}</p>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
<!--脚注-->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div>
                <h3><a>软件工程创新实验室</a></h3>
                <p>版权所有 &copy; 安徽建筑大学软件工程创新实验室</p>
            </div>
        </div>
    </div>
</footer>
<!--脚注-->
<!--列表组-->
<script src="static/js/jquery-3.3.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
