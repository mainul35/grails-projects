<%--
  Created by IntelliJ IDEA.
  User: Syed Mainul Hasan
  Date: 17/08/2019
  Time: 12:31
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="user"/>
</head>

<body>
<div class="text-center">
    <div class="col-sm-10">
        <div class="row">
            <div class="col-sm-2">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Categories</h3>
                    </div>
                    <div class="box-body">
                        <g:each var="item" in="${categoryItems}">
                            <button type="button" class="btn btn-default btn-block btn-sm pick-a-category-item" data-id="${item.id}">${item.categoryName}</button>
                        </g:each>
                    </div>
                </div>
            </div>
            <div class="col-sm-10">
                <div class="row">
                    <div class="col-sm-12 text-left form-control">
                        <textarea id="content"></textarea>
                    </div>
                    <div class="col-sm-12 form-control">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <g:select
                                            id="category"
                                            data-placeholder="Select category..."
                                            class="standardSelect"
                                            name="category"
                                            from="${categoryItems}"
                                            optionKey="id"
                                            value="" optionValue="${{ it.categoryName }}"
                                            noSelection="${['null': '']}">
                                    </g:select>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <button type="button" style="width: 100%;" class="btn btn-block btn-sm btn-primary submit-news">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="news-divider">

                <div class="row">
                    <g:each var="news" in="${newsList}">
                        <div class="col-sm-12">
                            <!-- Box Comment -->
                            <div class="box text-left box-widget">
                                <div class="box-header with-border">
                                    <div class="user-block">
                                        <img class="img-responsive pad" src="${news.postedBy.profileImage ? news.postedBy.profileImage : '/assets/user1-128x128.jpg'}" alt="Photo">
                                        <span class="username"><a href="">${news.postedBy.firstName + ' '+ news.postedBy.lastName}</a></span>
                                        <span class="description">${news.publishingTime.toGMTString()}</span>
                                    </div>
                                    <!-- /.user-block -->

                                    <!-- /.box-tools -->
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body" style="">

                                    <p>${news.description}</p>
                                </div>
                                <!-- /.box-body -->

                                <!-- /.box-footer -->
                                <div class="box-footer" style="">
                                    <form action="#" method="post">
                                        <img class="img-responsive img-circle img-sm" src="/assets/user1-128x128.jpg" alt="Alt Text">
                                        <!-- .img-push is used to add margin to elements next to floating images -->
                                        <div class="img-push">
                                            <input type="text" class="form-control input-sm" placeholder="Press enter to post comment">
                                        </div>
                                    </form>
                                </div>
                                <!-- /.box-footer -->
                            </div>
                            <!-- /.box -->
                        </div>
                    </g:each>

                    <!-- /.col -->
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/lib/chosen/chosen.jquery.min.js"></script>
<script>
    $R('#content', {
        imageUpload: '/your-upload-script/'
    });
    jQuery(document).ready(function ($) {
        $(".standardSelect").chosen({
            disable_search_threshold: 10,
            no_results_text: "Oops, nothing found!",
            width: "100%"
        });
    });
</script>
<script type="text/javascript" src="/assets/js/newsfeed.js"></script>
</body>
</html>