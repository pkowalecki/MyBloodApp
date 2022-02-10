package pl.kowalecki.mybloodapp.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static Retrofit retrofit;
    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = gsonBuilder.create();
    public static final String SERVICE_URL = "http://localhost:8080/bloodDonation/";
    public static final String SERVICE_URL_NEW = "http://10.0.2.2:8080/bloodDonation/";

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl(SERVICE_URL_NEW)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
