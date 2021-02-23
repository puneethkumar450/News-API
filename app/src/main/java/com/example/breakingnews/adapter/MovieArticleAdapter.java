package com.example.breakingnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.breakingnews.R;
import com.example.breakingnews.model.Article;

import java.util.ArrayList;

public class MovieArticleAdapter extends RecyclerView.Adapter<MovieArticleAdapter.ViewHolder> {

    private Context mContext;
    ArrayList<Article> articleArrayList;

    public MovieArticleAdapter(Context aContext, ArrayList<Article> aArticleArrayList) {
        this.mContext = aContext;
        this.articleArrayList = aArticleArrayList;
    }

    @androidx.annotation.NonNull
    @Override
    public ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup viewGroup, int i) {
        android.view.View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_movie_article,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull ViewHolder aViewHolder, int i)
    {
        Article article=articleArrayList.get(i);
        aViewHolder.mNewsTitle.setText(article.getTitle());
        String lPublished ;
        if(article.getAuthor() != null && article.getAuthor().isEmpty())
        {
            lPublished = "-"+article.getAuthor() +" | "+" Published At: "+article.getPublishedAt();
        }else{
            lPublished = "Published At: "+article.getPublishedAt();
        }
        aViewHolder.mNewsAuthorAndPublishedAt.setText(lPublished);
        aViewHolder.mNewsDescription.setText(article.getDescription());
        Glide.with(mContext)
                .load(article.getUrlToImage())
                .into(aViewHolder.mImgViewCover);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImgViewCover;
        private final android.widget.TextView mNewsTitle;
        private final android.widget.TextView mNewsAuthorAndPublishedAt;
        private final android.widget.TextView mNewsDescription;

        public ViewHolder(@androidx.annotation.NonNull android.view.View itemView) {
            super(itemView);

            mImgViewCover =(ImageView) itemView.findViewById(R.id.imgViewCover);
            mNewsTitle =(android.widget.TextView) itemView.findViewById(R.id.tvTitle);
            mNewsAuthorAndPublishedAt =(android.widget.TextView) itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            mNewsDescription =(android.widget.TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
