<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Congratulations, ${studentName}!</h2>
    <p>You passed with ${studentMarks} marks.</p>

    <jsp:include page="footer.jsp" />
</body>
</html>