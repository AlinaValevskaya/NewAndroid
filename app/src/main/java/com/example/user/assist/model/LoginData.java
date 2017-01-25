package com.example.user.assist.model;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("course")
    @Expose
    private Integer course;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("type")
    @Expose
    private String type;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}