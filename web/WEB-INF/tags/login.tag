<%-- 
    Document   : login
    Created on : 2-Nov-2017, 9:13:00 AM
    Author     : 709317
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>

<%@attribute name="username"%>
<%@attribute name="password"%>
<%@attribute name="checked"%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h1>Remember Me Login Page</h1>
    <div>
        <form action="Login" method="POST">
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="password" name="password" value="${password}"><br>
            <input type="submit" value="Login"><br><br>
            <input type="checkbox" name="remember" value="true" ${checked}> Remember me<br>
        </form>
    </div>
    
    ${message}