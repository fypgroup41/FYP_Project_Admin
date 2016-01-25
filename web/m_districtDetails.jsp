<%-- 
    Document   : m_centerDetails
    Created on : Jan 16, 2016, 1:12:22 PM
    Author     : Anson
--%>
<%@ page import="bean.DistrictBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="m_navigation.jsp" />
        <div id="content" class="SITE_STRUCTURE content">
            <div style="display: block;" class="tabs_item" id="order_detail">
                <div id="message3">
                    <body>
                        <%
                            DistrictBean beans = (DistrictBean) request.getAttribute("district");
                            out.println("<form method='post' action='dc_a?action=update'>");
                            out.println("<input type=\"hidden\" name=\"hidden\" value=\"" + beans.getDistrictID() + "\"/>");
                            out.println("District ID: " + beans.getDistrictID() + "<br/>");
                            out.println("District Name: <input type=\"text\" name=\"d_name\" value=\"" + beans.getName() + "\" /><br/>");
                            out.println("Beside: <input type=\"text\" name=\"beside\" value=\"" + beans.getBeside() + "\" /><br/>");
                            out.println("<button type=\"submit\">Submit Update</button>");
                            out.println("<button type=\"submit\" formaction=\"dc_a?action=show\">Back to list</button>");
                            out.println("</form>");
                        %>
                    </body>
                </div>
            </div>
        </div>
    </body>
</html>
