<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 12/04/2016
  Time: 00:17
  To change this template use File | Settings | File Templates.
--%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <!-- <h1>Product Detail</h1>

             <p class="lead">Here is the detailed information of the product!</p> -->
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"
                         style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <c:if test="${product.unitInStock > 0}">
                    <h4><strong>In Stock</strong></h4>
                    </c:if>
                    <c:if test="${product.unitInStock == 0}">
                    <h4 style="color: #ff0000"><strong>Out of Stock. Contact the store for re-order.</strong></h4>
                    </c:if>
                    <p></p>
                    <p>
                        <strong>Manufacturer</strong> : ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.productCondition}
                    </p>
                    <h4>£${product.productPrice} GBP</h4>

                    <br>

                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/product/productList"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <p style="color: #0ce3ac"><strong>Sign in or register to add the item to your cart!</strong></p>
                        </c:if>

                        <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name != 'StoreManager'}">
                            <c:if test="${product.unitInStock > 0}">
                                <a href="#" class="btn btn-success btn-large"
                                   ng-click="addToCart('${product.productId}')"><span
                                        class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
                            </c:if>
                        </c:if>
                    </p>


                    <script src="<c:url value="/resources/js/controller.js"/> "></script>
                     <%@include file="/WEB-INF/views/template/footer.jsp" %>

