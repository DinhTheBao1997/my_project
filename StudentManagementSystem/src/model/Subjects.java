package model;

public class Subjects {
    private String subjectID;
    private String subjectName;
    private int totalLessons;
    private String subjectType;

    public Subjects() {

    }

    public Subjects(String subjectID, String subjectName, String subjectType, int totalLessons) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.totalLessons = totalLessons;
        this.subjectType = subjectType;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public void setTotalLessons(int totalLessons) {
        this.totalLessons = totalLessons;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }
}
