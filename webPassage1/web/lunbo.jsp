<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div id="myCarousel" class="myCarousel">
    <!--banner存放图片-->
    <div class="banner" id="banner">
        <a href="">
            <div class="banner-slide slide1 slide-active"></div>
        </a>
        <a href="">
            <div class="banner-slide slide2"></div>
        </a>
        <a href="">
            <div class="banner-slide slide3"></div>
        </a>
    </div>

    <!--上一张、下一张-->
    <a href="javascript:void(0)" class="button prev" id="prev"></a>
    <a href="javascript:void(0)" class="button next" id="next"></a>

    <!--三个圆点-->
    <div class="dots" id="dots">
        <span class="active"></span>
        <span></span>
        <span></span>
    </div>
</div>
</html>
