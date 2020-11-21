﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>人员信息系统</title>
    <link href="style/authority/login_css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#login_sub").click(function () {
                $("#submitForm").attr("action", "login.action").submit();
            });
        });

        /*回车事件*/
        function EnterPress(e) { //传入 event
            var e = e || window.event;
            if (e.keyCode == 13) {
                $("#submitForm").attr("action", "login.action").submit();
            }
        }
    </script>
</head>
<body>
<div id="login_center">
    <div id="login_area">
        <div id="login_box">
            <div id="login_form">
                <form id="submitForm" action="login.action" method="post">
                    <div id="login_tip">
                        <span id="login_err" class="sty_txt2"></span>
                    </div>
                    <div>
                        用户名：<input type="text" name="username" class="username" id="name">
                    </div>
                    <div>
                        密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" class="pwd"
                                                          id="pwd" onkeypress="EnterPress(event)"
                                                          onkeydown="EnterPress()">
                    </div>
                    <div id="btn_area">
                        <input type="button" class="login_btn" id="login_sub" value="登  录">
                        <input type="reset" class="login_btn" id="login_ret" value="重 置">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>