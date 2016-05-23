<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 18/05/2016
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Customer Information</h1>

            <p class="lead">Update information about this customer.</p>
        </div>

        <!--Tell the form which action it should be submitted to -->
        <form:form action="${pageContext.request.contextPath}/admin/customer/editCustomer" method="post"
                   commandName="customer" enctype="multipart/form-data">
            <form:hidden path="customerId" value="${customer.customerId}"/>


        <div class="form-group">
            <label for="Firstname">First Name:</label>
            <form:input path="firstName" id="Firstname" class="form-control" value="${customer.firstName}"/>
        </div>

        <div class="form-group">
            <label for="Secondname">Second Name:</label>
            <form:input path="secondName" id="Secondname" class="form-control" value="${customer.secondName}"/>
        </div>

        <div class="form-group">
            <label for="email">Email Address:</label>
            <form:input path="email" id="email" class="form-control" value="${customer.email}"/>
        </div>

        <div class="form-group">
            <label for="phoneNo">Phone Number:</label>
            <form:input path="phoneNo" id="phoneNo" class="form-control" value="${customer.phoneNo}"/>
        </div>

        <div class="form-group">
            <label for="username">Username:</label>
            <form:input path="username" id="username" class="form-control" value="${customer.username}"/>
        </div>

        <div class="form-group">
            <label for="username">Password:</label>
            <form:input path="password" id="password" class="form-control" value="${customer.password}"/>
        </div>

        <h3>Customer Address</h3>

        <div class="form-group">
            <label for="streetName">Street Name:</label>
            <form:input path="streetName" id="streetName" class="form-control" value="${customer.streetName}"/>
        </div>

        <div class="form-group">
            <label for="houseName">House Name:</label>
            <form:input path="houseName" id="houseName" class="form-control" value="${customer.houseName}"/>
        </div>

        <div class="form-group">
            <label for="city">City:</label>
            <form:input path="city" id="city" class="form-control" value="${customer.city}"/>
        </div>

        <div class="form-group">
            <label for="county">County:</label>
            <form:input path="county" id="county" class="form-control" value="${customer.county}"/>
        </div>

        <div class="form-group">
            <label for="postCode">Postcode:</label>
            <form:input path="postCode" id="postCode" class="form-control" value="${customer.postCode}"/>
        </div>

        <br><br>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/admin/customer" />" class="btn btn-default">Cancel</a>

        </form:form>

         <%@include file="/WEB-INF/views/template/footer.jsp" %>
