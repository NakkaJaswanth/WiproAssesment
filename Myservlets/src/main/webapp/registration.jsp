<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2 style="text-align:center;">User Registration</h2>

    <form action="RegistrationServlet" method="post" style="width: 400px; margin: auto;">
        <table>
            <tr>
                <td>Full name:</td>
                <td><input type="text" name="fullname" required></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Birthday (yyyy-mm-dd):</td>
                <td><input type="date" name="birthday"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male"> Male
                    <input type="radio" name="gender" value="Female"> Female
                </td>
            </tr>
            <tr>
                <td>Profession:</td>
                <td>
                    <select name="profession">
                        <option value="Developer">Developer</option>
                        <option value="Designer">Designer</option>
                        <option value="Manager">Manager</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Married?</td>
                <td><input type="checkbox" name="married" value="Yes"></td>
            </tr>
            <tr>
                <td>Note:</td>
                <td><textarea name="note" rows="4" cols="30"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>