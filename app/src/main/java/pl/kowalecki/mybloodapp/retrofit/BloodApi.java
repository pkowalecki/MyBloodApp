package pl.kowalecki.mybloodapp.retrofit;

import java.util.List;

import pl.kowalecki.mybloodapp.model.BloodDonationList;
import pl.kowalecki.mybloodapp.model.BloodDonationModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BloodApi {

    @GET("allDonations")
    Call<BloodDonationList> getAllDonations();
}
