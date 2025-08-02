<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User Information</h2>

<form action="user" method="post">
    User Name: <input type="text" name="username" value="${user.username}" /><br/><br/>
    Password: <input type="password" name="password" /><br/><br/>
    Address: <textarea name="address">${user.address}</textarea><br/><br/>
    
    Subscribe Newsletter:
    <input type="checkbox" name="newsletter" ${user.newsletter ? 'checked' : ''} /><br/><br/>

    Favorite Web Frameworks:<br/>
    items="${frameworks}">
        <input type="checkbox" name="favoriteFrameworks" value="${framework}"/> ${framework}<br/>
    
    <br/>

    Gender:
    <input type="radio" name="gender" value="Male" /> Male
    <input type="radio" name="gender" value="Female" /> Female<br/><br/>

    Favorite Number:
    <input type="radio" name="favoriteNumber" value="1" />1
    <input type="radio" name="favoriteNumber" value="2" />2
    <input type="radio" name="favoriteNumber" value="3" />3
    <input type="radio" name="favoriteNumber" value="4" />4<br/><br/>

    <input type="submit" value="Submit" />
</form>
</body>
</html>