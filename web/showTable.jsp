<%-- 
    Document   : newjsp
    Created on : Jan 18, 2016, 5:51:54 PM
    Author     : test
--%>

<%@page import="db.handle.DB_Select"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ taglib uri="/WEB-INF/tlds/ict-taglib2.tld" prefix="ict2" %>

        <%
            String dbUser = this.getServletContext().getInitParameter("dbUsername");
            String dbPassword = this.getServletContext().getInitParameter("dbPassword");
            String dbUrl = this.getServletContext().getInitParameter("dbUrl");
            DB_Select db_select = new DB_Select(dbUrl, dbUser, dbPassword);


        %>
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select *  from  activities")%>" header="activities" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  activitiesrecord")%>" header="activitiesrecord" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  activitybudget")%>" header="activitybudget" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  activitytimetable")%>" header="activitytimetable" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  activitytype")%>" header="activitytype" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  admin")%>" header="admin" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  atype_a")%>" header="atype_a" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  cctype_cc")%>" header="cctype_cc" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  communitycenter")%>" header="communitycenter" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  communitycentertype")%>" header="communitycentertype" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  district")%>" header="district" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  jobrecord")%>" header="jobrecord" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  member")%>" header="member" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  staff")%>" header="staff" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  surveyanswer")%>" header="surveyanswer" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  surveyqtype")%>" header="surveyqtype" />      
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  surveyquestion")%>" header="surveyquestion" />
        <ict2:showtable writer="<%=out%>" aryData="<%=db_select.getSql("select * from  user")%>" header="user" />

        <%-- Comment
                <%@ taglib uri="/WEB-INF/tlds/ict-taglib.tld" prefix="ict" %>
                <ict:example aryDatwriter="<%=db_select.querySelect("select * from activitybudget", "activitybudget")%>" />
                <ict:example aryDatwriter="<%=db_select.querySelect("select * from activities", "activities")%>" />
        --%>

    </body>
</html>
