<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <!--小屏幕导航按钮和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.html" class="navbar-brand">软件工程创新实验室</a>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/getpassage">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/overview.jsp">概况</a></li>
                <li><a href="${pageContext.request.contextPath}/getpeople?state=1">师资队伍</a></li>
                <li><a href="${pageContext.request.contextPath}/getpeotype">学生风采</a></li>
                <li class="dropdown menu1">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="index.html">
                        作品展示<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">安卓组</a></li>
                        <li><a href="#">Web组</a></li>
                        <li><a href="#">游戏组</a></li>
                        <li><a href="#">算法组</a></li>
                        <li><a href="#">无线传感器</a></li>
                    </ul>
                </li>
                <li class="menu1"><a href="${pageContext.request.contextPath}/add.jsp"><span class="glyphicon glyphicon-user"></span> 招新</a></li>
            </ul>
        </div>
        <!--导航-->
    </div>
</nav>
</html>
