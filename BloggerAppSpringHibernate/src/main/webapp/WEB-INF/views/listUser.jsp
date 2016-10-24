<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
	<%@include file="authheader.jsp" %>	
		<div class="panel panel-default navbar-inner">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Users </span> <span style="float: right">
					
			</div>
			<c:if test="${not empty success }">
				<div class="alert alert-success alertSuccessOnTop leadSuccessOnTop">
		    		${success}
				</div>
			</c:if>
			<c:choose>
				<c:when test="${not empty userList}">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Firstname</th>
								<th>Lastname</th>
								<th>Email</th>
								<th>Phone Number</th>
								<th>Role</th>
								<th>State</th>
								<th width="100"></th>
								<th width="100"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user">
								<tr>
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.email}</td>
									<td>${user.phone}</td>
									<td><c:forEach items="${user.userRoles}" var="role">
											<c:set var="role" value="${role.roleType}" />

											<c:set var="roleCap" value="${fn:toUpperCase(role)}" />
			                        		${roleCap} &nbsp;			                        		
			                        	</c:forEach></td>
									<td>${user.stateName}</td>
									<sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
										<td><a href="<c:url value='/edit-user-${user.userId}' />"
											class="btn btn-success custom-width">edit</a></td>
									</sec:authorize>
									<sec:authorize access="hasRole('ADMIN')">
										<td><a
											href="<c:url value='/delete-user-${user.userId}' />"
											class="btn btn-danger custom-width">delete</a></td>
									</sec:authorize>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
            		Users not found
            	</c:otherwise>
			</c:choose>
		</div>
		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/newuser' />">Add New User</a>
			</div>
		</sec:authorize>
	</div>
</body>
</html>