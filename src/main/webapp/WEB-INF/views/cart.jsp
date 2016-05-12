<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 25/04/2016
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Your Shopping Cart</h1>

                    <p>View the products currently in your cart!</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cartApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()"><span
                        class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
                <a href="<spring:url value="/order/${cartId}"/>" class="btn btn-success pull-right">
                    <span class="glyphicon glyphicon-tags"></span>  Checkout</a>
            </div>

            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <tr ng-repeat = "item in cart.cartItems">
                    <td>{{item.product.productName}}</td>
                    <td>£{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>£{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"></span>remove</a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>£{{calGrandTotal()}}</th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
 <script src="<c:url value="/resources/js/controller.js"/>"></script> 
 <%@include file="/WEB-INF/views/template/footer.jsp" %> 