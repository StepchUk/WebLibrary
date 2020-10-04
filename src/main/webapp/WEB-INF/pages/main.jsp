<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="parts/taglib.jsp" %>
<!doctype html>
<html lang="${sessionScope.lang}">
    <%@ include file="parts/head.jsp" %>
    <body>
        <%@ include file="parts/menu.jsp" %>
        <div class="container mt-5">
            <h1>Бібліотека</h1>

            Читач реєструється в системі і далі має можливість:
            <ul class="mt-2">
                <li>здійснювати пошук (за автором / назвою);</li>
                <li>оформляти замовлення на Книгу з Каталогу.</li>
            </ul>
            Незареєстрований Читач не може замовити книгу.
            Для каталогу реалізувати можливість сортування книг:
            <ul class="mt-2">
                <li>за назвою;</li>
                <li>за автором;</li>
                <li>за виданням;</li>
                <li>за датою видання.</li>
            </ul>
            Бібліотекар видає читачеві книгу на абонемент або в читальний зал. Книга видається Читачеві на певний термін. При не поверненні книги в зазначений термін, читачеві нараховується штраф.
            Книга може бути присутньою в бібліотеці в одному або декількох екземплярах. Система веде облік доступного кількості книг.
            Кожен користувач має особистий кабінет, в якому відображається реєстраційна інформація, а також:
            <ol class="mt-2">
                <li>для читача:
                    <ul>
                        <li>список книг, які знаходяться на абонементі і дата можливого повернення (якщо дата прострочена, відображається розмір штрафу);</li>
                    </ul>
                </li>
                <li>для бібліотекаря:
                    <ul>
                        <li>список замовлень читачів;</li>
                        <li>список читачів та їх абонементи.</li>
                    </ul>
                </li>
                <li>Адміністратор системи володіє правами:
                    <ul>
                        <li>додавання / видалення книги, редагування інформації про книгу;</li>
                        <li>створення / видалення бібліотекаря;</li>
                        <li>блокування / розблокування користувача.</li>
                    </ul>
                </li>
            </ol>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>