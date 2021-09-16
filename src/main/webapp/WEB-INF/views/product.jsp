<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="product.form.title"/></title>
</head>
<section>
    <div class="pull-right" style="padding-right: 50px">
        <a href="?id=${product.productId}&language=ko">한글</a>|
        <a href="?id=${product.productId}&language=en">English</a>
    </div>
</section>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="product.form.h1"/></h1>
            <p><a href="/webstore">홈으로</a></p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value='/img/${product.productId}.png'></c:url>"
                 alt="상품 사진" style="width: 100%"/>
        </div>
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong><spring:message code="product.form.prodID.label"/> : </strong>
                <span class="label label-warning">${product.productId}</span>
            </p>
            <p>
                <strong><spring:message code="addProduct.form.manufacturer.label"/></strong> : ${product.manufacturer}
            </p>
            <p>
                <strong><spring:message code="product.form.category"/> </strong> : ${product.category}
            </p>
            <p>
                <strong><spring:message code="product.form.unitsInStock"/> </strong> : ${product.unitsInStock}
            </p>
            <p>
                <strong><a href="/webstore/pdf/${product.productId}.pdf">
                    <spring:message code="product.form.manual.link"/> (${product.productId}.pdf)]</a></strong>
            </p>
            <p><a href="/webstore/market/product.xml?id=${product.productId}">Xml형식으로 보기</a></p>
            <p><a href="/webstore/market/product.json?id=${product.productId}">Json형식으로 보기</a></p>
            <h4>${product.unitPrice}<spring:message code="product.form.dollar.h4"/></h4>
            <p>
                <a href="<spring:url value="/market/products" />"
                   class="btn btn-default"> <span
                        class="glyphicon-hand-left glyphicon"></span> <spring:message code="product.form.goBack.link"/>
                </a>
                <a href="#" class="btn btn-warning btn-large"> <span
                        class="glyphicon-shopping-cart glyphicon"></span><spring:message code="product.form.putOrder.link"/>
                </a>
            </p>
        </div>
    </div>
</section>
</body>

