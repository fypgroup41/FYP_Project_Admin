package db;

import bean.UserBean;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {

    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public UserDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return DriverManager.getConnection(dburl, dbUser, dbPassword);
    }

    public ArrayList<UserBean> queryUser() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        ArrayList<UserBean> beans = new ArrayList<UserBean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM User WHERE adminID IS NULL";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                UserBean bean = new UserBean();
                bean.setUserID(rs.getString(1));
                bean.setUserName(rs.getString(2));
                bean.setPassword(rs.getString(3));
                bean.setMemberID(rs.getString(4));
                bean.setAdminID("0");
                bean.setStaffID(rs.getString(6));
                bean.setFirstName_eng(rs.getString(7));
                bean.setLastName_eng(rs.getString(8));
                bean.setSex(rs.getString(9));
                bean.setTel(rs.getString(10));
                bean.setName_ch(rs.getString(11));
                bean.setEmail(rs.getString(12));
                bean.setIsAuthenticated(rs.getInt(13));
                beans.add(bean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return beans;
    }
     public UserBean queryAdminById(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        UserBean bean = new UserBean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM User WHERE adminID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                bean.setUserID(rs.getString(1));
                bean.setUserName(rs.getString(2));
                bean.setPassword(rs.getString(3));
                bean.setMemberID(rs.getString(4));
                bean.setAdminID(rs.getString(5));
                bean.setStaffID(rs.getString(6));
                bean.setFirstName_eng(rs.getString(7));
                bean.setLastName_eng(rs.getString(8));
                bean.setSex(rs.getString(9));
                bean.setTel(rs.getString(10));
                bean.setName_ch(rs.getString(11));
                bean.setEmail(rs.getString(12));
                bean.setIsAuthenticated(rs.getInt(13));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bean;
    }
    public boolean adminLogin(String id, String password) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        ArrayList<UserBean> beans = new ArrayList<UserBean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM User WHERE adminID = ? AND password = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            pStmnt.setString(2, password);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
               isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public ArrayList<UserBean> queryUserUnauthenicate() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        ArrayList<UserBean> beans = new ArrayList<UserBean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM User WHERE adminID IS NULL AND isAuthenticated = 0";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                UserBean bean = new UserBean();
                bean.setUserID(rs.getString(1));
                bean.setUserName(rs.getString(2));
                bean.setPassword(rs.getString(3));
                bean.setMemberID(rs.getString(4));
                bean.setAdminID(rs.getString(5));
                bean.setStaffID(rs.getString(6));
                bean.setFirstName_eng(rs.getString(7));
                bean.setLastName_eng(rs.getString(8));
                bean.setSex(rs.getString(9));
                bean.setTel(rs.getString(10));
                bean.setName_ch(rs.getString(11));
                bean.setEmail(rs.getString(12));
                bean.setIsAuthenticated(rs.getInt(13));
                beans.add(bean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return beans;
    }

    public boolean updateAuthenticated(String [] id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
             cnnct = getConnection();
            String preQueryStatement;
            for(int i=0; i<id.length; i++) {
                preQueryStatement = "UPDATE user SET isAuthenticated = 1 WHERE userId = ? ";
                pStmnt = cnnct.prepareStatement(preQueryStatement);
                pStmnt.setString(1, id[i]);
                pStmnt.executeUpdate();
            }
            isSuccess = true;
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    /*public boolean delRecord(String categoryID){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM category WHERE categoryID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, categoryID);
            if (pStmnt.execute()){
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }*/
}
