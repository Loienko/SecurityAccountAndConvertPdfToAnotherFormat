    <a href="${pageContext.request.contextPath}/Home">
        Home
    </a>
    ||
    <a href="${pageContext.request.contextPath}/employeeTask">
        User Task
    </a>
    ||
    <a href="${pageContext.request.contextPath}/managerTask">
        For Admin Page
    </a>
    ||
    <a href="${pageContext.request.contextPath}/userInfo">
        User Info
    </a>
    ||
    <a href="${pageContext.request.contextPath}/login">
        Login
    </a>
    ||
    <a href="${pageContext.request.contextPath}/logout">
        Logout
    </a>

<style>
    body {
        font-family: Arial, sans-serif; /* Рубленый шрифт */
    }

    .letter {
        color: red; /* Красный цвет символов */
        font-size: 200%; /* Размер шрифта в процентах */
        font-family: serif; /* Шрифт с засечками */
        position: center; /* Относительное позиционирование */
        /*top: 5px; !* Сдвиг сверху *!*/
    }
</style>
&nbsp;
<span class="letter"> ${loginedUser.userName}</span>