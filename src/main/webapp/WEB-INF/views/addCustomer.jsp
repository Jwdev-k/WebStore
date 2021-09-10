<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="addCustomer.form.custRegi.title"/></title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="addCustomer.form.topDiv.h1"/></h1>
            <p><spring:message code="addCustomer.form.topDiv.p"/></p>
            <p><a href="/webstore">홈으로</a></p>
        </div>
    </div>
</section>
<section>
    <form:form  method="POST" modelAttribute="newCustomer" class="form-horizontal">
    <fieldset>
        <legend>새 유저 정보 입력</legend>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="customerId">
                유저 ID	</label>
            <div class="col-lg-10">
                <form:input id="customerId" path="customerId" type="text" class="form:input-large"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name">
                유저 이름</label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text" class="form:input-large"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="address">
                주소</label>
            <div class="col-lg-10">
                <form:input id="address" path="address" type="text" class="form:input-large"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="noOfOrdersMade">
                주문 건수</label>
            <div class="col-lg-10">
                <form:input id="noOfOrdersMade" path="noOfOrdersMade" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary" value ="저장"/>
            </div>
        </div>
    </fieldset>
    </form:form>
</body>
</html>
