<%-- 
    Document   : m_login
    Created on : Jan 19, 2016, 7:50:32 PM
    Author     : Anson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/loginform.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="m_navigation.jsp" />
        <div id="login">
            <div id="triangle"></div>
            <h1>Welcome!</h1>
            <form action="lc_a?action=authenticate" method="post">
                Admin ID:<input type="text" name="admin_id"/><br/>
                Password:<input type="password"  name="password"/>
                <input type="submit" value="Login" />
            </form>
        </div>
    </body>
</html>
