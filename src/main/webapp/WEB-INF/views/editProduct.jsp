<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 15/04/2016
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>

            <p class="lead">Update information about the product.</p>
        </div>

        <!--Tell the form which action it should be submitted to -->
        <form:form action="${pageContext.request.contextPath}/admin/product/editProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
        <form:hidden path="productId" value="${product.productId}" />

        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
        </div>

        <div class="form-group">
            <label for="category">Category:
                <form:select path="productCategory" id="category">
                    <form:option value="acoustic guitar">Acoustic Guitar</form:option>
                    <form:option value="electric guitar">Electric Guitar</form:option>
                    <form:option value="bass guitar">Bass Guitar</form:option>
                    <form:option value="folk instrument">Folk Instrument</form:option>
                    <form:option value="electric guitar amplifier">Electric Guitar Amplifier</form:option>
                    <form:option value="bass guitar amplifier">Bass Guitar Amplifier</form:option>
                    <form:option value="accessory">Accessory</form:option>
                    <form:option value="guitar pedal">Guitar Pedal</form:option>
                    <form:option value="bass pedal">Bass Pedal</form:option>
                </form:select>
            </label>
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <form:textarea path="productDescription" id="description" class="form-control" value="${product.productDescription}"/>
        </div>

        <div class="form-group">
            <label for="price">Price: </label>
            <form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}" />
        </div>

        <div class="form-group">
            <label for="condition">Condition: </label>
            <label class="checkbox-inline">
                <form:radiobutton path="productCondition" id="condition" value="new"/> New
            </label>
            <label class="checkbox-inline">
                <form:radiobutton path="productCondition" id="condition" value="pre-owned"/> Pre-Owned
            </label>
        </div>

        <div class="form-group">
            <label for="status">Status: </label>
            <label class="checkbox-inline">
                <form:radiobutton path="productStatus" id="status" value="Active"/> Active
            </label>
            <label class="checkbox-inline">
                <form:radiobutton path="productStatus" id="status" value="Inactive"/> Inactive
            </label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock: </label>
            <form:input path="unitInStock" id="unitInStock" class="form-control" value="${product.unitInStock}"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer: </label>
            <form:input path="productManufacturer" id="manufacturer" class="form-control" value="${product.productManufacturer}" />
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Image: </label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
        </div>

        <br><br>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>

        </form:form>

         <%@include file="/WEB-INF/views/template/footer.jsp" %>

