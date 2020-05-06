package sdl.hp.com.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<NewsModel> newsModelsArrayList;
    Context mContext;


    public interface OnNewsArticleClickListener{
        void onNewsArticleClick(View v, int position);
    }

    OnNewsArticleClickListener onNewsArticleClickListener;

    public RecyclerViewAdapter(ArrayList<NewsModel> newsModelsArrayList, Context mContext) {
        this.newsModelsArrayList = newsModelsArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_views,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageURL = newsModelsArrayList.get(position).getNewsImageURL();
        if(imageURL != null){
            Glide.with(mContext).load(imageURL).into(holder.image);
        }
        else
            holder.image.setImageResource(R.drawable.image_not_available);
        NewsModel n = newsModelsArrayList.get(position);
        if(n.getNewsTitle() != null)
            holder.textViewTitle.setText(n.getNewsTitle());
        if(n.getNewsDescription() != null)
            holder.textDes.setText(n.getNewsDescription());
    }

    @Override
    public int getItemCount() {
        return newsModelsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView textViewTitle;
        TextView textDes;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.recyclerImage);
            textViewTitle = (TextView) itemView.findViewById(R.id.recyclerTextTitle);
            textDes = (TextView) itemView.findViewById(R.id.recyclerTextDes);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
               onNewsArticleClickListener.onNewsArticleClick(v, getPosition());
        }
    }

    public void setOnNewsArticleClickListener(OnNewsArticleClickListener NewsArticleClickListener){
        this.onNewsArticleClickListener = NewsArticleClickListener;
    }
}
