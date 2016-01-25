<%-- 
    Document   : m_district_show
    Created on : Jan 19, 2016, 4:53:45 PM
    Author     : Anson
--%>

<%-- 
    Document   : m_communityCenter
    Created on : Jan 16, 2016, 11:49:45 AM
    Author     : Anson
--%>
<%@ page import="bean.DistrictBean" %>
<%@ page import="java.util.ArrayList" %>
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
                    <%
                        ArrayList<DistrictBean> beans;
                    %>
                    <h1 align="center">Community Center List</h1>
                    <%
                        beans = (ArrayList<DistrictBean>) request.getAttribute("district");
                        if (beans.size() != 0) {

                            out.println("<table id='message_table'>");
                            //out.println("<colgroup><col style='width:7%'><col style='width:20%'><col style='width:15%'><col style='width:12%'>");
                            //out.println("<col style='width:25%'><col style='width:7%'><col style='width:7m%'><col style='width:7%'></colgroup>");
                            out.println("<tr><th>District ID</th><th>District Name</th><th>Beside</th></tr>");
                            for (int i = 0; i < beans.size(); i++) {
                                out.println("<tr><td>" + beans.get(i).getDistrictID() + "</td>");
                                out.println("<td>" + beans.get(i).getName() + "</td>");
                                out.println("<td>" + beans.get(i).getBeside() + "</td>");
                                out.println("<td><a href=\"dc_a?action=detail&id=" + beans.get(i).getDistrictID() + "\">Go to Details</a></td></tr>");
                            }
                            //out.println("</table>");
                        }
                        out.println("<p><div id='btn'>");
                        out.println("<input class='myButton' type='submit' value='Back'/>");
                        out.println("</div></p>");
                        //
                    %>
                </div>
            </div>
        </div>

    </body>
</html>
