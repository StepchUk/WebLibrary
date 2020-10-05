<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="parts/taglib.jsp" %>
<!doctype html>
<html lang="${sessionScope.lang}">
<%@ include file="parts/head.jsp" %>
<body>
<%@ include file="parts/menu.jsp" %>
<div class="container-xl mt-5">
    <h1>Book list</h1>

    <c:if test="${not empty sessionScope.user}">
        <form class="form-inline mt-4" action="?search" method='GET'>
            <div class="form-group mx-sm-2">
                <label for="text"></label>
                <input type="text" class="form-control" id="text" name="text">
            </div>
            <div class="form-group mx-sm-2">
                <label for="select-type"></label>
                <select class="form-control" id="select-type" name="type">
                    <option value="author"><fmt:message key="text.author" /></option>
                    <option value="title"><fmt:message key="text.title" /></option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary mx-sm-2"><fmt:message key="text.search" /></button>
        </form>
    </c:if>

    <c:choose>
        <c:when test="${not empty books}">
            <table class="table table-striped mt-5">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col"><fmt:message key="text.title" /></th>
                        <th scope="col"><fmt:message key="text.author" /></th>
                        <th scope="col"><fmt:message key="text.edition" /></th>
                        <th scope="col"><fmt:message key="text.year" /></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <th scope="row">${book.id}</th>
                        <td style="white-space: nowrap;">${book.name}</td>
                        <td style="white-space: nowrap;">${book.author}</td>
                        <td>${book.edition}</td>
                        <td>${book.editionYear}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            No books found
        </c:otherwise>
    </c:choose>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>