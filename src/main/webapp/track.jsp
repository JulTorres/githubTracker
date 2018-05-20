<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="head.jsp" />


<div class="container" class="z-depth-1">

    <div class="row track">
        <div class="col-lg-12 text-center">
            <div class="section-title">
                <h2>Track!!</h2>
            </div>
            <div class="githuberNotFound">
                <c:if test="${not empty githuberNotFound}">
                    <p class="githuberNotFound"><c:out value="${githuberNotFound}" /></p>
                </c:if>
            </div>
        </div>
    </div>

    <div class="row">
        <p class="track-instructions">You are a serial tracker, don't fight it. Enter the login of the best githubers you know of.</p>
    </div>

    <div class="row">
        <section class="tracker-form">
            <form action="track" method="post">
                <label>Login:</label>
                <br>
                <input type="text" name="LOGIN" placeholder="Mickey">
                <br><br>
                <button class="btn waves-effect waves-light cyan darken-4" type="submit" name="action">Envoyer
                   <%--  <i class="material-icons right">send</i>  --%>
                </button>
            </form>
        </section>
    </div>
</div>


<jsp:include page="foot.jsp" />