package com.example.breakingnews.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.breakingnews.repository.ArticleRepository;
import com.example.breakingnews.response.ArticleResponse;

import static com.example.breakingnews.constants.AppConstant.API_KEY;
import static com.example.breakingnews.constants.AppConstant.ARTICLE_QUERY;
import static com.example.breakingnews.constants.AppConstant.NEWS_CATEGORY;
import static com.example.breakingnews.constants.AppConstant.NEWS_COUNTRY_CODE;
import static com.example.breakingnews.constants.AppConstant.NEWS_LANGUAGE;

public class ArticleViewModel extends AndroidViewModel
{

    private ArticleRepository articleRepository;
    private androidx.lifecycle.LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@androidx.annotation.NonNull Application application)
    {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.
                getSelectedCountryCategoryHeadLines(
                        NEWS_COUNTRY_CODE,
                        NEWS_LANGUAGE,
                        NEWS_CATEGORY,
                        API_KEY);


        //getEveryThing(ARTICLE_QUERY, API_KEY);
    }

    public androidx.lifecycle.LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
}
