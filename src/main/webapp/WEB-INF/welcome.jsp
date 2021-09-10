<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome to Naka World</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron">
    <h1>${greeting}</h1>
    <p>${tagline}</p>
    <p><a href="customers">유저 목록 보기</a></p>
    <p><a href="customers/add">유저 추가</a></p>
    <p><a href="market/updatestock">500미만 상품 제고 1000 증가</a></p>
    <p><a href="market/products">상품 목록 보기</a></p>
    <p><a href="market/products/add">상품 추가</a></p>
    <p><a href="products/Tablet/price;low=200;high=300000?brand=Google">복합조건 검색</a></p>
    <p><a href="products/all/price;low=200;high=300000?brand=Google">모든 카테고리 조건 검색</a></p>
</div>
</body>
</html>
