<%--
  Created by IntelliJ IDEA.
  User: as
  Date: 2020/5/26
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.9.1.js"></script>
    <script>
        $(document).ready(function(){
            $('#post').click(function () {
                $.post("${pageContext.request.contextPath }/user/post.action", {"id": 123, "age": 12, "name": "熊大"}, function(data) {
                    console.log(data);
                }, "json");
                /*$.ajax({
                    type:"POST",
                    url: "${pageContext.request.contextPath }/user/post.action",
                    contentType: "application/json",  //发送信息至服务器时内容编码类型。
                    dataType:"json",  // 预期服务器返回的数据类型。如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断，比如XML MIME类型就被识别为XML。
                    data: JSON.stringify({"id": 123, "age": 12, "name": "熊大"}),
                    success:function(data) {
                        console.log("data= ", data);
                    }
                })*/
            });
        });
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath }/user/get.action">get</a><br/>
<a href="#" id="post">post</a>
</body>
</html>
