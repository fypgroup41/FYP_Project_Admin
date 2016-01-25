/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.ActivitiesBean;
import db.ActivitiesDB;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anson
 */
@WebServlet(name = "ActivitiesController_Admin", urlPatterns = {"/ac_a"})
public class ActivitiesController_Admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ActivitiesDB db;

    public void init() throws ServletException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new ActivitiesDB(dbUrl, dbUser, dbPassword);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<ActivitiesBean> beans = db.queryActivities();
        RequestDispatcher rd = null;
        if ("show".equalsIgnoreCase(request.getParameter("action"))) {
            request.setAttribute("activities", beans);
            rd = getServletContext().getRequestDispatcher("/m_showActivities.jsp");
        } else if ("detail".equalsIgnoreCase(request.getParameter("action"))) {
            String aid = request.getParameter("id");
            ActivitiesBean bean = db.queryActivitiesById(aid);
            request.setAttribute("activities", bean);
            rd = getServletContext().getRequestDispatcher("/m_activitityDetails.jsp");
        } else if ("update".equalsIgnoreCase(request.getParameter("action"))) {
            String aid = request.getParameter("hidden");
            String name = request.getParameter("a_name");
            String d_no = request.getParameter("d_no");
            int quota = parseInt(request.getParameter("maxQuota"));
            int remain = parseInt(request.getParameter("remainQuota"));
            int maxAge = parseInt(request.getParameter("ageMax"));
            int minAge = parseInt(request.getParameter("ageMin"));
            String deadline = request.getParameter("deadline");
            String venue = request.getParameter("venue");
            String a_date = request.getParameter("a_date");
            String tag = request.getParameter("tag");
            String description = request.getParameter("description");
            if (db.updateActivity(aid, name, d_no, quota, remain, maxAge, minAge, deadline, venue, a_date, tag, description)) {
                request.setAttribute("activities", beans);
                rd = getServletContext().getRequestDispatcher("/m_showActivities.jsp");
            }
        } else if ("delete".equalsIgnoreCase(request.getParameter("action"))) {

        }

        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
