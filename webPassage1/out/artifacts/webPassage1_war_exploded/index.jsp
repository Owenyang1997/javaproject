<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no" >
  <title>软件工程创新实验室</title>
  <link rel="stylesheet" href="static/css/bootstrap.min.css">
  <link rel="stylesheet" href="static/css/rjgc.css">
</head>
<body>
<!--导航栏-->
<jsp:include page="/top.jsp"></jsp:include>
<!--导航栏-->
<!--轮播-->
<jsp:include page="/lunbo.jsp"></jsp:include>
<!--轮播-->

<!--内容-->
<section id="main" class="main">
  <!--网格-->
  <div class="container content">
    <div class="row">
      <!--分三组 左侧栏-->
      <div class="col-lg-4 left">
        <span><img src="static/imgs/madel3.png" width="40px" height="40px" alt="/"></span>
        <h3>获奖情况</h3>
        <hr/>
        <!--左侧栏和中间栏分为up、down两部分，分别存放图片和文字-->
        <div class="up pic medal"></div><!--存放获奖情况图片-->

        <!--文字介绍获奖情况-->
        <div class="down word">
          <p style="text-align:left;" margin:0 auto;>
            <c:forEach var="award" items="${pageAward.list}">
                <a href="${pageContext.request.contextPath }/detail?cid=${award.cid}">${award.title}<br/></a>
            </c:forEach>
          </p>
          <!--分页-->
          <ul class="pagination">
            <c:if test="${pageAward.currentPage==1 }">
              <li class="disabled">
                <a href="javascript:void(0);" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
            </c:if>
            <c:if test="${pageAward.currentPage!=1 }">
              <li>
                <a href="${pageContext.request.contextPath }/getpassage?currentPage=${pageAward.currentPage-1}" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
            </c:if>
            <c:forEach begin="1" end="${pageAward.totalPage }" var="page">
              <!-- 判断当前页 -->
              <c:if test="${pageAward.currentPage==page }">
                <li class="active"><a href="javascript:void(0);">${page}</a></li>
              </c:if>
              <c:if test="${pageAward.currentPage!=page }">
                <li><a href="${pageContext.request.contextPath }/getpassage?currentPage=${page}">${page}</a></li>
              </c:if>
            </c:forEach>
            <!-- 判断当前页是否是最后一页 -->
            <c:if test="${pageAward.currentPage==pageAward.totalPage }">
              <li class="disabled">
                <a href="javascript:void(0);" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </c:if>
            <c:if test="${pageAward.currentPage!=pageAward.totalPage }">
              <li>
                <a href="${pageContext.request.contextPath }/getpassage?currentPage=${pageAward.currentPage+1}" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </c:if>
          </ul>
          <!--分页-->
        </div>
        <!--文字介绍获奖情况-->
      </div>
      <!--左侧栏-->
      <!--中间栏-->
      <div class="col-lg-4 middle">
        <span><img src="static/imgs/schedule4.png" width="40px" height="40px" alt="/"></span>
        <h3>近期任务</h3>
        <hr/>
        <!--近期任务文字-->
        <div class="up word">
          <h4><span class="glyphicon glyphicon-phone"></span>安卓组</h4>
          <p style="text-align:left;" margin:0 auto;>
           <c:forEach items="${work1}" var="work1">
             ${work1.context}<br/>
           </c:forEach>
          </p>
          <hr/>
          <h4><span class="glyphicon glyphicon-folder-open"></span> Web组</h4>
          <p style="text-align:left;" margin:0 auto;>
            <c:forEach items="${work2}" var="work2">
              ${work2.context}<br/>
            </c:forEach>
          </p>
          <hr/>
          <h4><span class="glyphicon glyphicon-paperclip"></span> 游戏组</h4>
          <p style="text-align:left;" margin:0 auto;>
            <c:forEach items="${work3}" var="work3">
              ${work3.context}<br/>
            </c:forEach>
          </p>
        </div>
        <!--近期任务文字-->
        <div class="down pic schedule"></div><!--存放图片-->
      </div>
      <!--中间栏-->
      <!--右侧栏-->
      <div class="col-lg-4 right">
        <span><img src="static/imgs/notice.png" width="40px" height="40px" alt="/"></span>
        <h3>公告通知</h3>
        <hr/>
        <!--日历样式列出公告通知-->
        <div id="wp_news">
          <ul class="news_list zdy-tj clearfix">
            <c:forEach items="${passageMessage}" var="message">
            <li class="news n1 clearfix">
              <div class="sj">
                <div class="date-day"> ${message.day} </div>
                <div class="date-month">${message.mouth}</div>
              </div>
              <div class="zdy-1">
                <div class="bt"> <a href="${pageContext.request.contextPath }/detail?cid=${message.passage.cid}" target="_blank" title="${message.passage.title}">${message.passage.title}</a> </div>
              </div>
            </li>
            </c:forEach>
          </ul>
        </div><!--wp-news-->
        <!--日历样式列出公告通知-->
      </div>
      <!--右侧栏-->
    </div> <!--row-->
  </div> <!--container-->
  <!--网格-->
</section>
<!--内容-->

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
<script src="static/js/myScript.js"></script>
</body>
</html>
