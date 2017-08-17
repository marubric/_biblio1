<%-- 
    Document   : addManifestation
    Created on : 17 août 2017, 14:17:43
    Author     : mrubrice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manifestation</title>
    </head>
    <body>
        <h1>Add an Manifestation to Expression </h1>
        <form action="addWork" method="POST">
            <fieldset>
                <h2> Manifestation </h2>
                <p>
                    <label for="titleM">Title :</label>
                    <input name="titleM" id="titleM" type="text" />
                    
                    <label for="edition">Edition :</label>
                    <input name="edition" id="edition" type="text"/></br>
                    
                    <label for="dateM">Date :</label>
                    <input name="dateM" id="dateM" type="date"/>
                    
                    <label for="state">Statement responsibility :</label>
                    <input name="state" id="state" type="text"/></br>
                    
                    <label for="publication">Publication place :</label>
                    <input name="publication" id="publication" type="text"/>
                    
                    <label for="publisher">Publisher :</label>
                    <input name="publisher" id="publisher" type="text"/></br>
                    
                    <label for="src">Source acquisition :</label>
                    <input name="src" id="src" type="text"/>
                    
                    <label for="typef">Type face :</label>
                    <input name="typeF" id="typeF" type="text"/>
                </p>              
            </fieldset>
            <fieldset>
                <h2> ITEM </h2>
                <p>
                    <label for="identifier">Identifier :</label>
                    <input name="identifier" id="identifier" type="text" />
                    
                    <label for="prov">Provenance :</label>
                    <input name="prov" id="prov" type="text"/></br>
                    
                    <label for="dtI">Exibition Date :</label>
                    <input name="dtI" id="dtI" type="date"/>
                </p>
            </fieldset>
            <p>
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
    </body>
</html>
