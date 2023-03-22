<%-- 
    Document   : errors
    Created on : Feb 24, 2023, 10:43:40 AM
    Author     : ngoqu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${errors.size() > 0}">
    <c:forEach items="${errors}" var="error">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:forEach>
</c:if>