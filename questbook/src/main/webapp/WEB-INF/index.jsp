<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Księga gości</title>
    <style>
        .book{
            border-style: solid;
            border-width: 1px;
            margin: 20px;
            padding: 20px;
        }

        *{
            text-align: center;
        }

        body{
            background-color: rgb(241, 228, 185);
        }

        fieldset, .book{
            background-color: rgb(227, 214, 173);
        }
        textarea, #author{
            background-color: rgb(255,250,233);
        }
    </style>
</head>
<body>
<h1>Księga gości</h1>
    <form action="add" >
      <fieldset>
          <legend>Zostaw po sobie ślad</legend>
          <label for="author">Twoja nazwa: </label>
          <input type="text" name="author" id="author" required placeholder="Jan Kowalski">

          <div>
              <label for="description">Treść wiadomości</label>
          </div>
          <div>
              <textarea name="description" id="description" cols="80" rows="20" placeholder="Zacznij pisać..." required></textarea>
          </div>
          <input type="submit" value="Dodaj się!">
      </fieldset>
    </form>
<c:forEach var = "quest" items="${applicationScope.comm}">
    <section class ="book">
        <h2><c:out value="${quest.author}"/></h2>
        <p><c:out value="${quest.description}"/></p>

    </section>
</c:forEach>

</body>
</html>