<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">My Book Library</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/books-list"><fmt:message key="menu.books_list" /></a>
            </li>
        </ul>

        <div class="navbar-text mr-4">
            <div class="dropdown">
                <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <fmt:message key="language.${sessionScope.lang}" />
                </button>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="?switch_lang=en"><fmt:message key="language.en" /></a>
                    <a class="dropdown-item" href="?switch_lang=ru"><fmt:message key="language.ru" /></a>
                    <a class="dropdown-item" href="?switch_lang=ua"><fmt:message key="language.ua" /></a>
                </div>
            </div>
        </div>
        <div class="navbar-text mr-3">
            <c:choose>
                <c:when test="${not empty userName}">${userName}</c:when>
                <c:otherwise><fmt:message key="guest" /></c:otherwise>
            </c:choose>
        </div>
        <a class="btn btn-outline-primary mr-2" href="/login">
            <fmt:message key="button.login" />
        </a>
        <!--form action="/logout" method="post">
            <button class="btn btn-primary" type="submit"><fmt:message key="button.logout" /> </button>
        </form-->
        <a class="btn btn-primary" href="/registration"><fmt:message key="button.registration" /> </a>
    </div>
</nav>
