<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 14/04/2016
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the forms below with information about the product.</p>
        </div>

        <!--Tell the form which action it should be submitted to -->
        <form:form action="${pageContext.request.contextPath}/admin/product/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name:</label> <form:errors path="productName" cssStyle="color: #ff0000;" />
            <form:input path="productName" id="name" class="form-control" />
        </div>

        <div class="form-group">
            <label for="category">Category:
                <form:select path="productCategory" id="category">
                    <form:option value="Acoustic Guitar">Acoustic Guitar</form:option>
                    <form:option value="Electric Guitar">Electric Guitar</form:option>
                    <form:option value="Bass Guitar">Bass Guitar</form:option>
                    <form:option value="Folk Instrument">Folk Instrument</form:option>
                    <form:option value="Electric Guitar Amplifier">Electric Guitar Amplifier</form:option>
                    <form:option value="Bass Guitar Amplifier">Bass Guitar Amplifier</form:option>
                    <form:option value="Accessory">Accessory</form:option>
             </form:select>
            </label>
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <form:textarea path="productDescription" id="description" class="form-control" />
        </div>

        <div class="form-group">
            <label for="price">Price: </label> <form:errors path="productPrice" cssStyle="color: #ff0000;" />
            <form:input path="productPrice" id="price" class="form-control" />
        </div>

        <div class="form-group">
            <label for="condition">Condition: </label>
            <label class="checkbox-inline">
                <form:radiobutton path="productCondition" id="condition" value="New"/> New
            </label>
            <label class="checkbox-inline">
                <form:radiobutton path="productCondition" id="condition" value="Pre-Owned"/> Pre-Owned
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

        <div class="form-group"> <form:errors path="unitInStock" cssStyle="color: #ff0000;" />
            <label for="unitInStock">Unit In Stock: </label>
            <form:input path="unitInStock" id="unitInStock" class="form-control" />
        </div>

        <div class="form-group"> <form:errors path="productManufacturer" cssStyle="color: #ff0000;" />
            <label for="manufacturer">Manufacturer: </label>
            <form:input path="productManufacturer" id="manufacturer" class="form-control" />
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
