package model;

import com.google.gson.annotations.SerializedName;

public class ScienceModel {
    private String first_name;
    @SerializedName("avatar")
    private String avatar;

    public String getFirst_name() {

        return first_name;
    }

    public String getAvatar() {

        return avatar;
    }
}
