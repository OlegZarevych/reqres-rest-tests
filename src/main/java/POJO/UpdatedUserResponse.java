package POJO;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public final class UpdatedUserResponse {

    @SerializedName("Name")
    public String Name;

    @SerializedName("Job")
    public String Job;

    @SerializedName("updatedAt")
    public Date updatedAt;
}
