<%@ page import="bean.ActivitiesBean, bean.UserBean " %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            UserBean ab = (UserBean) session.getAttribute("adminInfo");
            if (ab == null) {
                response.sendRedirect("notLoggedInYet.jsp");
            }
        %>    
        <jsp:include page="m_navigation.jsp" />
        <div id="content" class="SITE_STRUCTURE content">
            <div style="display: block;" class="tabs_item" id="order_detail">
                <div id="message3">
                    <%
                        ArrayList<ActivitiesBean> beans;
                    %>
                    <h1 align="center">Activities List</h1>
                    <%
                        beans = (ArrayList<ActivitiesBean>) request.getAttribute("activities");
                        if (beans.size() != 0) {

                            out.println("<table id='message_table'>");
                            //out.println("<colgroup><col style='width:7%'><col style='width:20%'><col style='width:15%'><col style='width:12%'>");
                            //out.println("<col style='width:25%'><col style='width:7%'><col style='width:7%'><col style='width:7%'></colgroup>");
                            out.println("<tr><th>Activity ID</th><th>Activity Name</th><th>Description</th></tr>");
                            for (int i = 0; i < beans.size(); i++) {
                                out.println("<tr><td>" + beans.get(i).getActivitiesID() + "</td>");
                                out.println("<td>" + beans.get(i).getName() + "</td>");
                                out.println("<td>" + beans.get(i).getDescription() + "</td>");
                                out.println("<td><a href=\"ac_a?action=detail&id=" + beans.get(i).getActivitiesID() + "\">Go to Details</a></td></tr>");
                            }
                            //out.println("</table>");
                        }
                        out.println("<p><div id='btn'>");
                        out.println("<input class='myButton' type='submit' value='Back'/>");
                        out.println("</div></p>");
                        //
%>

                    </body>
                    </html>
