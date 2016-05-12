<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 12/05/2016
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Orders</h1>

<p class="lead">View and manage orders.</p>
</div>
 
<table class="table table-striped table-hover">
    <thead>
    <tr class="bg-success">
        <th>Customer Name</th>
        <th>Customer Address</th>
        <th>Customer Postcode</th>
        <th>Customer email</th>
        <th>Items Ordered</th>

    </tr>
    </thead>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.customer.firstName} ${order.customer.secondName}</td>
            <td>${order.customer.houseName}, ${order.customer.streetName}</td>
            <td>${order.customer.postCode}</td>
            <td>${order.customer.email}</td>
            <c:forEach var="cartItem" items="${order.cart.cartItems}">
            <td>${cartItem.product.productName}</td>
            </c:forEach>

        </tr>
    </c:forEach>
</table>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
