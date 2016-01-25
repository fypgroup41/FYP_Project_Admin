package servlet;

import bean.UserBean;
import db.UserDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VerifyClientController", urlPatterns = {"/m_client"})
public class VerifyClientController extends HttpServlet {
    UserDB db2;

    public void init() throws ServletException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db2 = new UserDB(dbUrl, dbUser, dbPassword);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        doPost(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        ArrayList<UserBean> users = db2.queryUserUnauthenicate();
        if("verify".equalsIgnoreCase(req.getParameter("action")))
            req.setAttribute("accounts", users);
        if("save".equalsIgnoreCase(req.getParameter("action"))) {
            if(req.getParameter("ValidationID")!=null) {
                String[] validationID = req.getParameterValues("ValidationID");
                if (db2.updateAuthenticated(validationID))
                    req.setAttribute("update", "Y");
                else
                    req.setAttribute("update", "N");
            } else {
                req.setAttribute("update", "NoSelectedItem");
            }
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/m_client.jsp");
        rd.forward(req,res);
    }
}
