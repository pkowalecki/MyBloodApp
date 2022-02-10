package pl.kowalecki.mybloodapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pl.kowalecki.mybloodapp.model.BloodDonationList;
import pl.kowalecki.mybloodapp.model.BloodDonationModel;
import pl.kowalecki.mybloodapp.repository.BloodDonationRepository;

public class BloodDonationViewModel extends ViewModel {

    private LiveData<BloodDonationList> modelMutableLiveData;
    private BloodDonationRepository bloodDonationRepository;

    public void init(){
        if (modelMutableLiveData != null){
            return;
        }

        bloodDonationRepository = BloodDonationRepository.getInstance();
        modelMutableLiveData = bloodDonationRepository.getDonations();
    }

    public LiveData<BloodDonationList> getDonationsRepository(){
        return modelMutableLiveData;
    }

}
