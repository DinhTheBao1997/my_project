package model;

public class Students {
    private int defaultID = 1510000;
    private int studentID;
    private String fullName;
    private String departmentID;
    private String address;
    private String phoneNumber;

    public Students() {

    }

    public Students(String fullName, String departmentID, String address, String phoneNumber) {
        this.studentID = ++defaultID;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
