<%-- 
    Document   : home
    Created on : 5-Oct-2017, 8:53:46 AM
    Author     : 709317
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${user.username}.</h3>
        <a href="Login?action=logout">Log out</a>
    </body>
</html>
