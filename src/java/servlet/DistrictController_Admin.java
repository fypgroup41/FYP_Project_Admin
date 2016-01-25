/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import bean.DistrictBean;
import db.DistrictDB;
import java.io.IOException;
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
@WebServlet(name = "DistrictController_Admin", urlPatterns = {"/dc_a"})
public class DistrictController_Admin extends HttpServlet {
        DistrictDB db;

    public void init() throws ServletException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new DistrictDB(dbUrl, dbUser, dbPassword);
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        RequestDispatcher rd = null;
        if("addForm".equalsIgnoreCase(request.getParameter("action"))){
            rd = getServletContext().getRequestDispatcher("/m_dis_addForm.jsp");
        } 
        else if ("add".equalsIgnoreCase(request.getParameter("action"))) {
            String did = db.nextDistrictID();
            String name = request.getParameter("d_name");
            String beside = request.getParameter("beside");
            if(db.addDistrict(did, name, beside))
                rd = getServletContext().getRequestDispatcher("/m_district.jsp");
        }else if("list".equalsIgnoreCase(request.getParameter("action"))){
            ArrayList<DistrictBean> beans = db.queryDistrict();
            request.setAttribute("district", beans);
            rd = getServletContext().getRequestDispatcher("/m_district_show.jsp");
        }
        else if("detail".equalsIgnoreCase(request.getParameter("action"))){
            String d_id = request.getParameter("id");
            DistrictBean bean = db.queryDistrictByID(d_id);
            request.setAttribute("district", bean);
            rd = getServletContext().getRequestDispatcher("/m_districtDetails.jsp");
        }
        else if("update".equalsIgnoreCase(request.getParameter("action"))){
            String d_id = request.getParameter("hidden");
            String name = request.getParameter("d_name");
            String beside = request.getParameter("beside");
            if(db.updateDistrict(d_id,name,beside)){
                rd = getServletContext().getRequestDispatcher("/m_district.jsp");
            }
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
