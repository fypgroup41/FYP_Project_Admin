<%-- 
    Document   : m_centerDetails
    Created on : Jan 16, 2016, 1:12:22 PM
    Author     : Anson
--%>
<%@ page import="bean.CommunityCenterBean" %>
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
                            CommunityCenterBean beans = (CommunityCenterBean) request.getAttribute("activities");
                            out.println("<form method='post' action='cc_a?action=update'>");
                            out.println("<input type=\"hidden\" name=\"hidden\" value=\"" + beans.getCommunityCenterID() + "\"/>");
                            out.println("Community Center ID: " + beans.getCommunityCenterID() + "<br/>");
                            out.println("District ID: <input type=\"text\" name=\"d_no\" value=\"" + beans.getDistrictID() + "\" /><br/>");
                            out.println("Community Center Name: <input type=\"text\" name=\"c_name\" value=\"" + beans.getName() + "\" /><br/>");
                            out.println("Address: <input type=\"text\" name=\"address\" value=\"" + beans.getAddress() + "\" /><br/>");
                            out.println("Tel: <input type=\"text\" name=\"tel\" value=\"" + beans.getTel() + "\" /><br/>");
                            out.println("Fax: <input type=\"text\" name=\"fax\" value=\"" + beans.getFax() + "\" /><br/>");
                            out.println("Email: <input type=\"text\" name=\"email\" value=\"" + beans.getEmail() + "\" /><br/>");
                            out.println("Info: <input type=\"text\" name=\"info\" value=\"" + beans.getInfo() + "\" /><br/>");
                            out.println("<button type=\"submit\">Submit Update</button>");
                            out.println("<button type=\"submit\" formaction=\"cc_a?action=show\">Back to list</button>");
                            out.println("</form>");
                        %>
                    </body>
                </div>
            </div>
        </div>
    </body>
</html>
