<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 14/04/2016
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Site Administration</h1>

            <p class="lead">This is the administrator page!</p>
        </div>

        <!--Get the username from the Spring security context and allow the user to logout-->
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout"/>">Logout</a>
            </h2>
        </c:if>

        <h3>
           <a href="<c:url value="/admin/productInventory"/>" >Product Inventory</a>
        </h3>

        <p>View, check and modify the product inventory.</p>
         
        <br> <br>

        <h3>
            <a href="<c:url value="/admin/customer"/>" >Customer Management</a>
        </h3>

        <p>View the customer list.</p>

        <br> <br>

        <h3>
            <a href="<c:url value="/admin/orders"/>" >Order Management</a>
        </h3>

        <p>View orders made by customers</p>

        <br> <br>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
