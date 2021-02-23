package com.example.breakingnews.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.breakingnews.response.ArticleResponse;
import com.example.breakingnews.retrofit.ApiRequest;
import com.example.breakingnews.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private ApiRequest apiRequest;
    private String PAGESIZE= "100";
    private String sortBy= "popularity";
    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }


    /*
     * Gets Head Lines of Selected....
     *
     * @Param CountryCode aCountryCode
     * @Param Language aLanguage
     * @Param Category aCategory
     *
     * */
    public androidx.lifecycle.LiveData<ArticleResponse> getSelectedCountryCategoryHeadLines(
            @NonNull String aCountryCode,
            @NonNull String aLanguage,
            @NonNull String aCategory,
            @NonNull String key)
    {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getSelectedCategoryCountryHeadLines(aCountryCode, aCategory, aLanguage, PAGESIZE, sortBy, key)
                .enqueue(new Callback<ArticleResponse>()
                {
                    @Override
                    public void onResponse(@NonNull Call<ArticleResponse> call, @NonNull Response<ArticleResponse> response) {
                        android.util.Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());

                            android.util.Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                            android.util.Log.d(TAG, "articles size:: " + response.body().getArticles().size());
                            android.util.Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArticleResponse> call, @NonNull Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }



    public androidx.lifecycle.LiveData<ArticleResponse> getEveryThing(
            @NonNull String aQuery, @NonNull String key)
    {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getEveryThing(aQuery, PAGESIZE, sortBy, key)
                .enqueue(new Callback<ArticleResponse>()
                {
                    @Override
                    public void onResponse(@NonNull Call<ArticleResponse> call, @NonNull Response<ArticleResponse> response) {
                        android.util.Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());

                            android.util.Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                            android.util.Log.d(TAG, "articles size:: " + response.body().getArticles().size());
                            android.util.Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArticleResponse> call, @NonNull Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }


    public androidx.lifecycle.LiveData<ArticleResponse> getHeadLines(
            @NonNull String aQuery, @NonNull String key)
    {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getHeadLines(aQuery, PAGESIZE, sortBy, key)
                .enqueue(new Callback<ArticleResponse>()
                {
                    @Override
                    public void onResponse(@NonNull Call<ArticleResponse> call, @NonNull Response<ArticleResponse> response) {
                        android.util.Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());

                            android.util.Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                            android.util.Log.d(TAG, "articles size:: " + response.body().getArticles().size());
                            android.util.Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArticleResponse> call, @NonNull Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
