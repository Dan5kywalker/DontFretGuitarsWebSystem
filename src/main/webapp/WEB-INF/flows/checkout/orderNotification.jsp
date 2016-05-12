<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 09/05/2016
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thanks for shopping with us!</h1>

                    <p>Your order is currently being processed.</p>
                </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/"/>" class="btn btn-default">Back to the homepage</a>
            </p>
        </section>
    </div>
</div>
 <%@include file="/WEB-INF/views/template/footer.jsp" %> 