package pl.kowalecki.mybloodapp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BloodDonationList {

    @SerializedName("bloodDonationModelList")
    @Expose
    private List<BloodDonationModel> bloodDonationModelList = null;

    public List<BloodDonationModel> getBloodDonationModelList() {
        return bloodDonationModelList;
    }

    public void setBloodDonationModelList(List<BloodDonationModel> bloodDonationModelList) {
        this.bloodDonationModelList = bloodDonationModelList;
    }

}
