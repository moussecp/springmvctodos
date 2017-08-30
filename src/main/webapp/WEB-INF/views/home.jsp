<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>TODOs web application</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <spring:message code="welcome.caption"/> ${name}. <BR/> Now, you can <a href="/list-todos">manage your todos.</a>
</div>

<div class="container">
    <table class="table table-striped">
        <caption><spring:message code="todo.caption"/></caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Category</th>
            <th>Priority</th>
            <th>User</th>
            <th>Creation Date</th>
            <th>Target Date</th>
            <th>Is Completed?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>${todo.category.name}</td>
                <td>${todo.priority}</td>
                <td>${todo.user.username}</td>
                <td>${todo.getFormattedDate(todo.creationDate)}</td>
                <td>${todo.getFormattedDate(todo.targetDate)}</td>
                <td>${todo.done}</td>
                <td><a href="/update-todo?id=${todo.id}"
                       class="btn btn-success">Update</a> <a
                        href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="btn btn-success" href="/add-todo">Add</a>
    </div>

</div>
</body>
</html>