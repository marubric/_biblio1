<%-- 
    Document   : searchExpression
    Created on : 18 août 2017, 18:58:15
    Author     : mrubrice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Manifestation</title>
    </head>
    <body>
        <h1>Search an Manifestation</h1>
        <form action="searchManifestation" method="POST">
            <fieldset>
                <table>
                    <tr>
                        <th>
                            Type of research
                        </th>
                        <th>
                            Enter a keyword
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="filter" value="title"/>Title&nbsp;&nbsp;
                            <input type="radio" name="filter" value="date"/>Date&nbsp;&nbsp;
                            <input type="radio" name="filter" value="expr"/>Expression&nbsp;&nbsp;
                            <input type="radio" name="filter" value="itm"/>Item&nbsp;&nbsp;</br>
                            <input type="radio" name="filter" value="edition"/>Edition&nbsp;&nbsp;
                            <input type="radio" name="filter" value="publication"/>Publication Place&nbsp;&nbsp;
                            <input type="radio" name="filter" value="publisher"/>Publisher&nbsp;&nbsp;
                            <input type="radio" name="filter" value="typeF"/>Type Face&nbsp;&nbsp;
                            <input type="radio" name="filter" value="manID"/>Manifestation ID&nbsp;&nbsp;
                            <input type="radio" name="filter" value="srcA"/>Source Acquisition&nbsp;&nbsp;
                            <input type="radio" name="filter" value="state"/>Statement Responsibility&nbsp;&nbsp;
                        </td>
                        <td>
                            <input name="content" type="text" />
                        </td>
                    </tr>
                </table>
            </fieldset>
            <p>
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
            </p>
        </form>
    </body>
</html>
