<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 11/04/2016
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%> 
 
<script>
    $(document).ready(function(){
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[3,5,10,-1], [3,5,10, "All"]],
            "oSearch": {"sSearch": searchCondition}
        });
    });

</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Catalogue</h1>

            <p class="lead">Check out all the products available now!</p>
        </div>
         
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Image</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Stock Level</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr class="active">
                    <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                             style="width:100%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <c:if test="${product.unitInStock > 0}">
                    <td>In Stock</td>
                    </c:if>
                    <c:if test="${product.unitInStock == 0}">
                        <td>Out of Stock</td>
                    </c:if>
                    <td>£${product.productPrice} GBP</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                    ><span class="btn btn-info">View Product</span></a></td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>

