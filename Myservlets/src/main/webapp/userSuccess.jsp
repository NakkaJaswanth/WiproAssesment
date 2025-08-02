<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Submitted User Info</h2>
<p>User Name: ${submittedUser.username}</p>
<p>Address: ${submittedUser.address}</p>
<p>Gender: ${submittedUser.gender}</p>
<p>Favorite Number: ${submittedUser.favoriteNumber}</p>
<p>Subscribed: ${submittedUser.newsletter}</p>

<p>Favorite Frameworks:</p>
<ul>
    <c:forEach var="f" items="${submittedUser.favoriteFrameworks}">
        <li>${f}</li>
    </c:forEach>
</ul>
</body>
</html>