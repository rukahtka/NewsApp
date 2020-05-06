package sdl.hp.com.newsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentCategories extends Fragment implements View.OnClickListener {
    TextView catBuiss,catEnter,catGen,catHealth,catScience,catSports,catTech;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lay_fragment_categories,null);
        catBuiss = (TextView) view.findViewById(R.id.catBuissness);
        catEnter = (TextView) view.findViewById(R.id.catEntertainment);
        catGen = (TextView) view.findViewById(R.id.catGeneral);
        catHealth = (TextView) view.findViewById(R.id.catHealth);
        catScience = (TextView) view.findViewById(R.id.catScience);
        catSports = (TextView) view.findViewById(R.id.catSports);
        catTech = (TextView) view.findViewById(R.id.catTechnology);

        catBuiss.setOnClickListener(this);
        catEnter.setOnClickListener(this);
        catGen.setOnClickListener(this);
        catHealth.setOnClickListener(this);
        catScience.setOnClickListener(this);
        catSports.setOnClickListener(this);
        catTech.setOnClickListener(this);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

        String cat = "";


        if(v.getId() == catBuiss.getId())
            cat = "business";
        else if(v.getId() == catEnter.getId())
            cat = "entertainment";
        else if(v.getId() == catGen.getId())
            cat = "general";
        else if(v.getId() == catHealth.getId())
            cat = "health";
        else if(v.getId() == catScience.getId())
            cat = "science";
        else if(v.getId() == catSports.getId())
            cat = "sports";
        else if(v.getId() == catTech.getId())
            cat = "technology";



        String url = "https://newsapi.org/v2/top-headlines?category="+cat+"&country=in&language=en&apiKey=e4817342ce384e1bac78aa71e63b5ed1";
        CategoryNews categoryNews = new CategoryNews();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        bundle.putString("id","categoryContainer");
        categoryNews.setArguments(bundle);
        getFragmentManager().beginTransaction().add(R.id.categoryContainer,categoryNews).addToBackStack(null).commit();


    }
}
