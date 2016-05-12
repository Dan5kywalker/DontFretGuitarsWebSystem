<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 03/05/2016
  Time: 00:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below.</p>
        </div>

        <!--Tell the form which action it should be submitted to -->
        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="customer" >

        <h3>Basic Info</h3>


        <div class="form-group">
            <label for="firstName">First Name:</label> <form:errors path="firstName" cssStyle="color: #ff0000"/>
            <form:input path="firstName" id="firstName" class="form-control" />
        </div>

        <div class="form-group">
            <label for="secondName">Surname:</label> <form:errors path="secondName" cssStyle="color: #ff0000"/>
            <form:input path="secondName" id="secondName" class="form-control" />
        </div>

        <div class="form-group">
            <label for="email">Email Address:</label> <span style="color:#ff0000">${emailMsg}</span> <form:errors
                path="email" cssStyle="color: #ff0000" />
            <form:input path="email" id="email" class="form-control" />
        </div>

        <div class="form-group">
            <label for="phoneNo">Phone Number:</label>
            <form:input path="phoneNo" id="phoneNo" class="form-control" />
        </div>

        <div class="form-group">
            <label for="username">Username:</label> <span style="color:#ff0000">${usernameMsg}</span> <form:errors
                path="username" cssStyle="color: #ff0000" />
            <form:input path="username" id="username" class="form-control" />
        </div>

        <div class="form-group">
            <label for="password">Password:</label> <form:errors path="password" cssStyle="color: #ff0000"/>
            <form:password path="password" id="password" class="form-control" />
        </div>

        <h3>Customer Address</h3>

        <div class="form-group">
            <label for="streetName">Street Name:</label> <form:errors path="streetName" cssStyle="color: #ff0000"/>
            <form:input path="streetName" id="streetName" class="form-control" />
        </div>

        <div class="form-group">
            <label for="houseName">House Name:</label> <form:errors path="houseName" cssStyle="color: #ff0000"/>
            <form:input path="houseName" id="houseName" class="form-control" />
        </div>

        <div class="form-group">
            <label for="city">City:</label> <form:errors path="city" cssStyle="color: #ff0000"/>
            <form:input path="city" id="city" class="form-control" />
        </div>

        <div class="form-group">
            <label for="county">County:</label> <form:errors path="county" cssStyle="color: #ff0000"/>
            <form:input path="county" id="county" class="form-control" />
        </div>

        <div class="form-group">
            <label for="postCode">Postcode:</label> <form:errors path="postCode" cssStyle="color: #ff0000"/>
            <form:input path="postCode" id="postCode" class="form-control" />
        </div>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>

        </form:form>

         <%@include file="/WEB-INF/views/template/footer.jsp" %>

