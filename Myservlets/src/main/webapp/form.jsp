<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Enter Student Details</h2>
    <form action="marksHandler.jsp" method="post">
        Name: <input type="text" name="name" required /><br/><br/>
        Marks: <input type="number" name="marks" required /><br/><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>