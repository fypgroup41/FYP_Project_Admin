<%-- 
    Document   : m_dis_addForm
    Created on : Jan 16, 2016, 2:49:23 PM
    Author     : Anson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.DistrictBean, bean.UserBean" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/manager.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <jsp:include page="m_navigation.jsp" />
    <body>
        <%
            UserBean ab = (UserBean) session.getAttribute("adminInfo");
            if(ab == null) {
                response.sendRedirect("notLoggedInYet.jsp");
            }
        %>
        <%
            ArrayList<DistrictBean> beans = (ArrayList<DistrictBean>) request.getAttribute("district");
        %>
        <div id="content" class="SITE_STRUCTURE content">
            <div style="display: block;" class="tabs_item" id="order_detail">
                <div id="message3">
                    <form action="cc_a?action=add" method="post">
                        <h1>New Community Center</h1>
                        Community Center Name: <input type="text" name="cc_name"/><br/>
                        Address: <textarea name="address" col="5"></textarea><br/>
                        District: <select name="d_id">
                            <%
                                for (int i = 0; i < beans.size(); i++) {
                                    out.println("<option value='" + beans.get(i).getDistrictID() + "'>" + beans.get(i).getName() + "</option>");
                                }
                            %>
                        </select><br/>
                        Tel: <input type="text" maxlength="8" name="tel"/><br/>
                        Fax: <input type="text" maxlength="8" name="fax"/><br/>
                        Official Email: <input type="email" name="email"/><br/>
                        Information: <textarea name="info"></textarea><br/>
                        <button type="submit">Add Community Center</button>
                        <input type="reset" value="Reset Column"/>
                        <button type="submit" formaction="m_cc_control.jsp">Back To Community Center Menu</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
