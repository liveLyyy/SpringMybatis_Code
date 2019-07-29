<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("a").click(function () {
            $("img").attr("src","validcode?date="+new Date());
            return false;
        })
    })
</script>
<body style="text-align: center;margin: 200px 0px">
${error}
<form action="login" method="post" style="margin: 10px auto;text-align: center;">
    用户名<input type="text" name="username"><br>
    密&nbsp;&nbsp;码<input type="password" name="password"><br>
    验证码<input type="text" size="1" name="code">
    <img src="validcode" style="width: 150px;height: 40px;"><a href="">看不清</a><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
