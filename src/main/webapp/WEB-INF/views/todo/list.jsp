<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Todo List Page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>


<div class="container-fluid">
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
<%--                <div class="container-fluid">--%>
<%--                    <a class="navbar-brand" href="/todo/list">Navbar</a>--%>
<%--                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--                        <span class="navbar-toggler-icon"></span>--%>
<%--                    </button>--%>
<%--                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">--%>
<%--                        <div class="navbar-nav">--%>
<%--                            <a class="nav-link active" aria-current="page" href="https://www.daum.net">Daum</a>--%>
<%--                            <a class="nav-link" href="https://www.naver.com">Naver</a>--%>
<%--                            <a class="nav-link" href="https://www.google.com">Google</a>--%>
<%--                            <a class="nav-link disabled">Disabled</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </nav>
        </div>
    </div>
    <div class="row content">
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        Todo List!
                    </div>
                    <div class="card-body">
<%--                        <h5 class="card-title"></h5>--%>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Tno</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Writer</th>
                                    <th scope="col">DueDate</th>
                                    <th scope="col">Finished</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${responseDTO.dtoList}" var="dto">
<%--                                <c:forEach items="${dtoList}" var="dto">--%>
                                    <tr>
                                        <th scope="row"><c:out value="${dto.tno}" /></th>
                                        <td>
                                            <a href="/todo/read?tno=${dto.tno}&${pageRequestDTO.link}"
                                               class="text-decoration-none" data-tno="${dto.tno}">
                                                <c:out value="${dto.title}"/>
                                            </a>
                                        </td>
                                        <td><c:out value="${dto.writer}"/></td>
                                        <td><c:out value="${dto.dueDate}"/></td>
                                        <td><c:out value="${dto.finished}"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="my-4">
                            <div class="float-end">
                                <ul class="pagination flex-wrap">
                                    <c:if test="${responseDTO.prev}">
                                        <li class="page-item">
                                            <a class="page-link" data-num="${responseDTO.start - 1}">Previous</a>
                                        </li>
                                    </c:if>

                                    <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                        <li class="page-item ${responseDTO.page == num ? "active" : ""}">
                                            <a class="page-link" data-num="${num}">${num}</a>
                                        </li>
                                    </c:forEach>

                                    <c:if test="${responseDTO.next}">
                                        <li class="page-item">
                                            <a class="page-link" data-num="${responseDTO.end + 1}">Next</a>
                                        </li>
                                    </c:if>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>

        document.querySelector(".btn-primary").addEventListener("click",function(e){
            self.location = "/todo/register"
        },false)

        document.querySelector(".page-item").addEventListener("click",function (e) {
            e.preventDefault();
            e.stopPropagation();

            const target = e.target;

            if (target.tagName !== 'A') {
                return
            }
            const num = target.getAttribute("data-num");

            // 백틱 (` `) 을 이용해서 템플릿 처리
            const url = '/todo/list?page=' + num;
            self.location = url

        },false)

    </script>
    <div class="row footer">
        <!--<h1>Footer</h1>-->

        <div class="row   fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">MultiCampus_Backend 14</p>
            </footer>
        </div>

    </div>
</div>






</body>
</html>