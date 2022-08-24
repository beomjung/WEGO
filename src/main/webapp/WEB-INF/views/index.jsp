<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ko">
<head>
    <title>index</title>
</head>
<body>
<form action="/users/login" method="post" datatype="application/json">
    <input type="text" name="userId">
    <input type="password" name="userPassword">
    <input type="submit">
</form>

</body>
</html>