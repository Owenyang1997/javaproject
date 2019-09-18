
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <link  rel="stylesheet" href="css/main1.css" />
    <link rel="stylesheet" type="text/css" href="css/sinaFaceAndEffec.css" />

    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

    <title>jQuery多说QQ表情留言评论框代码</title>
</head>
<body>
<div id="content" style="width: 700px; height: auto;margin-left:320px;margin-top:40px">
    <div class="wrap">
        <div class="comment">
            <div class="head-face">
                <img src="images/1.jpg" / >
                <p>我是鸟</p>
            </div>
            <div class="content">
                <div class="cont-box">
                    <textarea class="text" placeholder="请输入..."></textarea>
                </div>
                <div class="tools-box">
                    <div class="operator-box-btn"><span class="face-icon"  >☺</span><span class="img-icon">▧</span></div>
                    <div class="submit-btn"><input type="button" onClick="out()"value="提交评论" /></div>
                </div>
            </div>
        </div>
        <div id="info-show">
            <ul></ul>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
<script type="text/javascript">
    // 绑定表情
    $('.face-icon').SinaEmotion($('.text'));
    // 测试本地解析
    function out() {
        var inputText = $('.text').val();
        $('#info-show ul').append(reply(AnalyticEmotion(inputText)));
    }
    var html;
    function reply(content){
        html  = '<li>';
        html += '<div class="head-face">';
        html += '<img src="images/1.jpg" / >';
        html += '</div>';
        html += '<div class="reply-cont">';
        html += '<p class="username">小小红色飞机</p>';
        html += '<p class="comment-body">'+content+'</p>';
        html += '<p class="comment-footer">2016年10月5日　回复　点赞54　转发12</p>';
        html += '</div>';
        html += '</li>';
        return html;
    }
</script>
<div style="text-align:center;">
</div>
</body>
</html>