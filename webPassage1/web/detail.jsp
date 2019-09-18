<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>${passage.title}</title>
</head>
<div id="container" style="width:1000px">
    <div id="header" style="background-color:#BEBEBE;">
        <h1 style="margin-bottom:0; size: A4">${passage.title}</h1></div>
    <div id="menu" style="background-color:#FFD700;height:800px;width:1000px;float:left;">
        <div id="content" style="background-color:#EEEEEE;height:800px;width:1000px;float:left;">
            ${passage.context}
        </div>
        <div id="footer" style="background-color:#BEBEBE;clear:both;text-align:center;">
            版权 © 安徽建筑大学</div>
    </div>
</div>
</html>
