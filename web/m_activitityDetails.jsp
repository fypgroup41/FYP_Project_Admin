<%-- 
    Document   : m_activitityDetails
    Created on : Jan 15, 2016, 9:58:59 PM
    Author     : Anson
--%>
<%@page import="bean.ActivitiesBean, bean.UserBean"%>
<%@ page import="bean.CommunityCenterBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="m_navigation.jsp" />

    <body>
        <%
            UserBean ab = (UserBean) session.getAttribute("adminInfo");
            if (ab == null) {
                response.sendRedirect("notLoggedInYet.jsp");
            }
        %>    
        <div id="content" class="SITE_STRUCTURE content">
            <div style="display: block;" class="tabs_item" id="order_detail">
                <div id="message3">
                    <%
                        try {
                            ActivitiesBean beans = (ActivitiesBean) request.getAttribute("activities");
                            out.println("<form method='post' action='ac_a?action=update'>");
                            out.println("<input type=\"hidden\" name=\"hidden\" value=\"" + beans.getActivitiesID() + "\"/>");
                            out.println("Activity ID: " + beans.getActivitiesID() + "<br/>");
                            out.println("Activity Name: <input type=\"text\" name=\"a_name\" value=\"" + beans.getName() + "\" /><br/>");
                            out.println("District No: <input type=\"text\" name=\"d_no\" value=\"" + beans.getDistrictNo() + "\" /><br/>");
                            out.println("Maximum Quota: <input type=\"number\" name=\"maxQuota\" value=\"" + beans.getQuota() + "\" /><br/>");
                            out.println("Remain Quota: <input type=\"number\" name=\"remainQuota\" value=\"" + beans.getRemain() + "\" /><br/>");
                            out.println("Target Age(Max): <input type=\"number\" name=\"ageMax\" value=\"" + beans.getTargetAgeMax() + "\" /><br/>");
                            out.println("Target Age(Min): <input type=\"number\" name=\"ageMin\" value=\"" + beans.getTargetAgeMin() + "\" /><br/>");
                            out.println("Deadline: <input type=\"text\" name=\"deadline\" value=\"" + beans.getDeadline() + "\" /><br/>");
                            out.println("Venue: <textarea name=\"venue\">" + beans.getVenue() + " </textarea><br/>");
                            out.println("Activity Date: <input type=\"text\" name=\"a_date\" value=\"" + beans.getDate() + "\" /><br/>");
                            out.println("Hash Tag: <input type=\"text\" name=\"tag\" value=\"" + beans.getTag() + "\" /><br/>");
                            out.println("Staff ID: " + beans.getStaffID() + "<br/>");
                            out.println("SQ ID: " + beans.getSqID() + "<br/>");
                            out.println("Description: <textarea name=\"description\" >" + beans.getDescription() + "</textarea><br/>");
                            out.println("<button type=\"submit\">Submit Update</button>");
                            out.println("<button type=\"submit\" formaction=\"ac_a?action=show\">Back to list</button>");
                            out.println("</form>");
                        } catch (Exception ex) {
                            out.println(ex.getMessage());
                        }

                    %>
                    </body>
                </div>
            </div>
        </div>
</html>
