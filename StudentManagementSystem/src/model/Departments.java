package model;

public class Departments {

    //private int num = 0;
    //private int number;
    private String departmentName;
    private String departmentID;

    public Departments() {

    }

    public Departments(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
/*
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
*/
}
