<%-- 
    Document   : login
    Created on : 5-Oct-2017, 8:43:46 AM
    Author     : 709317
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        
        <sait:debug>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>

        
        <ct:login username="${username}" password="${password}" checked="${checked}" message="${message}"/>
    </body>
</html>
