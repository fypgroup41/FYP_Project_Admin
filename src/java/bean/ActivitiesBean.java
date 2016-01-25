package bean;

public class ActivitiesBean {

    String activitiesID;
    String name;
    String districtNo;
    int quota;
    int remain;
    int targetAgeMax;
    int targetAgeMin;
    String deadline;
    String venue;
    String date;
    String tag;
    String staffID;
    String sqID;
    String description;

    public ActivitiesBean(String activitiesID, String name, String districtNo, int quota, int remain, int targetAgeMax, int targetAgeMin, String deadline, String venue, String date, String tag, String staffID, String sqID, String description) {
        this.activitiesID = activitiesID;
        this.name = name;
        this.districtNo = districtNo;
        this.quota = quota;
        this.remain = remain;
        this.targetAgeMax = targetAgeMax;
        this.targetAgeMin = targetAgeMin;
        this.deadline = deadline;
        this.venue = venue;
        this.date = date;
        this.tag = tag;
        this.staffID = staffID;
        this.sqID = sqID;
        this.description = description;
    }

    public ActivitiesBean() {
    }

    public String getActivitiesID() {
        return activitiesID;
    }

    public void setActivitiesID(String activitiesID) {
        this.activitiesID = activitiesID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(String districtNo) {
        this.districtNo = districtNo;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public int getTargetAgeMax() {
        return targetAgeMax;
    }

    public void setTargetAgeMax(int targetAgeMax) {
        this.targetAgeMax = targetAgeMax;
    }

    public int getTargetAgeMin() {
        return targetAgeMin;
    }

    public void setTargetAgeMin(int targetAgeMin) {
        this.targetAgeMin = targetAgeMin;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getSqID() {
        return sqID;
    }

    public void setSqID(String sqID) {
        this.sqID = sqID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
