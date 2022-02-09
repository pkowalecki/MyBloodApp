package pl.kowalecki.mybloodapp.model;


import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Generated("jsonschema2pojo")
public class BloodDonationModel {

    @SerializedName("bloodId")
    @Expose
    private Integer bloodId;
    @SerializedName("amonutDonation")
    @Expose
    private String amonutDonation;
    @SerializedName("dateDonation")
    @Expose
    private String dateDonation;
    @SerializedName("placeDonation")
    @Expose
    private String placeDonation;

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }

    public String getAmonutDonation() {
        return amonutDonation;
    }

    public void setAmonutDonation(String amonutDonation) {
        this.amonutDonation = amonutDonation;
    }

    public String getDateDonation() {
        return dateDonation;
    }

    public void setDateDonation(String dateDonation) {
        this.dateDonation = dateDonation;
    }

    public String getPlaceDonation() {
        return placeDonation;
    }

    public void setPlaceDonation(String placeDonation) {
        this.placeDonation = placeDonation;
    }

    @Override
    public String toString() {
        return "BloodDonationModel{" +
                "bloodId=" + bloodId +
                ", amonutDonation='" + amonutDonation + '\'' +
                ", dateDonation='" + dateDonation + '\'' +
                ", placeDonation='" + placeDonation + '\'' +
                '}';
    }
}