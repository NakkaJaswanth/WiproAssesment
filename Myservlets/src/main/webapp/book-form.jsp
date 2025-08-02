<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Books Management</h2>
<a href="new">Add New Book</a> | <a href="list">List All Books</a>



<form action="${empty book ? 'insert' : 'update'}" method="post">
    <table>
        <tr>
            <td><b>Title:</b></td>
            <td><input type="text" name="title" value="${book.title}" required></td>
        </tr>
        <tr>
            <td><b>Author:</b></td>
            <td><input type="text" name="author" value="${book.author}" required></td>
        </tr>
        <tr>
            <td><b>Price:</b></td>
            <td><input type="number" step="0.01" name="price" value="${book.price}" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form>
</body>
</html>