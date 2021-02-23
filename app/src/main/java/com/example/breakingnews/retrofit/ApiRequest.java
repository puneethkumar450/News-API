package com.example.breakingnews.retrofit;

import com.example.breakingnews.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    //Calling at inital time...

    //HERE COUNTRY 2-letter ISO 3166-1 code of the country you want to get headlines....
    @GET("v2/top-headlines/")
    Call<ArticleResponse> getSelectedCountryHeadLines(
            @Query("country") String query,
            @Query("apikey") String apiKey
    );


    @GET("v2/top-headlines/")
    Call<ArticleResponse> getHeadLines(
            @Query("q") String query,
            @Query("pageSize") String pagesize,
            @Query("sortBy") String sortBy,
            @Query("apikey") String apiKey
    );

    @GET("v2/everything/")
    Call<ArticleResponse> getEveryThing(
            @Query("q") String query,
            @Query("pageSize") String pagesize,
            @Query("sortBy") String sortBy,
            @Query("apikey") String apiKey
    );

    //HERE COUNTRY 2-letter ISO 3166-1 code of the country you want to get headlines....
    //HERE category....
    @GET("v2/top-headlines/")
    Call<ArticleResponse> getSelectedCategoryCountryHeadLines(
            @Query("country") String aCountryCode,
            @Query("category") String aCategory,
            @Query("language") String aLanguage,
            @Query("pageSize") String pagesize,
            @Query("sortBy") String sortBy,
            @Query("apikey") String apiKey
    );
}
