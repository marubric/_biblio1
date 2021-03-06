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
        <title>Search Expression</title>
    </head>
    <body>
        <h1>Search an Expression</h1>
        <form action="searchExpression" method="POST">
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
                            <input type="radio" name="filter" value="work"/>Expression&nbsp;&nbsp;
                            <input type="radio" name="filter" value="form"/>Form&nbsp;&nbsp;</br>
                            <input type="radio" name="filter" value="context"/>Context&nbsp;&nbsp;
                            <input type="radio" name="filter" value="lang"/>Language&nbsp;&nbsp;
                            <input type="radio" name="filter" value="distCha"/>Distinct Characteristic&nbsp;&nbsp;
                            <input type="radio" name="filter" value="criticalRep"/>Critical Response&nbsp;&nbsp;
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
