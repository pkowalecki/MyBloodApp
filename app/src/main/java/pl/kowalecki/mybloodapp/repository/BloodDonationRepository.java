package pl.kowalecki.mybloodapp.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pl.kowalecki.mybloodapp.model.BloodDonationList;
import pl.kowalecki.mybloodapp.model.BloodDonationModel;
import pl.kowalecki.mybloodapp.retrofit.BloodApi;
import pl.kowalecki.mybloodapp.retrofit.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BloodDonationRepository {



    private static BloodDonationRepository bloodDonationRepository;
    private final ExecutorService executorService;

    public static BloodDonationRepository getInstance(){
        if (bloodDonationRepository == null){
            bloodDonationRepository = new BloodDonationRepository();
        }
        return bloodDonationRepository;
    }
    private BloodApi bloodApi;

    public BloodDonationRepository(){
        bloodApi = ServiceGenerator.getRetrofit().create(BloodApi.class);
        executorService = Executors.newSingleThreadExecutor();
    }


    public MutableLiveData<BloodDonationList> getDonations(){
            MutableLiveData<BloodDonationList> bloodData = new MutableLiveData<>();
            bloodApi.getAllDonations().enqueue(new Callback<BloodDonationList>() {
                @Override
                public void onResponse(Call<BloodDonationList> call, Response<BloodDonationList> response) {
                    if(response.isSuccessful()){
                            bloodData.setValue(response.body());
                    }

                }

                @Override
                public void onFailure(Call<BloodDonationList> call, Throwable t) {
                    bloodData.setValue(null);
                    Log.e("ERRORMessage", t.getMessage().toString());
                }
        });
        return bloodData;

    }
}

