<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="head.jsp" />

        <!-- GITHUBERS -->
        <section id="githubers" class="light-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="section-title">
                            <h2>Githubers</h2>
                            <p>A creative team of folks from the Wild Code School, ready to boost your imagination with some crazy works.
                                Wild Code School is one of the best in town, see more you will be amazed.</p>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <c:forEach items="${requestScope.githubers}" var="githuber">

                        <!-- team member item -->
                        <div class="col-md-3 col-xs-6">
                            <div class="team-item">
                                <div class="team-image">
                                    <img src="${githuber.getAvatar_url()}" class="img-responsive" alt="author">
                                </div>
                                <div class="team-text">
                                    <h3><c:out value="${githuber.getName()}" /></h3>
                                    <div class="team-location"><c:out value="${githuber.getId()}" /></div>
                                    <div class="team-position"><c:out value="${githuber.getEmail()}" /></div>
                                    <p><c:out value="${githuber.getBio()}" /></p>
                                </div>
                                <form method="post" action="untrack">
                                    <button class="btn btn-secondary" type="submit" name="untrack" value="${githuber.getId()}">Untrack</button>
                                </form>
                            </div>
                        </div>
                        <!-- end team member item -->

                    </c:forEach>

                </div>
            </div>
        </section>


<jsp:include page="foot.jsp" />

