<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student Enrollment Form</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
    <h2>Enrollment Form</h2>

    <form:form method="post" modelAttribute="formBean">
        <table>
            <tr>
                <td>First Name</td>
                <td><form:input path="firstName" /></td>
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Last Name</td>
                <td><form:input path="lastName" /></td>
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Sex</td>
                <td>
                    <form:radiobutton path="sex" value="Male" /> Male
                    <form:radiobutton path="sex" value="Female" /> Female
                </td>
                <td><form:errors path="sex" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Date of Birth</td>
                <td><form:input path="dob" type="date" /></td>
                <td><form:errors path="dob" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Section</td>
                <td>
                    <form:radiobutton path="section" value="Graduate" /> Graduate
                    <form:radiobutton path="section" value="Post Graduate" /> Post Graduate
                    <form:radiobutton path="section" value="Research" /> Research
                </td>
                <td><form:errors path="section" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Country</td>
                <td>
                    <form:select path="country" items="${countries}" />
                </td>
                <td><form:errors path="country" cssClass="error" /></td>
            </tr>

            <tr>
                <td>First Attempt?</td>
                <td><form:checkbox path="firstAttempt" /></td>
            </tr>

            <tr>
                <td>Subjects</td>
                <td>
                    <form:select path="subjects" items="${subjects}" multiple="true" />
                </td>
                <td><form:errors path="subjects" cssClass="error" /></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Register" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
