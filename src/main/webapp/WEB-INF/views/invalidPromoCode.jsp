<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href=
        "//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>부정 판촉 코드</title>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger">존재하지 않는 판촉 코드</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/market/products" />"
               class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span>
                products
            </a>
        </p>
    </div>
</section>

