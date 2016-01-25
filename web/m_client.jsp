<%@ page import="bean.UserBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Maintain Member</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css">
        <script src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#main").removeClass('tabs pageActive tab_current');
                $("#client").addClass('tabs pageActive tab_current');
                $("#product").removeClass('tabs pageActive tab_current');
                $("#order").removeClass('tabs pageActive tab_current');

                $('#selectAll').click(function (event) {
                    if (this.checked) {
                        $('.checkbox1').each(function () {
                            this.checked = true;
                        });
                    } else {
                        $('.checkbox1').each(function () {
                            this.checked = false;
                        });
                    }
                });

                $('.checkbox1').click(function (event) {
                    if (!this.checked) {
                        $('#selectAll').each(function () {
                            this.checked = false;
                        });
                    } else if ($('.checkbox1:checked').length == $('.checkbox1').length) {
                        $('#selectAll').each(function () {
                            this.checked = true;
                        });
                    }
                });
            });
        </script>
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
            <div style="display: block;" class="tabs_item" id="select_main">
                <div id="message">
                    <h1 align="center">Member Account Administration</h1>
                    <%
                        ArrayList<UserBean> bean;

                        if (request.getAttribute("accounts") != null) {
                            bean = (ArrayList<UserBean>) request.getAttribute("accounts");
                            out.println(bean.size() + " Member(s) waiting for authenticate");
                            if (bean.size() != 0) {
                                out.println("<form method='post' action='m_client?action=save'>");
                                out.println("<table id='message_table'>");
                                //out.println("<colgroup><col style='width:10%'><col style='width:10%'><col style='width:20'>");
                                //out.println("<col style='width:10%'><col style='width:40%'><col style='width:10%'></colgroup>");
                                out.println("<tr><th>User ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>Tel</th><th>Name In Chinese</th><th>Email</th><th>Validation<input type='checkbox' id='selectAll'/></th></tr>");
                                for (int i = 0; i < bean.size(); i++) {
                                    out.println("<tr><td>" + bean.get(i).getUserID() + "</td>");
                                    out.println("<td>" + bean.get(i).getUserName() + "</td>");
                                    out.println("<td>" + bean.get(i).getFirstName_eng() + "</td>");
                                    out.println("<td>" + bean.get(i).getLastName_eng() + "</td>");
                                    out.println("<td>" + bean.get(i).getSex() + "</td>");
                                    out.println("<td>" + bean.get(i).getTel() + "</td>");
                                    out.println("<td>" + bean.get(i).getName_ch() + "</td>");
                                    out.println("<td>" + bean.get(i).getEmail() + "</td>");
                                    out.println("<td><input type='checkbox' class='checkbox1' name='ValidationID' value='" + bean.get(i).getUserID()+ "'/></td>");
                                }
                                out.println("</table>");
                                out.println("<p><div id='btn'>");
                                out.println("<input class='myButton' type='submit' value='Save'/>");
                                out.println("<input class='myButton' type='reset' value='Cancel'/>");
                                out.println("</div></p>");
                            } else {
                                out.println("<h1>No Member is waited for verify.</h1>");
                            }
                        }
                        if (request.getAttribute("update") != null) {
                            if ("Y".equalsIgnoreCase((String) request.getAttribute("update"))) {
                                out.println("<div><h1>Update Successfully !</h1></div>");
                            } else if ("N".equalsIgnoreCase((String) request.getAttribute("update"))) {
                                out.println("<h1>Update Fail !</h1>");
                            } else {
                                out.println("<h1>Please select at least one account!</h1>");
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
