<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="parts/taglib.jsp" %>
<!doctype html>
<html lang="${sessionScope.lang}">
    <%@ include file="parts/head.jsp" %>
    <body>
        <div class="alert alert-warning" role="alert"><b>Path:</b> ${path}</div>
        <%@ include file="parts/menu.jsp" %>
        <div class="container mt-5">
            <h1>${registration}</h1>
            <form action="/registration" method="post">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Full Name</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" name="fullname" placeholder="Full Name" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" name="email" placeholder="Email" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="password" name="password" placeholder="password" />
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Sign up</button>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
