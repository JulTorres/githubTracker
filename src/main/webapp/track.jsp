<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="head.jsp" />


<div class="container" class="z-depth-1">

    <div class="row">
        <div class="col-lg-12 text-center">
            <div class="section-title">
                <h2>Track!!</h2>
            </div>
        </div>
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