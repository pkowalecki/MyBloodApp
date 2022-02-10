package pl.kowalecki.mybloodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import pl.kowalecki.mybloodapp.R;
import pl.kowalecki.mybloodapp.model.BloodDonationModel;

public class BloodDonationAdapter extends RecyclerView.Adapter<BloodDonationAdapter.BloodDonationViewHolder> {

    Context context;
    ArrayList<BloodDonationModel> bloodDonationModelArrayList;

    public BloodDonationAdapter(Context context, ArrayList<BloodDonationModel> bloodDonationModelArrayList) {
        this.context = context;
        this.bloodDonationModelArrayList = bloodDonationModelArrayList;
    }

    @NonNull
    @Override
    public BloodDonationAdapter.BloodDonationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.blood_item, parent, false);
        return new BloodDonationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BloodDonationAdapter.BloodDonationViewHolder holder, int position) {

        holder.bloodDonationDate.setText(bloodDonationModelArrayList.get(position).getDateDonation());
        holder.bloodDonationAmount.setText(bloodDonationModelArrayList.get(position).getAmonutDonation() + " ml");
        holder.bloodDonationPlace.setText(bloodDonationModelArrayList.get(position).getPlaceDonation());


    }

    @Override
    public int getItemCount() {
        return bloodDonationModelArrayList.size();
    }

    public class BloodDonationViewHolder extends RecyclerView.ViewHolder {
        TextView bloodDonationDate;
        TextView bloodDonationAmount;
        TextView bloodDonationPlace;

        public BloodDonationViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            bloodDonationDate = itemView.findViewById(R.id.blood_donation_date);
            bloodDonationAmount = itemView.findViewById(R.id.blood_donation_amount);
            bloodDonationPlace = itemView.findViewById(R.id.blood_donation_place);
        }
    }
}
