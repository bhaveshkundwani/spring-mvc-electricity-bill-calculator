<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Electricity Bill Details</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }

        .container {
            width: 450px;
            margin: 50px auto;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.15);
        }

        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .label {
            font-weight: bold;
        }

        .amount {
            font-size: 20px;
            font-weight: bold;
        }

        .error {
            text-align: center;
            font-weight: bold;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Electricity Bill Details</h2>

    <% if (request.getAttribute("error") != null) { %>

        <p class="error">
            ${error}
        </p>

    <% } else { %>

        <table>

            <tr>
                <td class="label">Person Name</td>
                <td>${person.name}</td>
            </tr>

            <tr>
                <td class="label">Service Number</td>
                <td>${person.serviceNumber}</td>
            </tr>

            <tr>
                <td class="label">Consumed Units</td>
                <td>${person.consumedUnits}</td>
            </tr>

            <tr>
                <td class="label">Gender</td>
                <td>${person.gender}</td>
            </tr>

            <tr>
                <td class="label">Electricity Charges</td>
                <td class="amount">
                    ₹ ${electricitycharges}
                </td>
            </tr>

        </table>

    <% } %>

    <br>

    <div style="text-align:center;">

        <a href="${pageContext.request.contextPath}/personsearchform">
            Search Another Consumer
        </a>

    </div>

</div>

</body>

</html>