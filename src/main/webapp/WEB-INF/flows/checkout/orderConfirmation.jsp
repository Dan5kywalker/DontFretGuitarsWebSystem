<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 08/05/2016
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Checkout</h1>

            <p class="lead">Order confirmation</p>
        </div>

        <div class="container">
            <div class="row">


                <form:form commandName="order" class="form-horizontal">

                <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

                    <div class="text-center">
                        <h1>Receipt</h1>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <address>
                                <strong>Shipping Address</strong><br>
                                    ${order.cart.customer.streetName}
                                <br>
                                    ${order.cart.customer.houseName}
                                <br>
                                    ${order.cart.customer.city},${order.cart.customer.county}
                                <br>
                                    ${order.cart.customer.postCode}
                            </address>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                            <p>Order Date: <fmt:formatDate type="date" value="${now}"/></p>
                        </div>
                    </div>
                   <!-- <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <address>
                                <strong>Shipping Details</strong><br>
                                    ${order.cart.customer.streetName}
                                <br>
                                    ${order.cart.customer.houseName}
                                <br>
                                    ${order.cart.customer.city},${order.cart.customer.county}
                                <br>
                                    ${order.cart.customer.postCode}
                            </address>
                        </div> -->
                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>#</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.product.productName}</em></td>
                                        <td class="col-md-1" style="text-align:center">${cartItem.quantity}</td>
                                        <td class="col-md-1"
                                            style="text-align:center">£${cartItem.product.productPrice}</td>
                                        <td class="col-md-1" style="text-align:center">£${cartItem.totalPrice}</td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total: </strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>£${order.cart.grandTotal}</strong></h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <input type="hidden" name="_flowExecutionKey"/>

                        <br><br>
                        <button class="btn btn-default" name="_eventId_backToGetShippingDetail">Back</button>
                        <input type="submit" value="Submit Order" class="btn btn-default"
                               name="_eventId_orderConfirmed"/>
                        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                    </div>
                    </form:form>

                </div>
            </div>

             <%@include file="/WEB-INF/views/template/footer.jsp" %>




