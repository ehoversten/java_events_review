<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>Registration Page</title>
</head>
<body>
	<div class="warpper">
		<div class="header">
			<div class="nav">
				<h2>Welcome, Please Register</h2>
			</div>
		</div>
		<div class="registration">
			<h1>Register!</h1>
    
  			<p><form:errors path="user.*"/></p>
    
   			<form:form method="POST" action="/registration" modelAttribute="user">
   				<p>
   					<form:label path="fName">First Name:</form:label>
   					<form:input path="fName"/>
   					<form:errors path="fName" class="red"/>
   				</p>
   				<p>
   					<form:label path="lName">Last Name:</form:label>
   					<form:input path="lName"/>
   					<form:errors path="lName" class="red"/>
   				</p>
   				
     		   <p>
         		   <form:label path="email">Email:</form:label>
          		   <form:input type="email" path="email"/>
          		   <form:errors path="email" class="red"/>
       		   </p>
       		   <p>
   					<form:label path="city">Location:</form:label>
   					<form:input path="city"/>
   					<form:errors path="city" class="red"/>
   			   </p>
		        <p>
		            <form:label path="state">State:</form:label>
		            <form:select path="state">
		                <c:forEach items="${states}" var="state">
		                    <form:option value="${state}">${state}</form:option>
		                </c:forEach>
		            </form:select>
		        </p>
       		   <p>
       		       <form:label path="password">Password:</form:label>
          	       <form:password path="password"/>
          	       <form:errors path="password" class="red"/>
     		   </p>
       		   <p>
        	       <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                   <form:password path="passwordConfirmation"/>
      		   </p>
      		   <input type="submit" value="Register!"/>
   			</form:form>
		</div>
		
		
		<div class="login">
			<h1>Login</h1>
 		  	<p><c:out value="${error}" /></p> 
   			<form method="post" action="/login">
       		   <p>
            	  <label type="email" for="email">Email</label>
            	  <input type="text" id="email" name="email"/>
        	   </p>
        	   <p>
            	  <label for="password">Password</label>
            	  <input type="password" id="password" name="password"/>
        	   </p>
        	   <input type="submit" value="Login!"/>
    	    </form> 
		</div>
	
	</div>

</body>
</html>