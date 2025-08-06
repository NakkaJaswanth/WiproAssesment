<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h2>Spring MVC Form Demo - Registration</h2>
    <form action="/register" method="post">
        User Name: <input type="text" name="username" /><br/><br/>
        Password: <input type="password" name="password" /><br/><br/>
        E-mail: <input type="text" name="email" /><br/><br/>
        Birthday (mm/dd/yyyy): <input type="text" name="birthday" /><br/><br/>
        Profession:
        <select name="profession">
            <option value="Developer">Developer</option>
            <option value="Tester">Tester</option>
            <option value="Manager">Manager</option>
        </select><br/><br/>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
