<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
<body>
	<h1>Welcome, <c:out value="${user.fName}" /></h1>
	<a href="/logout">Logout</a>
	<h2>Events in your State</h2>
<%--     <c:if test="${localEvents.isEmpty()}">
    	<h4>No events in your state</h4>
    </c:if>
    <c:if test="${!localEvents.isEmpty()}"> --%>
	<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
            <th>Actions</th>
        </tr>
    </thead>
<%--     <tbody>
        <c:forEach items="${localEvents}" var="event">
        <tr>
            <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
            <td><fmt:formatDate pattern="MMMMMMM dd, yyyy" value="${event.date}" /></td>
            <td><c:out value="${event.city}"/></td>
            <td><c:out value="${event.poster.firstName}"/></td>
            <td>
            	<c:if test="${event.poster.id.equals(user.id)}">
            		<a href="/events/${event.id}/edit">Edit</a>
            		<a href="/events/${event.id}/delete">Delete</a>
            	</c:if>
            	<c:if test="${!event.poster.id.equals(user.id)}">
            	
            		<c:if test="${!event.joiners.contains(user)}">
            			<a href="/events/${event.id}/join">Join</a>
            		</c:if>
            		<c:if test="${event.joiners.contains(user)}">
            			<p>Joining</p>
            			<a href="/events/${event.id}/cancel">Cancel</a>
            		</c:if>
            	
            	</c:if>            
            </td>
        </tr>
        </c:forEach>
    </tbody>
  	</table>
    </c:if>
	<h2>Other Events</h2>
    <c:if test="${notEvents.isEmpty()}">
    	<h4>No events outside your state</h4>
    </c:if>
    <c:if test="${!notEvents.isEmpty()}">
	<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${notEvents}" var="event">
        <tr>
            <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
            <td><fmt:formatDate pattern="MMMMMMM dd, yyyy" value="${event.date}" /></td>
            <td><c:out value="${event.city}"/>, <c:out value="${event.state}"/></td>
            <td><c:out value="${event.poster.firstName}"/></td>
            <td>
            	<c:if test="${event.poster.id.equals(user.id)}">
            		<a href="/events/${event.id}/edit">Edit</a>
            		<a href="/events/${event.id}/delete">Delete</a>
            	</c:if>
            	<c:if test="${!event.poster.id.equals(user.id)}">
            		<c:if test="${!event.joiners.contains(user)}">
            			<a href="/events/${event.id}/join">Join</a>
            		</c:if>
            		<c:if test="${event.joiners.contains(user)}">
            			<p>Joining <a href="/events/${event.id}/cancel">Cancel</a></p>
            		</c:if>
            	</c:if>  
            </td>
        </tr>
        </c:forEach>
    </tbody>
    </table>
    </c:if> --%>
    <h2>New Event</h2>
    <form:form method="POST" action="/events" modelAttribute="event">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
            <form:errors path="name" class="red"/>
        </p>
        <p>
            <form:label path="city">Location:</form:label>
            <form:input path="city"/>
            <form:errors path="city" class="red"/>
        </p>
        <p>
            <form:label path="state">State:</form:label>
            <form:select path="state">
                <form:option value="${user.state}" />
            
                <c:forEach items="${states}" var="state">
                    <form:option value="${state}">${state}</form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
            <form:errors path="date" class="red"/>
        </p>
        <form:input type="hidden" path="poster" value="${user.id}"/>
        <input type="submit" value="New Event"/>
    </form:form>
</body>
</html>