<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.html">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath }/getPassageList"><i class="icon-font">&#xe008;</i>信息管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/getPeopleList?typeId=1"><i class="icon-font">&#xe005;</i>成员管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/list"><i class="icon-font">&#xe006;</i>分类管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

</html>
