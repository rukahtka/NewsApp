package sdl.hp.com.newsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<NewsModel> newsModelArrayList;
    RecyclerView.LayoutManager layoutManager;
    RequestQueue requestQueue;
    String url;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lay_fragment_home,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.homeRecyclerView);
        layoutManager = new LinearLayoutManager(getContext(),1,false);
        recyclerView.setLayoutManager(layoutManager);
        requestQueue = Volley.newRequestQueue(getContext());
        url = "https://newsapi.org/v2/top-headlines?country=in&language=en&apiKey=API_KEY";
        newsModelArrayList = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(newsModelArrayList,getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnNewsArticleClickListener(new RecyclerViewAdapter.OnNewsArticleClickListener() {
            @Override
            public void onNewsArticleClick(View v, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("url",newsModelArrayList.get(position).getNewsURL());
                Browser browser = new Browser();
                browser.setArguments(bundle);
                getFragmentManager().beginTransaction().add(R.id.homeContainer,browser).addToBackStack(null).commit();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fetchNews();
        return view;
    }


    public void fetchNews(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equalsIgnoreCase("ok")) {
                        int n = response.getInt("totalResults");
                        if(n > 0) {
                            JSONArray jsonArray = response.getJSONArray("articles");
                            for(int i=0;i<jsonArray.length();i++) {
                                NewsModel newsModel = new NewsModel();
                                JSONObject j = jsonArray.getJSONObject(i);
                                JSONObject j2 = j.getJSONObject("source");
                                if(j2.has("id"))
                                    newsModel.setSourceID(j2.getString("id"));
                                if(j2.has("name"))
                                    newsModel.setSourceNAme(j2.getString("name"));
                                if(j.has("author"))
                                    newsModel.setAuthorName(j.getString("author"));
                                if(j.has("title"))
                                    newsModel.setNewsTitle(j.getString("title"));
                                if(j.has("description"))
                                    newsModel.setNewsDescription(j.getString("description"));
                                if(j.has("url"))
                                    newsModel.setNewsURL(j.getString("url"));
                                if(j.has("urlToImage"))
                                    newsModel.setNewsImageURL(j.getString("urlToImage"));
                                if(j.has("publishedAt"))
                                    newsModel.setNewsPublishTime(j.getString("publishedAt"));
                                newsModelArrayList.add(newsModel);
                                recyclerViewAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}
