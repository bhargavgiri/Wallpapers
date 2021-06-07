package com.example.wallpaper.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;








public interface Wallpepardata {

@GET("?key=19639300-4dd1e7b84bdccd4785300dc8d")
    Call<Rootmodel>getimagelist(@Query("orientation")String type);
}
