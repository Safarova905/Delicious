<%--
  Created by IntelliJ IDEA.
  User: liais
  Date: 09.11.2020
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="Delicious/styles/site.css" rel="stylesheet">
    <script src="Delicious/scripts/jquery.js"></script>
    <script src="Delicious/scripts/site.js"></script>
    <title>Каталог</title>
</head>
<body>
<header>
    <div id="headerInside">
        <div id="logo"></div>
        <div id="companyName">Delicious</div>
        <div id="navWrap">
            <a href="index.html">
                Главная
            </a>
            <a href="shop.html">
                Магазин
            </a>
        </div>
    </div>
</header>
<div style="width: 1100px; margin: 0 auto">
    <div style="width: 1100px; margin: 0 auto">
        <h1>
            Каталог товаров
        </h1>
        <div>
            <div class="shopUnit">
                <img src="http://placehold.it/308x231" />

                <div class="shopUnitName">
                    Название продукта
                </div>
                <div class="shopUnitShortDesc">
                    Здесь будет немного текста описывающего продукт.
                    Здесь будет немного текста описывающего продукт.
                    Здесь будет немного текста описывающего продукт.
                </div>
                <div class="shopUnitPrice">
                    Цена: 0000 $
                </div>
                <a href="product.html" class="shopUnitMore">
                    Подробнее
                </a>
            </div>

            <div class="shopUnit">
                <img src="http://placehold.it/308x231" />

                <div class="shopUnitName">
                    Название продукта
                </div>
                <div class="shopUnitShortDesc">
                    Здесь будет немного текста описывающего продукт.
                    Здесь будет немного текста описывающего продукт.
                    Здесь будет немного текста описывающего продукт.
                </div>
                <div class="shopUnitPrice">
                    Цена: 0000 $
                </div>
                <a href="product.html" class="shopUnitMore">
                    Подробнее
                </a>
            </div>

            <div class="shopUnit">
                <img src="http://placehold.it/308x231" />

                <div class="shopUnitName">
                    Название продукта
                </div>
                <div class="shopUnitShortDesc">
                    Здесь будет немного текста описывающего продукт.
                    Здесь будет немного текста описывающего продукт.
                    Здесь будет немного текста описывающего продукт.
                </div>
                <div class="shopUnitPrice">
                    Цена: 0000 $
                </div>
                <a href="product.html" class="shopUnitMore">
                    Подробнее
                </a>
            </div>
        </div>
    </div>
</div>
<footer>
    <div id="footerInside">

        <div id="contacts">
            <div class="contactWrap">
                <img src="images/envelope.svg" class="contactIcon">
                info@delicious.ru
            </div>
            <div class="contactWrap">
                <img src="images/phone-call.svg" class="contactIcon">
                8 800 555 35 35
            </div>
            <div class="contactWrap">
                <img src="images/placeholder.svg" class="contactIcon">
                Казань, Кремлевская 35
            </div>
        </div>

        <div id="footerNav">
            <a href="#">Главная</a>
            <a href="#">Магазин</a>
        </div>

        <div id="social">
            <img class="socialItem" src="images/vk-social-logotype.svg">
            <img class="socialItem" src="images/google-plus-social-logotype.svg">
            <img class="socialItem" src="images/facebook-logo.svg">
        </div>

        <div id="copyrights">&copy; Delicious</div>
    </div>
</footer>
</body>
</html>
