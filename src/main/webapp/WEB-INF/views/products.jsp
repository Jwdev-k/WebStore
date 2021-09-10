<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>상품</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>상품 목록</h1>
            <p>All the available products in our store</p>
            <p><a href="/webstore">홈으로</a></p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <img src= "<c:url value='/img/${product.productId}.png'></c:url>"
                         alt="상품 사진" style = "width:100%"/>
                    <div class="caption" >
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>가격: $${product.unitPrice}</p>
                        <p>재고수량: ${product.unitsInStock} </p>
                        <p>상품상태: ${product.condition}</p>
                        <p><a href="<spring:url value='/market/product?id=${product.productId}' /> "
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span>상세정보
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
