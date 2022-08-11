<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String msg = CmmUtil.nvl(String.valueOf(request.getAttribute("msg")));
    String url = CmmUtil.nvl(String.valueOf(request.getAttribute("url")));
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
    alert("<%=msg%>");
    location.href="<%=url%>";
</script>
</body>
</html>