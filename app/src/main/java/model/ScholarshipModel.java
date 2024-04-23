package model;

import com.google.gson.annotations.SerializedName;

public class ScholarshipModel {

    private String email;
    private String last_name;

    @SerializedName("avatar")
    private String avatar;

    public String getEmail() {
        return email;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
