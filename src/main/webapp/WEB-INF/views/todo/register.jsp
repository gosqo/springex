<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Todo Register Page</title>
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
                        Register Todo here!
                    </div>
                    <div class="card-body">
                        <form action="/todo/register" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group text">Title</span>
                                <input type="text" name="title" class="form-control" placeholder="Title">
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group text">DueDate</span>
                                <input type="date" name="dueDate" class="form-control">
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group text">Writer</span>
                                <input type="text" name="writer" class="form-control" placeholder="Wirter">
                            </div>
                            <div class="my-4">
                                <div class="float-end">
                                    <button type="reset" class="btn btn-success">Go to List</button>
                                    <button type="reset" class="btn btn-secondary">Reset</button>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </form>
                        <script>
<%--                            서버사이드 검증 --%>
                            const serverValidResult = {}

                            <c:forEach items="${errors}" var="error">
                                serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
                            </c:forEach>

                            console.log(serverValidResult);

                            document.querySelector(".btn-success").addEventListener("click",function(e){
                                self.location = "/todo/list";
                            },false);

                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row footer">
        <!--<h1>Footer</h1>-->

        <div class="row   fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">MultiCampus_Backend 14</p>
            </footer>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>