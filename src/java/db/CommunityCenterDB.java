/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.CommunityCenterBean;
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
public class CommunityCenterDB {

    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public CommunityCenterDB(String dburl, String dbUser, String dbPassword) {
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

    public ArrayList<CommunityCenterBean> queryCC() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        ArrayList<CommunityCenterBean> beans = new ArrayList<CommunityCenterBean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM communitycenter";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                CommunityCenterBean bean = new CommunityCenterBean();
                bean.setCommunityCenterID(rs.getString(1));
                bean.setDistrictID(rs.getString(2));
                bean.setName(rs.getString(3));
                bean.setAddress(rs.getString(4));
                bean.setTel(rs.getString(5));
                bean.setFax(rs.getString(6));
                bean.setEmail(rs.getString(7));
                bean.setInfo(rs.getString(8));
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

    public CommunityCenterBean queryCCByID(int cid) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        CommunityCenterBean bean = new CommunityCenterBean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM communitycenter where communityCenterID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, cid);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {

                bean.setCommunityCenterID(rs.getString(1));
                bean.setDistrictID(rs.getString(2));
                bean.setName(rs.getString(3));
                bean.setAddress(rs.getString(4));
                bean.setTel(rs.getString(5));
                bean.setFax(rs.getString(6));
                bean.setEmail(rs.getString(7));
                bean.setInfo(rs.getString(8));

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

    public boolean updateCC(String cid, String d_no, String name, String address, String tel, String fax, String email, String info) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE communitycenter SET districtID=?, name = ?, address=?, tel=?, fax=?, email=?, info=? WHERE communityCenterID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, d_no);
            pStmnt.setString(2, name);
            pStmnt.setString(3, address);
            pStmnt.setString(4, tel);
            pStmnt.setString(5, fax);
            pStmnt.setString(6, email);
            pStmnt.setString(7, info);
            pStmnt.setString(8, cid);

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
    
     public boolean addCC(String did, String name, String address, String tel, String fax, String email, String info){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "Insert into communitycenter values (?,?,?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            String cid = nextCCPK();
            pStmnt.setString(1, cid);
            pStmnt.setString(2, did);
            pStmnt.setString(3, name);
            pStmnt.setString(4, address);
            pStmnt.setString(5, tel);
            pStmnt.setString(6, fax);
            pStmnt.setString(7, email);
            pStmnt.setString(8, info);
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
    
     public String nextCCPK() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String pk = "";
        int pk_i = 0;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT MAX(communityCenterID) FROM communitycenter";
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
}
