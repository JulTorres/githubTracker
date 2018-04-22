<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="header.jsp" />

    <h1>Githubers!!</h1>

    <p>${githubers.get(0).getName()}</p>

    <p><c:out value="${githubers.get(0).getName()}" /></p>


    <c:forEach items="${requestScope.githubers}" var="githuber">
        <p><c:out value="${githuber.getName()}" /></p>
    </c:forEach>

</body>
</html>
