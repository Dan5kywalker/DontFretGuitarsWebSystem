<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 06/05/2016
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management Page</h1>

            <p class="lead">Check and manage your customer list.</p>
        </div>
         
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>First Name</th>
                <th>Second Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>UserName</th>
                <th>Address</th>
                <th>Postcode</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.secondName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phoneNo}</td>
                    <td>${customer.username}</td>
                    <td>${customer.houseName}, ${customer.streetName}, ${customer.city}, ${customer.county}</td>
                    <td>${customer.postCode}</td>
                    <td><a href="<spring:url value="/admin/customer/editCustomer/${customer.customerId}" />"
                        ><span class="glyphicon glyphicon-user"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br>

        <a href="<spring:url value="/admin/customer/customerReport" />" class="btn btn-warning">Download Report</a>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
