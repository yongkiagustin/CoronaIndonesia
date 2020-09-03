package com.yongki.coronaindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yongki.coronaindonesia.model.DataIndo;
import com.yongki.coronaindonesia.service.ApiClient;
import com.yongki.coronaindonesia.service.GetServices;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://api.kawalcorona.com";
    private static Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView labelSembuh = findViewById(R.id.label_jml_sembuh);
        final TextView labelPositif = findViewById(R.id.label_jml_positif);
        final TextView labelMeninggal = findViewById(R.id.label_jml_Meninggal);
        final TextView labelDirawat = findViewById(R.id.label_jml_dirawat);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .build();
        if(retrofit==null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }

        GetServices getServices = retrofit.create(GetServices.class);
        Call<List<DataIndo>> resultCall = getServices.getListCall();
        resultCall.enqueue(new Callback<List<DataIndo>>() {
            @Override
            public void onResponse(Call<List<DataIndo>> call, Response<List<DataIndo>> response) {
                labelSembuh.setText(response.body().get(0).getSembuh());
                labelPositif.setText(response.body().get(0).getPositif());
                labelMeninggal.setText(response.body().get(0).getMeninggal());
                labelDirawat.setText(response.body().get(0).getDirawat());
            }

            @Override
            public void onFailure(Call<List<DataIndo>> call, Throwable t) {
                Log.d("failure", "Fail");
               // t.printStackTrace();
                t.printStackTrace();
            }
        });
    }

}