<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib
    uri="http://www.springframework.org/tags/form"
    prefix="form" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Electricity Bill Calculator</title>

</head>

<body>

    <h1>Electricity Bill Calculator</h1>

    <form:form
        method="post"
        action="${pageContext.request.contextPath}/calculateAmount"
        modelAttribute="person">

        <table>

            <tr>

                <td>Person Name:</td>

                <td>
                    <form:input path="name"/>
                </td>

            </tr>

            <tr>

                <td colspan="2">
                    OR
                </td>

            </tr>

            <tr>

                <td>Service Number:</td>

                <td>
                    <form:input path="serviceNumber"/>
                </td>

            </tr>

            <tr>

                <td></td>

                <td>
                    <input
                        type="submit"
                        value="Calculate Electricity Bill">
                </td>

            </tr>

        </table>

    </form:form>

</body>

</html>