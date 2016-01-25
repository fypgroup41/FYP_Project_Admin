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
public class DistrictBean {

    String districtID;
    String name;
    String beside;

    public DistrictBean(String districtID, String name, String beside) {
        this.districtID = districtID;
        this.name = name;
        this.beside = beside;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeside() {
        return beside;
    }

    public void setBeside(String beside) {
        this.beside = beside;
    }

    public DistrictBean() {
    }

}
