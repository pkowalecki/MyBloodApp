package pl.kowalecki.mybloodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pl.kowalecki.mybloodapp.adapter.BloodDonationAdapter;
import pl.kowalecki.mybloodapp.model.BloodDonationList;
import pl.kowalecki.mybloodapp.model.BloodDonationModel;
import pl.kowalecki.mybloodapp.repository.BloodDonationRepository;
import pl.kowalecki.mybloodapp.viewModel.BloodDonationViewModel;

public class MainActivity extends AppCompatActivity {

    ArrayList<BloodDonationModel> bloodDonationModelArrayList = new ArrayList<>();
    BloodDonationAdapter bloodDonationAdapter;
    RecyclerView mainWindow;
    BloodDonationViewModel bloodDonationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainWindow = findViewById(R.id.rvBloodDonation);

        bloodDonationViewModel = ViewModelProviders.of(this).get(BloodDonationViewModel.class);
        bloodDonationViewModel.init();
        bloodDonationViewModel.getDonationsRepository().observe(this, bloodDonationModel -> {
            List<BloodDonationModel> bloodModel = bloodDonationModel.getBloodDonationModelList();
            bloodDonationModelArrayList.addAll(bloodModel);
            bloodDonationAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (bloodDonationAdapter == null) {
            bloodDonationAdapter = new BloodDonationAdapter(MainActivity.this, bloodDonationModelArrayList);
            mainWindow.setLayoutManager(new LinearLayoutManager(this));
            mainWindow.setAdapter(bloodDonationAdapter);
            mainWindow.setItemAnimator(new DefaultItemAnimator());
            mainWindow.setNestedScrollingEnabled(true);
        } else {
            bloodDonationAdapter.notifyDataSetChanged();
        }
    }
}