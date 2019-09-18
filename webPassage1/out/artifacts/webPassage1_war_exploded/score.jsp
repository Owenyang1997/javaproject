<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no" >
    <title>成绩查询</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/score.css">
</head>
<body>
<div class="all">
    <div class="main">
        <div class="title">
            <h2>软件工程创新实验室招新成绩查询</h2>
        </div>
        <div class="container">
            <table class="table" align="center">
                <thead>
                <tr>
                    <th colspan="2" align="center">成绩单</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>考生姓名&#58;</td>
                    <td>${user.username}</td>
                </tr>
                <tr>
                    <td>专业班级&#58;</td>
                    <td>${user.major}${user.clazz}</td>
                </tr>
                <tr>
                    <td>考生学号&#58;</td>
                    <td>${user.id}</td>
                </tr>
                <tr>
                    <td>考试科目&#58;</td>
                    <td>${user.type}</td>
                </tr>
                <tr>
                    <td>笔试成绩&#58;</td>
                    <td>${user.grade}分</td>
                </tr>
                <tr>
                    <td>面试成绩&#58;</td>
                    <c:if test="${user.state!=0}">
                    <td>恭喜,通过</td>
                    </c:if>
                    <c:if test="${user.state==0}">
                        <td>抱歉,未通过</td>
                    </c:if>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="end">
            <div class="continue">
                <button type="button" class="btn" onclick="javascript:window.location.href='${pageContext.request.contextPath}/add.jsp'">继&nbsp;续&nbsp;查&nbsp;询</button><br/>
            </div>
            <div class="return">
                <button type="button" class="btn" onclick="javascript:window.location.href='${pageContext.request.contextPath}/getpassage'">返&nbsp;回&nbsp;首&nbsp;页</button>
            </div>
        </div>
    </div>
</div>
<script src="static/js/jquery-3.3.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>