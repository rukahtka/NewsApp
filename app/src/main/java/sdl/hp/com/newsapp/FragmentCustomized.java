package sdl.hp.com.newsapp;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentCustomized extends Fragment{

    EditText edtTopic;
    Button btnSearch;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lay_fragment_customized,null);
        edtTopic = (EditText) view.findViewById(R.id.edtTopic);
        btnSearch = (Button) view.findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edtTopic.getText().toString();
                if(str.length() > 0) {
                    str = str.replace(" ", "+");
                    String url = "https://newsapi.org/v2/top-headlines?q="+str+"&sortBy=publishedAt&language=en&apiKey=e4817342ce384e1bac78aa71e63b5ed1";
                    CategoryNews categoryNews = new CategoryNews();
                    Bundle bundle = new Bundle();
                    bundle.putString("url",url);
                    bundle.putString("id","customizedContainer");
                    categoryNews.setArguments(bundle);
                    getFragmentManager().beginTransaction().add(R.id.customizedContainer,categoryNews).addToBackStack(null).commit();

                }

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
