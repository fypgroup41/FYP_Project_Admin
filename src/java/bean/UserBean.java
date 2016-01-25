package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author test
 */
public class UserBean {

    String userID;
    String userName;
    String password;
    String memberID;
    String adminID;
    String staffID;
    String firstName_eng;
    String lastName_eng;
    String sex;
    String tel;
    String name_ch;
    String email;
    int isAuthenticated;

    public UserBean(String userID, String userName, String password, String memberID, String adminID, String staffID, String firstName_eng, String lastName_eng, String sex, String tel, String name_ch, String email, int isAuthenticated) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.memberID = memberID;
        this.adminID = adminID;
        this.staffID = staffID;
        this.firstName_eng = firstName_eng;
        this.lastName_eng = lastName_eng;
        this.sex = sex;
        this.tel = tel;
        this.name_ch = name_ch;
        this.email = email;
        this.isAuthenticated = isAuthenticated;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getFirstName_eng() {
        return firstName_eng;
    }

    public void setFirstName_eng(String firstName_eng) {
        this.firstName_eng = firstName_eng;
    }

    public String getLastName_eng() {
        return lastName_eng;
    }

    public void setLastName_eng(String lastName_eng) {
        this.lastName_eng = lastName_eng;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName_ch() {
        return name_ch;
    }

    public void setName_ch(String name_ch) {
        this.name_ch = name_ch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(int isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public UserBean() {
    }

}
