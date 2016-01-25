/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.DistrictBean;
import java.io.IOException;
import static java.lang.Integer.parseInt;
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
public class DistrictDB {
    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public DistrictDB(String dburl, String dbUser, String dbPassword){
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
    
    public ArrayList<DistrictBean> queryDistrict() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        ArrayList<DistrictBean> beans = new ArrayList<DistrictBean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM District";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                DistrictBean bean = new DistrictBean();
                bean.setDistrictID(rs.getString(1));
                bean.setName(rs.getString(2));
                bean.setBeside(rs.getString(3));
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
    public DistrictBean queryDistrictByID(String d_id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        DistrictBean bean = new DistrictBean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM District WHERE districtID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, d_id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                bean.setDistrictID(rs.getString(1));
                bean.setName(rs.getString(2));
                bean.setBeside(rs.getString(3));
                
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
    public boolean addDistrict(String did, String dname, String beside){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "Insert into District values (?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, did);
            pStmnt.setString(2, dname);
            pStmnt.setString(3, beside);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount>=1){
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
    }
    
    public String nextDistrictID() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String pk = "";
        int pk_i = 0;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT MAX(districtID) FROM district";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                pk = rs.getString(1);
            }
            pk_i = parseInt(pk);
            pk_i += 1;
            pk = Integer.toString(pk_i);
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
        return pk;
    }
    
    public boolean updateDistrict(String d_id, String d_name, String beside) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE District SET name = ?, beside=? WHERE districtID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, d_name);
            pStmnt.setString(2, beside);
            pStmnt.setString(3, d_id);

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
