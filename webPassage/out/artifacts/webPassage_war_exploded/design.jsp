<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<script type="text/javascript">
    function delPassage(pid){
        var isDel = confirm("您确认要删除吗？");
        if(isDel){
            //要删除
            location.href = "${pageContext.request.contextPath}/delPassage?cid="+pid;
        }
    }
</script>
<body>
   <jsp:include page="/head.jsp"></jsp:include>
    <!--/sidebar-->
   <jsp:include page="/sidebar.jsp"></jsp:include>
        <div class="result-wrap">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.jsp"><i class="icon-font"></i>新增作品</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>标题</th>
                            <th>审核状态</th>
                            <th>发布人</th>
                            <th>更新时间</th>
                            <th>评论</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${passageList.list}" var="passages">
                            <tr>
                                <td class="tc"><input name="id[]" value="${passages.id}" type="checkbox"></td>
                                <td>
                                    <input name="ids[]" value="${passages.id}" type="hidden">
                                    <input class="common-input sort-input" name="ord[]" value="${passages.id}" type="text">
                                </td>
                                <td>${passages.title}</td>
                                <td title="${passages.title}"><a target="_blank" href="#" title="${passages.title}">${passages.state}</a> …
                                </td>
                                <td>${passages.authour}</td><%--state--%>
                                <td>${passages.data}</td><%--authour--%>
                                <td>${passages.pinglun}</td><%--data--%>
                                <td>
                                    <a class="link-update" href="${ pageContext.request.contextPath }/beforeInsert?cid=${passages.cid}">修改</a><%--先查询passage
                                     然后将数据返回到eidt.jsp//改好的数据更新到数据库  然后再返回到design.jsp--%>
                                    <a class="link-del" onclick="delPassage('${passages.cid}')">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div style="width: 380px; margin: 0 auto; margin-top: 10px;">
                        <ul class="pagination" style="text-align: center; margin-top: 5px;">
                            <!-- 上一页 -->
                            <!-- 判断当前页是否是第一页 -->
                            <c:if test="${passageList.currentPage==1}">
                                <li class="disabled">
                                    <a href="javascript:void(0);" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${passageList.currentPage!=1 }">
                                <li>
                                    <a href="${pageContext.request.contextPath }/getPassageList?currentPage=${passageList.currentPage-1}&type=${passageList.list[0].type}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${passageList.totalPage }" var="page">
                                <!-- 判断当前页 -->
                                <c:if test="${passageList.currentPage==page }">
                                    <li class="active"><a href="javascript:void(0);">${page}</a></li>
                                </c:if>
                                <c:if test="${passageList.currentPage!=page }">
                                    <li><a href="${pageContext.request.contextPath }/getPassageList?currentPage=${page}&type=${passageList.list[0].type}">${page}</a></li>
                                </c:if>
                            </c:forEach>
                            <!-- 判断当前页是否是最后一页 -->
                            <c:if test="${passageList.currentPage==passageList.totalPage }">
                                <li class="disabled">
                                    <a href="javascript:void(0);" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${passageList.currentPage!=passageList.totalPage }">
                                <li>
                                    <a href="${pageContext.request.contextPath }/getPassageList?currentPage=${passageList.currentPage+1}&type=${passageList.list[0].type}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
