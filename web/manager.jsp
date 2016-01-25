<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.UserBean" %>
<html>
<head>
    <title>Administration System</title>
    <link href="css/manager.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#main").addClass('tabs pageActive tab_current');
            $("#client").removeClass('tabs pageActive tab_current');
            $("#product").removeClass('tabs pageActive tab_current');
            $("#order").removeClass('tabs pageActive tab_current');
        });
    </script>
</head>
<body>

<jsp:include page="m_navigation.jsp" />
<%
    UserBean ab = (UserBean) session.getAttribute("adminInfo");
    if(ab == null) {
        out.println("<div id=\"login\"><div id=\"triangle\"></div>"
                + "<h1>Welcome!</h1>"
                + "<form action=\"lc_a?action=authenticate\" method=\"post\">"
                + "Admin ID:<input type=\"text\" name=\"admin_id\"/><br/>"
                + "Password:<input type=\"password\"  name=\"password\"/>"
                + "<input type=\"submit\" value=\"Login\" />"
                + "</form>"
                + "</div>");
    }else{
        out.println("<div><h1>Welcome!</h1>Logged in as " + ab.getUserName() + "</div>");
    }
%>
</body>
</html>
