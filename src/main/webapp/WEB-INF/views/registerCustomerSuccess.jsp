<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 03/05/2016
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer registered successfully!</h1>
                </div>
            </div>
        </section>
        <section class="container">
    <p>
    <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Start Shopping!</a>
    </p>
        </section>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
 <script src="<c:url value="/resources/js/controller.js"/>"></script> 
 <%@include file="/WEB-INF/views/template/footer.jsp" %> 