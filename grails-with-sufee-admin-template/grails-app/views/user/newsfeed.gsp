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
                <h6>Categories here</h6>
            </div>
            <div class="col-sm-10">
                <div class="row">
                    <div class="col-sm-12 text-left">
                        <form>
                            <textarea id="content"></textarea>
                        </form>

                        <button type="button" style="width: 100%;" class="btn btn-primary">Submit</button>
                    </div>
                </div>
                <hr class="news-divider">

                <div class="row">
                    <div class="col-sm-12">
                        <!-- Box Comment -->
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block">
                                    <img class="img-circle" src="${resource(dir: 'images', file: user?.profileImage?:'/default.png')}" alt="User Image">
                                    <span class="username"><a href="#">Jonathan Burke Jr.</a></span>
                                    <span class="description">Shared publicly - 7:30 PM Today</span>
                                </div>
                                <!-- /.user-block -->
                                <div class="box-tools">
                                    <button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="" data-original-title="Mark as read">
                                        <i class="fa fa-circle-o"></i></button>
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                    </button>
                                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                                <!-- /.box-tools -->
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body" style="">
                                <img class="img-responsive pad" src="${resource(dir: 'images', file: user?.profileImage?:'/user1-128x128.jpg')}" alt="Photo">

                                <p>I took this photo this morning. What do you guys think?</p>
                                <button type="button" class="btn btn-default btn-xs"><i class="fa fa-share"></i> Share</button>
                                <button type="button" class="btn btn-default btn-xs"><i class="fa fa-thumbs-o-up"></i> Like</button>
                                <span class="pull-right text-muted">127 likes - 3 comments</span>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer box-comments" style="">
                                <div class="box-comment">
                                    <!-- User image -->
                                    <img class="img-circle img-sm" src="${resource(dir: 'images', file: user?.profileImage?:'/user1-128x128.jpg')}" alt="User Image">

                                    <div class="comment-text">
                                        <span class="username">
                                            Maria Gonzales
                                            <span class="text-muted pull-right">8:03 PM Today</span>
                                        </span><!-- /.username -->
                                    It is a long established fact that a reader will be distracted
                                    by the readable content of a page when looking at its layout.
                                    </div>
                                    <!-- /.comment-text -->
                                </div>
                                <!-- /.box-comment -->
                                <div class="box-comment">
                                    <!-- User image -->
                                    <img class="img-circle img-sm" src="${resource(dir: 'images', file: user?.profileImage?:'/user1-128x128.jpg')}" alt="User Image">

                                    <div class="comment-text">
                                        <span class="username">
                                            Luna Stark
                                            <span class="text-muted pull-right">8:03 PM Today</span>
                                        </span><!-- /.username -->
                                    It is a long established fact that a reader will be distracted
                                    by the readable content of a page when looking at its layout.
                                    </div>
                                    <!-- /.comment-text -->
                                </div>
                                <!-- /.box-comment -->
                            </div>
                            <!-- /.box-footer -->
                            <div class="box-footer" style="">
                                <form action="#" method="post">
                                    <img class="img-responsive img-circle img-sm" src="${resource(dir: 'images', file: user?.profileImage?:'/user1-128x128.jpg')}" alt="Alt Text">
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
                    <!-- /.col -->
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $R('#content', {
        imageUpload: '/your-upload-script/'
    });
</script>
</body>
</html>