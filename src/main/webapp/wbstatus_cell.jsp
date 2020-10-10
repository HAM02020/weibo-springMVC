<%--
  Created by IntelliJ IDEA.
  User: mofansheng
  Date: 2020/7/3
  Time: 4:46 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--单条微博视图原型--%>
<div class="col-md-6 col-xl-4 mb-3 mb-md-4">
    <div class="card mb-3 mb-md-4">
        <div class="card-header d-flex align-items-center">
            <div class="face"><img width="50" height="50" src="https://tvax4.sinaimg.cn/crop.0.0.320.320.1024/4a4673aaly1fgyaoekvoij208w08wmxc.jpg?KID=imgbed,tva&amp;Expires=1593776627&amp;ssig=v8ff09SP16" class="avatar-lg rounded-circle"></div>
            <div class="position-relative ml-3 ml-md-4">
                <h5 class="font-weight-semi-bold mb-0">天使天使呀</h5>
                <a class="font-weight-light mb-0">今天15:01</a>
                <a class="font-weight-light ml-3">来自weibo.com</a>

            </div>


            <a class="unfold-invoker d-flex ml-auto" style="visibility: hidden" href="#">
                <i class="gd-calendar"></i>
            </a>

            <div class="position-relative ml-3 ml-md-4">
                <a id="dropDown6Invoker" class="unfold-invoker d-flex" href="#" aria-controls="dropDown6" aria-haspopup="true" aria-expanded="false" data-unfold-target="#dropDown6" data-unfold-event="click" data-unfold-type="css-animation" data-unfold-duration="300" data-unfold-animation-in="fadeIn" data-unfold-animation-out="fadeOut">
                    <i class="gd-angle-down"></i>
                </a>

                <ul id="dropDown6" class="unfold unfold-light unfold-top unfold-right position-absolute py-3 mt-3 unfold-css-animation unfold-hidden fadeOut" aria-labelledby="dropDown6Invoker" style="min-width: 150px; animation-duration: 300ms;">
                    <li class="unfold-item">
                        <a class="unfold-link media align-items-center text-nowrap" href="#">
                            <i class="gd-plus unfold-item-icon mr-3"></i>
                            <span class="media-body">Add</span>
                        </a>
                    </li>
                    <li class="unfold-item">
                        <a class="unfold-link media align-items-center text-nowrap" href="#">
                            <i class="gd-pencil unfold-item-icon mr-3"></i>
                            <span class="media-body">Edit</span>
                        </a>
                    </li>
                    <li class="unfold-item">
                        <a class="unfold-link media align-items-center text-nowrap" href="#">
                            <i class="gd-shortcode unfold-item-icon mr-3"></i>
                            <span class="media-body">Rename</span>
                        </a>
                    </li>
                    <li class="unfold-item">
                        <a class="unfold-link media align-items-center text-nowrap" href="#">
                            <i class="gd-close unfold-item-icon mr-3"></i>
                            <span class="media-body">Delete</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="card-body">

            <p id="wb_text" class="m-1">A Google Docs scam that appears to be widespread began landing in users’ inboxes on Wednesday in what seemed to be a sophisticated phishing or malware attack. The deceptive invitation to edit a Google Doc – the popular app used for writing and sharing files – appeared to be spreading rapidly, with a subject line stating a contact has shared a document.</p>

            <div class="container-flex2" style="display: none">
                <div class="block">
                    <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                </div>
                <div class="block">
                    <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                </div>
                <div class="block">
                    <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                </div>
                <div class="block">
                    <img src="http://wx2.sinaimg.cn/thumb150/6c3e6b13gy1ggdzypz96pj20u011cq6h.jpg" width="100%" height="100%">
                </div>
                <div class="block">
                    <img src="https://wx1.sinaimg.cn/thumb150/4a4673aagy1ggdpvkw1vsj20sg16o786.jpg" width="100%" height="100%">
                </div>
                <div class="block">
                    <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                </div>
                <div class="block">
                    <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                </div>
            </div>

            <div class="m-0" style="background-color: #f2f2f2">
                <i id="wb_retweeted_name" class="m-1">@国庆各个：</i>
                <a id="wb_retweeted_text" class="m-1">ashdfuioagsduiofgaiuosdgfioasgiodufgaiuosdgffhdauiosgduifagsidfgiasdg</a>
                <div class="container-flex2">
                    <div class="block">
                        <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                    </div>
                    <div class="block">
                        <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                    </div>
                    <div class="block">
                        <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                    </div>
                    <div class="block">
                        <img src="http://wx2.sinaimg.cn/thumb150/6c3e6b13gy1ggdzypz96pj20u011cq6h.jpg" width="100%" height="100%">
                    </div>
                    <div class="block">
                        <img src="https://wx1.sinaimg.cn/thumb150/4a4673aagy1ggdpvkw1vsj20sg16o786.jpg" width="100%" height="100%">
                    </div>
                    <div class="block">
                        <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                    </div>
                    <div class="block">
                        <img src="https://wx3.sinaimg.cn/thumb150/4a4673aagy1ggdpvl3542j20sg16otd4.jpg" width="100%" height="100%">
                    </div>
                </div>
            </div>
        </div>
        <footer class="card-footer border-top d-flex">
            <div class="d-flex align-items-center">
                <button style="background-color:rgba(0,0,0,0); border: 0px">
                    <i class="gd-heart icon-text mr-2"></i>
                    <a style="white-space:nowrap;">点赞</a>
                </button>

            </div>

            <div class="d-flex align-items-center ml-3 ml-md-4">
                <button style="background-color:rgba(0,0,0,0); border: 0px">
                    <i class="gd-comment icon-text mr-2"></i>
                    <a style="white-space:nowrap;">评论</a>
                </button>
            </div>

            <div class="d-flex align-items-center ml-3 ml-md-4">
                <button style="background-color:rgba(0,0,0,0); border: 0px">
                    <i class="gd-share icon-text mr-2"></i>
                    <a style="white-space:nowrap;">转发</a>
                </button>
            </div>
        </footer>
    </div>
</div>