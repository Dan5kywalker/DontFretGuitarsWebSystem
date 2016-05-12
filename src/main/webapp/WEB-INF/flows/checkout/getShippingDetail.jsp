<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 08/05/2016
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Shipping</h1>
        </div>


        <form:form commandName="order" class="form-horizontal" >

        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="shippingStreet">Street Name:</label>
            <form:input path="cart.customer.streetName" id="shippingStreet" class="form-control" />
        </div>

        <div class="form-group">
            <label for="shippingHouseName">House Number:</label>
            <form:input path="cart.customer.houseName" id="shippingHouseName" class="form-control" />
        </div>

        <div class="form-group">
            <label for="shippingCity">City:</label>
            <form:input path="cart.customer.city" id="shippingCity" class="form-control" />
        </div>

        <div class="form-group">
            <label for="shippingCounty">County:</label>
            <form:input path="cart.customer.county" id="shippingCounty" class="form-control" />
        </div>

        <div class="form-group">
            <label for="shippingPostCode">Postcode:</label>
            <form:input path="cart.customer.postCode" id="shippingPostCode" class="form-control" />
        </div>

        <input type="hidden" name="_flowExecutionKey"/>

        <br><br>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected" />
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>

         <%@include file="/WEB-INF/views/template/footer.jsp" %>



