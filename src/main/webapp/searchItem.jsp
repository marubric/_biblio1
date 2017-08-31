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
        <title>Search Item</title>
    </head>
    <body>
        <h1>Search an Expression</h1>
        <form action="searchItem" method="POST">
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
                            <input type="radio" name="filter" value="identifier"/>Identifier&nbsp;&nbsp;
                            <input type="radio" name="filter" value="exhibitionDate"/>Exhibition Date&nbsp;&nbsp;
                            <input type="radio" name="filter" value="provenance"/>Provenance&nbsp;&nbsp;
                            <input type="radio" name="filter" value="manif"/>Manifestation&nbsp;&nbsp;</br>
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
        </hr>
        
        </form>
    </body>
</html>
