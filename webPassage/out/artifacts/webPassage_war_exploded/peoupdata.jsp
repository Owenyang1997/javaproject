<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="${pageContext.request.contextPath}/updatePeople?id=${passage.id}" method="post" id="myform" name="myform" >
                <table class="insert-tab" width="100%">
                    <tbody><tr>
                        <jsp:include page="peofen.jsp"></jsp:include>
                    </tr>
                    <tr>
                        <th>姓名：</th>
                        <td><input class="common-text" name="name" size="50" value="${passage.name}" type="text"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>图片：</th>
                        <td><input name="img" id="" type="file" value="${passage.img}"><!--<input type="submit" onclick="submitForm('/jscss/admin/design/upload')" value="上传图片"/>--></td>
                    </tr>
                    <tr>
                        <th>内容：</th>
                        <td><textarea name="express" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10">${passage.express}</textarea></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
