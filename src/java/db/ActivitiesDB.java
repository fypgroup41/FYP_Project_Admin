/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.ActivitiesBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anson
 */
public class ActivitiesDB {

    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public ActivitiesDB(String dburl, String dbUser, String dbPassword) {
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

    public ActivitiesBean queryActivitiesById(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        ActivitiesBean bean = new ActivitiesBean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM Activities WHERE activitiesID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                bean.setActivitiesID(rs.getString(1));
                bean.setName(rs.getString(2));
                bean.setDistrictNo(rs.getString(3));
                bean.setQuota(rs.getInt(4));
                bean.setRemain(rs.getInt(5));
                bean.setTargetAgeMax(rs.getInt(6));
                bean.setTargetAgeMin(rs.getInt(7));
                bean.setDeadline(rs.getString(8));
                bean.setVenue(rs.getString(9));
                bean.setDate(rs.getString(10));
                bean.setTag(rs.getString(11));
                bean.setStaffID(rs.getString(12));
                bean.setSqID(rs.getString(13));
                bean.setDescription(rs.getString(14));
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

    public ArrayList<ActivitiesBean> queryActivities() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        ArrayList<ActivitiesBean> beans = new ArrayList<ActivitiesBean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM Activities";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                ActivitiesBean bean = new ActivitiesBean();
                bean.setActivitiesID(rs.getString(1));
                bean.setName(rs.getString(2));
                bean.setDistrictNo(rs.getString(3));
                bean.setQuota(rs.getInt(4));
                bean.setRemain(rs.getInt(5));
                bean.setTargetAgeMax(rs.getInt(6));
                bean.setTargetAgeMin(rs.getInt(7));
                bean.setDeadline(rs.getString(8));
                bean.setVenue(rs.getString(9));
                bean.setDate(rs.getString(10));
                bean.setTag(rs.getString(11));
                bean.setStaffID(rs.getString(12));
                bean.setSqID(rs.getString(13));
                bean.setDescription(rs.getString(14));
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

    public boolean updateActivity(String aid, String name, String d_no, int quota, int remain, int maxAge, int minAge, String deadline, String venue, String a_date, String tag, String description) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE Activities SET name = ?, districtNo=?, quota=?, remain=?, targetAgeMax=?, targetAgeMin=?, deadline=?, venue=?, date=?, tag=?, description=? WHERE activitiesID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, name);
            pStmnt.setString(2, d_no);
            pStmnt.setInt(3, quota);
            pStmnt.setInt(4, remain);
            pStmnt.setInt(5, maxAge);
            pStmnt.setInt(6, minAge);
            pStmnt.setString(7, deadline);
            pStmnt.setString(8, venue);
            pStmnt.setString(9, a_date);
            pStmnt.setString(10, tag);
            pStmnt.setString(11, description);
            pStmnt.setString(12, aid);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
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
}
