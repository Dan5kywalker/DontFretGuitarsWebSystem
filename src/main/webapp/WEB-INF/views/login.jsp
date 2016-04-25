<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: danielwalker
  Date: 17/04/2016
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Login with Username and Password</h2>

            <c:if test="${not empty  msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">Username: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="text" id="password" name="password" class="form-control" />
                </div>

                <input type="submit" value="Submit" class="btn btn-default ">

                <!--Generate a token leveraging SpringSecurity to prevent a Cross Site Request Forgery attack-->
                <!--Also allows the form to be valid and therefore can be submitted-->
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

        </div>
    </div>
</div>

 <%@include file="/WEB-INF/views/template/footer.jsp" %>
