<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Download Certificates</title>
    <link rel="stylesheet" href="path/to/your/styles.css" />
</head>
<body>
    <h2>Download Certificates</h2>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Event Name</th>
            <th>Download Certificate</th>
        </tr>
        <c:forEach items="${cbean.clist}" var="cv">
            <tr>
                <td>${cv.studentId}</td>
                <td>${cv.studentName}</td>
                <td>${cv.eventName}</td>
                <td>
                    <a href="ImageServlet3?id=${cv.studentId}" download="certificate_${cv.studentId}.jpeg">
                        Download Certificate
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
