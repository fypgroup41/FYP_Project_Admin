<%-- 
    Document   : survey_page
    Created on : Jan 22, 2016, 7:41:40 PM
    Author     : Anson
--%>
<%@ page import="db.bean.SurveyQuestionBean, db.bean.UserBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activity Survey</title>
    </head>
    <body>
        <%
            UserBean ubean = (UserBean) session.getAttribute("userInfo");
            SurveyQuestionBean bean = (SurveyQuestionBean) request.getAttribute("survey");
        %>
        <div>
            <form action="" method="post">
                <% bean.getQuestion(); //print question%><br/>
                <input type="hidden" name="member_id" value="<%=ubean.getMemberID()%>"/>
                <input type="hidden" name="user_id" value="<%=ubean.getUserID()%>"/>
                <input type="hidden" name="sqid" value="<%=bean.getSqID()%>"/>
                <%
                    String type = bean.getqTypeID();
                    if (type.equalsIgnoreCase("1")) {//short question
                        out.print("<input type ='text' name='answer'/>");
                    } else if (type.equalsIgnoreCase("2")) {//true or false
                        out.print("<input type ='radio' name='answer' value='yes'/>Yes");
                        out.print("<input type ='radio' name='answer' value='no'/>No");
                    } else if (type.equalsIgnoreCase("3")) {//multiple choice
                        out.print("<input type ='radio' name='answer' value='a'/>A");
                        out.print("<input type ='radio' name='answer' value='b'/>B");
                        out.print("<input type ='radio' name='answer' value='c'/>C");
                        out.print("<input type ='radio' name='answer' value='d'/>D");
                    } else if (type.equalsIgnoreCase("4")) {//Rating
                        out.print("<select name='answer'>");
                        out.print("<option value='1'>1 Star</option>");
                        out.print("<option value='2'>2 Star</option>");
                        out.print("<option value='3' selected='selected'>3 Star</option>");
                        out.print("<option value='4'>4 Star</option>");
                        out.print("<option value='5'>5 Star</option>");
                        out.print("</select>");
                    }
                %>
            </form>
        </div>
    </body>
</html>
