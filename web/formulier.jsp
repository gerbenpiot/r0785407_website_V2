<%--
  Created by IntelliJ IDEA.
  User: gerbe
  Date: 20/02/2020
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Bierverzameling van Brouwerij Haacht-formulier</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/Style.css">
    <meta charset="UTF-8">
</head>
<body>
<header>

    <nav>
        <ul>
            <li><a href="index.jsp">home</a></li>
            <li><a href="Verzameling">verzameling</a></li>
            <li><a href="formulier.jsp">formulier</a></li>
        </ul>
    </nav>
    <h1 hidden>De brouwerij van Haacht</h1>
</header>
<main>
    <h2>Hier kan je een bier toevoegen.</h2>
    <form method="post" action="Verzameling" novalidate>

        <fieldset>
            <legend>Voeg een bier toe</legend>
            <p>
                <label for="name">Naam van het bier* </label>
                <input id="name" size="60" maxlength="128" type="text" name="naam" required>
            </p>


            <p>
                <label for="waarde">Alcoholpercentage* </label>
                <input type="number" step="any" name="waarde" id="waarde">
            </p>
            <p>
                <label for="beschrijving">Extra info over het bier. </label>
                <textarea id="beschrijving" cols="60" name="beschrijving" rows="10"></textarea>
            </p>

            <p><input type="submit" id="submit" value="Send"></p>
        </fieldset>
    </form>
    <p><a href="Verzameling">Ga naar de verzameling</a></p>

</main>
<footer>
    <address>&copy;Gerben Piot Website by <a  class="mail" href="mailto:gerben.piot@student.ucll.be"> gerben.piot@student.ucll.be.</a>
    </address>

</footer>
</body>
</html>
