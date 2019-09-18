// 封装一个通过id获取dom元素的函数
function byId(id) {
    return typeof(id) === "string"?document.getElementById(id):id;
}
var timer=null,
    index=0,//索引
    pics=byId("banner").getElementsByTagName("div"),
    dots=byId("dots").getElementsByTagName("span"),
    len=pics.length;

function stopAutoPlay() {
    if(timer){
        clearInterval(timer);
    }
}

function startAutoPlay(){
    timer=setInterval(function () {
        index++;
        if(index>=len) index=0;
        changeImg();
    },5000)
}

function changeImg() {
    for(var i=0;i<len;i++){
        pics[i].style.display="none";
        dots[i].className="";
    }
    pics[index].style.display="block";
    dots[index].className="active";
}

function slideImg() {
    var myCarousel = byId("myCarousel");
    myCarousel.onmouseover = function () {
        stopAutoPlay();
    }
    myCarousel.onmouseout = function () {
        startAutoPlay();
    }
    myCarousel.onmouseout();//自动触发鼠标离开事件

    //点击圆点切换图片
    for (var j = 0; j < dots.length; j++) {
        dots[j].id = j;
        dots[j].onclick = function () {
            index = this.id;
            changeImg();
        }
    }

    //点击上一张
    var prev = byId("prev");
    prev.onclick = function () {
        index--;
        if (index < 0) index = len - 1;
        changeImg();
    }
    //点击下一张
    var next = byId("next");
    next.onclick = function () {
        index++;
        if (index >= len) index = 0;
        changeImg();
    }
}
slideImg();

//使用showContent方法把content显示在id是target的元素中。
// function showContent(content,target){
//     document.getElementById(target).innerHTML=content;
// }