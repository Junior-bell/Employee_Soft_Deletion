<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Report</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <!-- JavaScript function for delete confirmation -->
    <script type="text/javascript">
        function confirmDelete(empId) {
            var result = confirm("Are you sure you want to delete this employee?");
            if (result) {
                window.location.href = "${pageContext.request.contextPath}/emp_delete?no=" + empId;
            }
        }
    </script>
</head>
<body class="employee-report-container">
    <h1>Employee Report</h1>
    <c:choose>
        <c:when test="${not empty empList}">
            <table class="employee-table">
                <tr>
                    <th>Employee No</th>
                    <th>Name</th>
                    <th>Job</th>
                    <th>Salary</th>
                    <th>Department No</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="emp" items="${empList}">
                    <tr>
                        <td>${emp.empno}</td>
                        <td>${emp.ename}</td>
                        <td>${emp.job}</td>
                        <td>${emp.sal}</td>
                        <td>${emp.deptno}</td>
                        <td>
                            <!-- Edit Button -->
                            <a href="${pageContext.request.contextPath}/emp_edit?no=${emp.empno}">
                                <img alt="Edit" src="images/edit.png">
                            </a>

                            <!-- Delete Button with JavaScript Confirmation -->
                            <a href="javascript:void(0);" onclick="confirmDelete(${emp.empno})">
                                <img alt="Delete" src="images/delete.png">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h1 style="color:red;text-align:center">Employees not found</h1>
        </c:otherwise>
    </c:choose>
    
    <div class="center-container">
        <a href="${pageContext.request.contextPath}/emp_add">
            <img alt="Add Employee" src="images/add.png" width="30px" height="30px"> Add Employees
        </a>
        <a href="${pageContext.request.contextPath}/">
            <img alt="Home" src="images/home.png" width="30px" height="30px"> Home
        </a>
    </div>
</body>
</html>
