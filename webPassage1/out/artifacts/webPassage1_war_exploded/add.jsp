<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no" >
    <title>招新</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/style3.css">
</head>
<body>
<!--导航栏-->
<jsp:include page="/top.jsp"></jsp:include>
<!--导航栏-->
<section class="main">
    <div class="form1">
        <div class="container">
            <div class="row">
                <div class="col-md-6 row1">
                    <div class="sign">我要报名</div>
                    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath }//regist">
                        <div class="form-group">
                            <label for="ID" class="col-sm-2 control-label">学号</label>
                            <div class="col-md-9">
                                <input type="text"  name="id" class="form-control" id="ID" maxlength="18"
                                       placeholder="请输入学号" oninput="value=value.replace(/[^\d]/g,'')">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">姓名</label>
                            <div class="col-md-9">
                                <input type="text"  name="username" class="form-control" id="username" maxlength="10"
                                       placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="zhuanye" class="col-sm-2 control-label">专业</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="zhuanye" maxlength="10"
                                       placeholder="请输入专业" name="major">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="banji" class="col-sm-2 control-label">班级</label>
                            <div class="col-md-9">
                                <input type="text"  name="clazz" class="form-control" id="banji" maxlength="10"
                                       placeholder="请输入班级">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="e-mail" class="col-sm-2 control-label">QQ邮箱</label>
                            <div class="col-md-9">
                                <input type="text" name="qqNum" class="form-control" id="e-mail" maxlength="20"
                                       placeholder="请输入QQ邮箱" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">联系电话</label>
                            <div class="col-md-9">
                                <input type="text" name="phoneNum" class="form-control" id="phone" maxlength="11"
                                       placeholder="请输入手机号" oninput="value=value.replace(/[^\d]/g,'')">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="project" class="col-sm-2 control-label">考试语言</label>
                            <div class="col-md-9">
                                <select class="form-control" id="project" name="type">
                                    <option value="c">C语言</option>
                                    <option value="java">Java</option>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>

                <div class="col-md-6 row2">
                    <div class="sign">成绩查询</div>
                    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/selectUser">
                        <div class="form-group">
                            <label for="studentID" class="col-sm-2 control-label">姓名</label>
                            <div class="col-md-9">
                                <input type="text"  name="username" class="form-control" id="studentID" maxlength="15"
                                       placeholder="请输入姓名"  >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="IDnumber" class="col-sm-2 control-label">学号</label>
                            <div class="col-md-9">
                                <input type="text"  name="id" class="form-control" id="IDnumber" maxlength="18"
                                       placeholder="请输入学号" oninput="value=value.replace(/[^\d]/g,'')">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">查询</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<!--脚注-->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12" data-animation="zoomIn" data-animation-delay="01">
                <h6><a href="#">软件工程创新实验室</a></h6>
                <p>版权所有 &copy; 安徽建筑大学软件工程创新实验室</p>
            </div>
        </div>
    </div>
</footer>
<!--脚注-->

<script src="static/js/jquery-3.3.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
