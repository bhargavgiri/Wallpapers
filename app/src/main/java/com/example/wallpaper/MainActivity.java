package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wallpaper.Retrofit.Adeptor;
import com.example.wallpaper.Retrofit.ApiClient;
import com.example.wallpaper.Retrofit.Hit;
import com.example.wallpaper.Retrofit.Rootmodel;
import com.example.wallpaper.Retrofit.Wallpepardata;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {







    RecyclerView recyclerView;
    ArrayList<String> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.R_view11);
        list1=new ArrayList<>();

            Wallpepardata wallpepardata= ApiClient.getdetals();
        Call<Rootmodel> call=wallpepardata.getimagelist("all");
        call.enqueue(new Callback<Rootmodel>() {
            @Override
            public void onResponse(Call<Rootmodel> call, Response<Rootmodel> response) {
                if (response.isSuccessful())
                {
                    Rootmodel rootmodel=response.body();
                    List<Hit> imagelist=rootmodel.getHits();
                    for (int i=0;i<imagelist.size();i++)
                    {
                        String alliamge=imagelist.get(i).getLargeImageURL();
                        list1.add(alliamge);
                        System.out.println(alliamge);
                    }
                    Adeptor adeptor=new Adeptor(MainActivity.this,list1);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adeptor);
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

                }
            }

            @Override
            public void onFailure(Call<Rootmodel> call, Throwable t) {

            }
        });
    }
}