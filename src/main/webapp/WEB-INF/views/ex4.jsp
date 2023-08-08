<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ex4</title>
</head>
<body>

<h1> ${ message } </h1>
<br>

<h4><c:out value="${message}" /></h4>
<h5>${ sentence }</h5>



</body>
</html>