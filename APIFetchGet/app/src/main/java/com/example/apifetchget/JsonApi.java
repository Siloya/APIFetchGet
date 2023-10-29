package com.example.apifetchget;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonApi {
    @GET("posts") // Replace "endpoint" with the actual endpoint of your API
   // Call<ApiResponse> getData(@Query("param1") String param1, @Query("param2") String param2);
    Call<List<Post>> getPost();
}
