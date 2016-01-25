<%-- 
    Document   : m_communityCenter
    Created on : Jan 16, 2016, 11:49:45 AM
    Author     : Anson
--%>
<%@ page import="bean.CommunityCenterBean, bean.UserBean" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserBean ab = (UserBean) session.getAttribute("adminInfo");
            if(ab == null) {
                response.sendRedirect("notLoggedInYet.jsp");
            }
        %>
        <jsp:include page="m_navigation.jsp" />
        <div id="content" class="SITE_STRUCTURE content">
            <div style="display: block;" class="tabs_item" id="order_detail">
                <div id="message3">
                    <%
                        ArrayList<CommunityCenterBean> beans;
                    %>
                    <h1 align="center">Community Center List</h1>
                    <%
                        beans = (ArrayList<CommunityCenterBean>) request.getAttribute("activities");
                        if (beans.size() != 0) {

                            out.println("<table id='message_table'>");
                            //out.println("<colgroup><col style='width:7%'><col style='width:20%'><col style='width:15%'><col style='width:12%'>");
                            //out.println("<col style='width:25%'><col style='width:7%'><col style='width:7m%'><col style='width:7%'></colgroup>");
                            out.println("<tr><th>Community Center ID</th><th>Community Center Name</th><th>Address</th></tr>");
                            for (int i = 0; i < beans.size(); i++) {
                                out.println("<tr><td>" + beans.get(i).getCommunityCenterID() + "</td>");
                                out.println("<td>" + beans.get(i).getName() + "</td>");
                                out.println("<td>" + beans.get(i).getAddress() + "</td>");
                                out.println("<td><a href=\"cc_a?action=detail&id=" + beans.get(i).getCommunityCenterID() + "\">Go to Details</a></td></tr>");
                            }
                            //out.println("</table>");
                        }
                        out.println("<p><div id='btn'>");
                        out.println("</div></p>");
                        //
                    %>
                </div>
            </div>
        </div>

    </body>
</html>
