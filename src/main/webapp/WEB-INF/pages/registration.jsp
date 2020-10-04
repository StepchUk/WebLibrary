<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="parts/taglib.jsp" %>
<!doctype html>
<html lang="${sessionScope.lang}">
    <%@ include file="parts/head.jsp" %>
    <body>
        <%@ include file="parts/menu.jsp" %>
        <div class="container mt-5">
            <c:if test="${regError}">
                <div class="alert alert-danger mb-3" role="alert">
                    <c:if test = "${not empty firstnameempty}">
                        <fmt:message key="${firstnameempty}" /><br />
                    </c:if>
                    <c:if test = "${not empty lastnameempty}">
                        <fmt:message key="${lastnameempty}" /><br />
                    </c:if>
                    <c:if test = "${not empty wrongEmailFormat}">
                        <fmt:message key="${wrongEmailFormat}" /><br />
                    </c:if>
                    <c:if test = "${not empty wrongPasswordFormat}">
                        <fmt:message key="${wrongPasswordFormat}" /><br />
                    </c:if>
                    <c:if test = "${not empty passwordsDontMatch}">
                        <fmt:message key="${passwordsDontMatch}" /><br />
                    </c:if>
                    <c:if test = "${not empty userExist}">
                        <fmt:message key="${userExist}" />
                    </c:if>
                </div>
            </c:if>

            <h1><fmt:message key="h1.registration" /></h1>
            <form class="needs-validation mt-5" action="/registration" method="post" novalidate
                  oninput='confirmPassword.setCustomValidity(confirmPassword.value !== password.value ?
                  document.getElementById("confirm-password").textContent = "<fmt:message key="error.passwordnotmatch" />" :
                  document.getElementById("confirm-password").textContent = "")'>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label"><fmt:message key="text.firstname" /> <b class="text-danger">*</b></label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" name="firstname"
                               placeholder="<fmt:message key="text.firstname" />" required />
                        <div class="invalid-feedback">
                            <fmt:message key="error.firstname" />
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label"><fmt:message key="text.lastname" /> <b class="text-danger">*</b></label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" name="lastname"
                               placeholder="<fmt:message key="text.lastname" />" required />
                        <div class="invalid-feedback">
                            <fmt:message key="error.lastname" />
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label"><fmt:message key="text.email" /> <b class="text-danger">*</b></label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" name="email"
                               pattern="^[\w!#$%&’*+/=?`{|}~^-]+(?:\.[\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,6}$"
                               placeholder="Ex: ex@example.example" required />
                        <div class="invalid-feedback">
                            <fmt:message key="error.emailmessage" />
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label"><fmt:message key="text.password" /> <b class="text-danger">*</b></label>
                    <div class="col-sm-6">
                        <input class="form-control" type="password" name="password"
                               placeholder="<fmt:message key="text.password" />"
                               minlength="8" maxlength="20" required />
                        <div class="invalid-feedback">
                            <fmt:message key="error.passwordmessage" />
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label"><fmt:message key="text.confirmpassword" /> <b class="text-danger">*</b></label>
                    <div class="col-sm-6">
                        <input class="form-control" type="password" name="confirmPassword"
                               placeholder="<fmt:message key="text.confirmpassword" />"
                               minlength="8" maxlength="20" required />
                        <div id="confirm-password" class="invalid-feedback">
                            <fmt:message key="error.passwordmessage" />
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary mt-3" type="submit"><fmt:message key="button.registration" /></button>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script>
            (function() {
                'use strict';
                window.addEventListener('load', function() {
                    var forms = document.getElementsByClassName('needs-validation');
                    var validation = Array.prototype.filter.call(forms, function(form) {
                        form.addEventListener('submit', function(event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);
            })();
        </script>
    </body>
</html>
