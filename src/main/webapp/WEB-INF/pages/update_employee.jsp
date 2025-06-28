<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="update-employee-container">
    <h1>Update Employee</h1>
    <frm:form modelAttribute="emp" class="update-form">
        <table>
            <tr><td>Employee Number:</td><td><frm:input path="empno" readonly="true"/></td></tr>
            <tr><td>Employee Name:</td><td><frm:input path="ename" readonly="true"/></td></tr>
            <tr><td>Employee Designation:</td><td><frm:input path="job"/></td></tr>
            <tr><td>Employee Salary:</td><td><frm:input path="sal"/></td></tr>
            <tr><td>Department Number:</td><td><frm:input path="deptno"/></td></tr>
            <tr><td colspan="2" style="text-align: center;">
                    <input type="submit" value="Update Employee"/>
                    <input type="reset" value="Cancel"/>
            </td></tr>
        </table>
    </frm:form>
</body>
</html>
