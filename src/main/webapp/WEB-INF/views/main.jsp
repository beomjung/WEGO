<%@ page import="kopo.poly.vo.ApiAreaBasedDto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    List<ApiAreaBasedDto> result = (List<ApiAreaBasedDto>) request.getAttribute("areaBaseDtoList");
%>

<!doctype html>
<html lang="ko">
<head>
    <title>Main Page</title>
</head>
<body>
<h1>Main Page</h1>

<%
    for (ApiAreaBasedDto data : result) {
%>
<p><%=data.getTitle()%></p>
<%
    }
%>


</body>
</html>