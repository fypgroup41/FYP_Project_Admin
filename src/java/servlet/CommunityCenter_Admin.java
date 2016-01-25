/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.CommunityCenterBean;
import bean.DistrictBean;
import db.CommunityCenterDB;
import db.DistrictDB;
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
@WebServlet(name = "CommunityCenter_Admin", urlPatterns = {"/cc_a"})
public class CommunityCenter_Admin extends HttpServlet {

    CommunityCenterDB db;
    DistrictDB db2;

    public void init() throws ServletException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new CommunityCenterDB(dbUrl, dbUser, dbPassword);
        db2 = new DistrictDB(dbUrl, dbUser, dbPassword);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<CommunityCenterBean> beans = db.queryCC();
        RequestDispatcher rd = null;
        if ("show".equalsIgnoreCase(request.getParameter("action"))) {
            request.setAttribute("activities", beans);
            rd = getServletContext().getRequestDispatcher("/m_communityCenter.jsp");
        } else if ("detail".equalsIgnoreCase(request.getParameter("action"))) {
            int cid = parseInt(request.getParameter("id"));
            CommunityCenterBean bean = db.queryCCByID(cid);
            request.setAttribute("activities", bean);
            rd = getServletContext().getRequestDispatcher("/m_centerDetails.jsp");
        } else if ("addform".equalsIgnoreCase(request.getParameter("action"))) {
            ArrayList<DistrictBean> disbean = db2.queryDistrict();
            request.setAttribute("district", disbean);
            rd = getServletContext().getRequestDispatcher("/m_cc_addForm.jsp");

        } else if ("add".equalsIgnoreCase(request.getParameter("action"))) {
            String name = request.getParameter("cc_name");
            String address = request.getParameter("address");
            String d_id = request.getParameter("d_id");
            String tel = request.getParameter("tel");
            String fax = request.getParameter("fax");
            String email = request.getParameter("email");
            String info = request.getParameter("info");
            if(db. addCC(d_id, name,address, tel, fax, email, info)){
                rd = getServletContext().getRequestDispatcher("/m_cc_control.jsp");
            }

        } else {
            rd = getServletContext().getRequestDispatcher("/manager.jsp");
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
