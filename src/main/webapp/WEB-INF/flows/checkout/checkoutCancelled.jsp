<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 09/05/2016
  Time: 00:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger">Checkout has been cancelled</h1>

                    <p>Your items will still remain in your cart in case you change your mind!</p>
                </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Back to product catalogue</a>
            </p>
        </section>
    </div>
</div>
 <%@include file="/WEB-INF/views/template/footer.jsp" %> 
